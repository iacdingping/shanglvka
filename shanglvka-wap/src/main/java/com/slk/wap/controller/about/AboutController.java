package com.slk.wap.controller.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用的 
 */
@Controller
@RequestMapping("/about")
public class AboutController {

	/**
	 * 暂用， WAP页面中的相关元素获取
	 * @return
	 */
	@RequestMapping(value="ui")
	public String ui(){
		return "/ui";
	}
	
	@RequestMapping(value="/come")
	public String come(){
		return "/about/come";
	}
}
