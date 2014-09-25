package com.slk.wap.controller.activity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slk.wap.common.ConstantActivity;

/**
 * 签到 
 */
@Controller
@RequestMapping(value=ConstantActivity.URI_SIGN)
public class SignController {
	
	/**
	 * 进入 
	 */
	@RequestMapping("/index")
	public String sign(){
		return ConstantActivity.URI_SIGN+"/index";
	}
}
