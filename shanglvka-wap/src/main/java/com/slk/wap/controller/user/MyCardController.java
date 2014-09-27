package com.slk.wap.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 我的商旅卡 
 */
@Controller
@RequestMapping("/card")
public class MyCardController {

	@RequestMapping("/index")
	public String index(){
		return "/card/index";
	}
	
	@RequestMapping("detail")
	public String detail(){
		return "/card/detail";
	}
}
