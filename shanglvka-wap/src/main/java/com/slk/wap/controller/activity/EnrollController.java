package com.slk.wap.controller.activity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slk.wap.common.ConstantActivity;

/**
 * 速来报名 
 */
@Controller
@RequestMapping(ConstantActivity.URI_ENROLL)
public class EnrollController {

	@RequestMapping("/index")
	public String index(){
		return ConstantActivity.URI_ENROLL+"/index"; 
	}
}
