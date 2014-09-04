package com.slk.wap.controller.info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.CookieUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.cms.service.CommentService;
import com.thinkgem.jeesite.modules.cms.service.VotingLogService;
import com.thinkgem.jeesite.modules.cms.service.VotingService;
import com.thinkgem.jeesite.modules.sys.utils.ResponseBean;

/**
 * 文章查阅相关
 */
@Controller
@RequestMapping(value = "/info/view")
public class InfoViewController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private VotingService votingService;
	@Autowired
	private VotingLogService votingLogService;

	private static final String VOTED_IDS = "voted_ids";

	/**
	 * 文章详情
	 * @return
	 */
	@RequestMapping(value = "/detail/{infoid}")
	public String detail(HttpServletRequest request,@PathVariable String infoid, ModelMap modelMap) {
		modelMap.addAttribute("viewData", articleService.get(infoid));
		modelMap.addAttribute("votings", votingService.listByArticleId(infoid));
		String votedIds=","+CookieUtils.getCookie(request, VOTED_IDS);
		modelMap.addAttribute("isHas", votedIds.indexOf(","+infoid+",")>=0);
		articleService.updateHitsAddOne(infoid);
		return "info/view/detail";
	}
	
	/**
	 * 文章列表
	 * @return
	 */
	@RequestMapping(value = "/infolist/{categoryId}")
	public String infoList(@PathVariable String categoryId, ModelMap modelMap) {
		Category category = categoryService.get(categoryId);
		// 获取文章内容
		Page<Article> notTopPage = new Page<Article>(1, 5);
		Article article = new Article(category);
		article.setPosid("-1");
		notTopPage = articleService.find(notTopPage, article, false);
		
		
		article.setPosid("2");
		Page<Article> topPage = new Page<Article>(1, 5);
		topPage = articleService.find(topPage, article, false);
		
		modelMap.addAttribute("category", category);
		modelMap.addAttribute("notTopPage", notTopPage);
		modelMap.addAttribute("topPage", topPage);
		return "info/view/infolist";
	}
	
	/**
	 * 文章列表
	 * @return
	 */
	@RequestMapping(value = "/ajax/more/{categoryId}")
	@ResponseBody
	public Page<Article> ajaxMore(@PathVariable String categoryId, ModelMap modelMap, 
			@RequestParam(value="page", required=false) Integer page) {
		if(page == null)
			page = 1;
		Category category = categoryService.get(categoryId);
		// 获取文章内容
		Page<Article> notTopPage = new Page<Article>(1, 5);
		Article article = new Article(category);
		article.setPosid("-1");
		notTopPage = articleService.find(notTopPage, article, false);
		return notTopPage;
	}
	
	@RequestMapping("/votingSubmit")
	@ResponseBody
	public ResponseBean checkStoreNameRepeat(HttpServletRequest request,
			HttpServletResponse response, String articleId, String phone,
			String[] voteSelect) {
		ResponseBean rb = new ResponseBean();
		if (votingLogService.checkIsVoted(phone, articleId)) {
			rb.setSuccess(true);
			votingLogService.saveAll(articleId, phone, voteSelect,
					StringUtils.getRemoteAddr(request));
			rb.setMessage("保存成功");
			String votedIds=CookieUtils.getCookie(request, VOTED_IDS);
			votedIds=StringUtils.isEmpty(votedIds)?"":votedIds;
			CookieUtils.setCookie(response, VOTED_IDS,  votedIds+articleId + ",");
		} else {
			rb.setSuccess(false);
			rb.setMessage("该号码已投过票");
		}
		return rb;
	}
}
