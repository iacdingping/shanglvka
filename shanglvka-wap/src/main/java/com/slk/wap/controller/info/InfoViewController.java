package com.slk.wap.controller.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.modules.cms.service.ArticleService;

/**
 *  文章查阅相关
 */
@Controller
@RequestMapping(value="/info/view")
public class InfoViewController {
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 文章详情
	 * @return
	 */
	@RequestMapping(value="/detail/{infoid}")
	public String detail(@PathVariable String infoid , ModelMap modelMap){
		modelMap.addAttribute("viewData" , articleService.get(infoid));
		return "info/view/detail";
	}
	
	/**
	 * 文章列表
	 * @return
	 */
	@RequestMapping(value="/infolist/{classid}")
	public String infoList(@PathVariable long classid){
		return "info/view/infolist";
	}
}
