package com.slk.controller.play;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 投票
 * @author yewenqu
 *
 */
@Controller
@RequestMapping(value="/play/vote")
public class VoteController {

	@RequestMapping
	public String index(){
		return "/play/vote/index";
	}
}
