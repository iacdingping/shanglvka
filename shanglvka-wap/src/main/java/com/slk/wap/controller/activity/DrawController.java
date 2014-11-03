package com.slk.wap.controller.activity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 抽奖
 */
@Controller
@RequestMapping(value="/act/draw")
public class DrawController {

	@RequestMapping("index")
	public String index(){
		return "/act/draw/index";
	}
}
