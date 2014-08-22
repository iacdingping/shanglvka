package com.slk.wap.controller.info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商旅
 */
@Controller
@RequestMapping("/sl")
public class SLController {
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		return "/info/sl/list";
	}
	
	/**
	 * 详情
	 * @return
	 */
	@RequestMapping("/detail/{slID}")
	public String detail(){
		return "/info/sl/detail";
	}
}
