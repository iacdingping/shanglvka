package com.slk.wap.controller.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.cms.service.CommentService;
import com.thinkgem.jeesite.modules.cms.service.VotingService;

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

	/**
	 * 文章详情
	 * @return
	 */
	@RequestMapping(value = "/detail/{infoid}")
	public String detail(@PathVariable String infoid, ModelMap modelMap) {
		modelMap.addAttribute("viewData", articleService.get(infoid));
		modelMap.addAttribute("votings", votingService.listByArticleId(infoid));
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
}
