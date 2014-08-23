package com.iac.slv.weixin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微信入口
 */
@Controller
@RequestMapping(value="/weixin")
public class WeixinController {

	@RequestMapping(value="")
	public String index(HttpServletRequest request , HttpServletResponse response){
		System.out.println("a");
		System.out.println(request.getAttribute("echostr"));
		return "index";
	}
}
