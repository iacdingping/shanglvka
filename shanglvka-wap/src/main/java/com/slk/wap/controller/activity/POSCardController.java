package com.slk.wap.controller.activity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *刷卡达人
 *
 */
@Controller
@RequestMapping("/act/pos")
public class POSCardController {
	@RequestMapping("/index")
	public String index(){
		return "/act/pos/index";
	}
}
