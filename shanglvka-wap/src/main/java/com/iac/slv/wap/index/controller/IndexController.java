package com.iac.slv.wap.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("index")
	public String index(){
		return "index";
	}
}
