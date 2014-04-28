package com.slk.controller.play;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 报名
 * @author yewenqu
 *
 */
@Controller
@RequestMapping(value="/play/su")
public class SignUpController {
	
	@RequestMapping
	public String index(){
		return "/play/su/index";
	}
}
