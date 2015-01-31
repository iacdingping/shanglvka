package com.slk.wap.controller.activity;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.slk.wap.common.constant.ConstantActivity;
import com.thinkgem.jeesite.common.utils.CookieUtils;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;

/**
 * 签到 
 */
@Controller
@RequestMapping(value=ConstantActivity.URI_SIGN)
public class SignController {
	
	public static final String USER_ID_PREFIX = "user_id:";
	public static final String USER_ID_COOKIE = "user_id";
	public static final String SIGN_TIMESTAMP = "sign_timestamp";
	
	/**
	 * 首页 
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap model){
		model.put("bind", isBindUser(request));
		return ConstantActivity.URI_SIGN+"/index";
	}
	
	/**
	 * 签到
	 */
	@RequestMapping("do")
	public String sign(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model, @RequestParam(required=false) String mobile){
		String signTimeStamp = CookieUtils.getCookie(request, SIGN_TIMESTAMP);
		
		if(!isBindUser(request) && StringUtils.isBlank(mobile)) {
			model.put("invalidOperate", true);
			model.put("message", "非法操作");
			return ConstantActivity.URI_SIGN+"/result";
		}
		
		boolean alreadySign = false;
		
		if(StringUtils.isNumeric(signTimeStamp)) {
			alreadySign = DateUtils.isSameDay(new Date(Long.valueOf(signTimeStamp)), new Date());
		}
		
		if(alreadySign) {
			model.put("alreadySign", alreadySign);
			model.put("message", "您今日已签到！");
		} else {
			model.put("message", "签到成功，获得5个积分！");
			if(mobile!=null){
				CookieUtils.setCookie(response, USER_ID_COOKIE, mobile, 30 * 24 * 60 * 60);
			}
			CookieUtils.setCookie(response, SIGN_TIMESTAMP, System.currentTimeMillis() + "");
		}
		return ConstantActivity.URI_SIGN+"/result";
	}
	
	private boolean isBindUser(HttpServletRequest request) {
		String userId = CookieUtils.getCookie(request, USER_ID_COOKIE);
		return StringUtils.isNotBlank(userId);
	}
}
