package com.slk.controller.faq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 我的商旅卡
 * @author yewenqu
 *
 */
@Controller
@RequestMapping(value="/faq/card")
public class MyCardController {

	@RequestMapping
	public String index(){
		return "/faq/card/index";
	}
}
