package com.iac.slv.wap.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/info/view")
public class InfoViewController {
	
	/**
	 * 文章详情
	 * @return
	 */
	@RequestMapping(value="/detail/{infoid}")
	public String detail(@PathVariable long infoid){
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
