package com.slk.wap.controller.info;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.entity.Comment;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.cms.service.CommentService;

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

	/**
	 * 文章详情
	 * @return
	 */
	@RequestMapping(value = "/detail/{infoid}")
	public String detail(@PathVariable String infoid, ModelMap modelMap) {
		modelMap.addAttribute("viewData", articleService.get(infoid));
		Page<Comment> page = new Page<Comment>(1,5);
		Comment comment =  new Comment();
		comment.setContentId(infoid);
		modelMap.addAttribute("commends", commentService.find(page, comment));
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
		Page<Article> page = new Page<Article>(1, 5);
		Article article = new Article(category);
		page = articleService.find(page, article, false);
		if (page.getList().size()>0){
			article = page.getList().get(0);
			articleService.updateHitsAddOne(article.getId());
		}
		modelMap.addAttribute("category", category);
		modelMap.addAttribute("page", page);
		return "info/view/infolist";
	}
}
