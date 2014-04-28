package com.slk.controller.play;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 签到
 * @author yewenqu
 *
 */
@Controller
@RequestMapping(value="/play/si")
public class SignInController {
	
	@RequestMapping
	public String signIn(){
		return "/play/si/index";
	}
}
