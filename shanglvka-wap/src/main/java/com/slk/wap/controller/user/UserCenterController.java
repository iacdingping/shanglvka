package com.slk.wap.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 个人中心
 */
@Controller
@RequestMapping("uc/")
public class UserCenterController {

	//private static final String URI = "uc/";
	private static final String VIEW_PATH = "user/";
	
	/**首页*/
	@RequestMapping("index")
	public String index(){
		return VIEW_PATH+"index";
	}
	
	/**余额查询*/
	@RequestMapping("yecx")
	public String yecx(){
		return VIEW_PATH+"yecx";
	}
	
	/**交易记录*/
	@RequestMapping("jyjl")
	public String jyjl(){
		return VIEW_PATH+"jyjl";
	}
	
	/**积分查询 */
	@RequestMapping("jfcx")
	public String jfcx(){
		return VIEW_PATH+"jfcx";
	}
	
	/**积分兑换*/
	@RequestMapping("jfdh")
	public String jfdh(){
		return VIEW_PATH+"jfdh";
	}
}
