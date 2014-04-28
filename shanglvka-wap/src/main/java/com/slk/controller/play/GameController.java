package com.slk.controller.play;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 游戏
 * @author yewenqu
 *
 */
@Controller
@RequestMapping(value="/paly/game")
public class GameController {

	@RequestMapping
	public String index(){
		return "/play/game/index";
	}
}
