package com.slk.wap.controller.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.cms.entity.Article;
import com.thinkgem.jeesite.modules.cms.entity.Category;
import com.thinkgem.jeesite.modules.cms.service.ArticleService;
import com.thinkgem.jeesite.modules.cms.service.CategoryService;

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

	/**
	 * 文章详情
	 * @return
	 */
	@RequestMapping(value = "/detail/{infoid}")
	public String detail(@PathVariable String infoid, ModelMap modelMap) {
		modelMap.addAttribute("viewData", articleService.get(infoid));
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
		modelMap.addAttribute("category", category);
		modelMap.addAttribute("page", page);
		return "info/view/infolist";
	}
}
