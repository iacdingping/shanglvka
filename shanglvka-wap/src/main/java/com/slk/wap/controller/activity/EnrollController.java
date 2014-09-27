package com.slk.wap.controller.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.slk.hibernate.core.entity.Enroll;
import com.slk.hibernate.core.service.EnrollService;
import com.slk.wap.common.ConstantActivity;

/**
 * 速来报名 
 */
@Controller
@RequestMapping(ConstantActivity.URI_ENROLL)
public class EnrollController {
	
	@Autowired
	private EnrollService enrollService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		return ConstantActivity.URI_ENROLL+"/index"; 
	}
	
	@RequestMapping("submit")
	public String submit(Enroll enroll, ModelMap model){
		boolean exists = enrollService.exists(enroll.getContactPhone());
		if(exists) {
			model.put("exists", exists);
		} else {
			enrollService.save(enroll);
			model.put("success", true);
		}
		return ConstantActivity.URI_ENROLL+"/index";
	}
}
