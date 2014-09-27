package com.slk.wap.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slk.hibernate.core.entity.BusinessCard;
import com.slk.hibernate.core.service.BusinessCardService;

/**
 * 我的商旅卡
 */
@Controller
@RequestMapping("/card")
public class MyCardController {
	@Autowired
	private BusinessCardService businessCardService;

	@RequestMapping("/index")
	public String index(BusinessCard businessCard,Model model) {
		model.addAttribute("businessCard", businessCardService.get(1L));
		return "/card/index";
	}

	@RequestMapping("detail")
	public String detail() {
		return "/card/detail";
	}
}
