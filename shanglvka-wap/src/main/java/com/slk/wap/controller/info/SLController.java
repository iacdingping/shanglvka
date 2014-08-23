package com.slk.wap.controller.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slk.hibernate.core.entity.MerchantMap;
import com.slk.hibernate.core.service.MerchantMapService;

/**
 * 商旅
 */
@Controller
@RequestMapping("/sl")
public class SLController {
	@Autowired
	private MerchantMapService merchantMapService;

	/**
	 * 列表
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("merchantMaps", merchantMapService.list());
		return "/info/sl/list";
	}

	/**
	 * 详情
	 * 
	 * @return
	 */
	@RequestMapping("/detail/{slID}")
	public String detail(Model model,@PathVariable Long slID) {
		MerchantMap merchantMap = merchantMapService.get(slID);
		model.addAttribute("merchantMap", merchantMap);
		return "/info/sl/detail";
	}
}
