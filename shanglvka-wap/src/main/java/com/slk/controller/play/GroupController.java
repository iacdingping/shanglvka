package com.slk.controller.play;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拉帮结派
 * @author yewenqu
 *
 */
@Controller
@RequestMapping(value="/play/group")
public class GroupController {

	@RequestMapping
	public String index(){
		return "/play/group/index";
	}
}
