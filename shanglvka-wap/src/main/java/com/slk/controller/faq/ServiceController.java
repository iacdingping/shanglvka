package com.slk.controller.faq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商旅客服
 * @author yewenqu
 *
 */
@Controller
@RequestMapping(value="/faq/service")
public class ServiceController {

	@RequestMapping
	public String index(){
		return "/faq/service/index";
	}
}
