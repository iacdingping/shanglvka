package com.slk.wap.controller.activity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slk.core.entity.act.ActivityAward;
import com.slk.wap.common.constant.ConstantActivity;
import com.slk.wap.service.activity.DrawService;

/**
 * 
 * 抽奖
 */
@Controller
@RequestMapping(value="/act/draw")
public class DrawController {

	@Autowired
	private DrawService ds;
	
	@RequestMapping("index")
	public String index(){
		return "/act/draw/index";
	}
	
	@RequestMapping("/ajax-draw")
	public Map<String , Object> draw(){
		Map<String , Object> map =new HashMap<String, Object>();
		ActivityAward aa = ds.draw(ConstantActivity.DRAW_ACTIVIT_ID);
		map.put("result", aa);
		return map;
	}
}
