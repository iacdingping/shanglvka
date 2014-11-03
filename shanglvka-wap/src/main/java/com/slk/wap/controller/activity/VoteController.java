package com.slk.wap.controller.activity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 投票
 *
 */
@Controller
@RequestMapping("/act/vote")
public class VoteController {

	@RequestMapping("/detail/{voteID}")
	public String detail(){
		return "/act/vote/detail";
	}
}
