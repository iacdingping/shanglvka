package com.slk.wap.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slk.core.weichat.webservice.ShangLvSoapClient;
import com.slk.wap.common.constant.ConstantActivity;
import com.slk.wap.common.security.NeedLogin;
import com.slk.wap.common.security.SessionUser;


/**
 * 个人中心
 * 未登录的跳转至首页
 */
@Controller
@RequestMapping("uc/")
@NeedLogin(noLoginUrl="/")
public class UserCenterController {

	@Autowired
	private ShangLvSoapClient shanglvSoapClient;
	
	//private static final String URI = "uc/";
	private static final String VIEW_PATH = "user/";
	
	/**首页*/
	@RequestMapping("index")
	public String index(){
		return VIEW_PATH+"index";
	}
	
	/**余额查询*/
	@RequestMapping("yecx")
	public String yecx(HttpServletRequest request, ModelMap map){
		HttpSession session = request.getSession();
		SessionUser user = (SessionUser)session.getAttribute(ConstantActivity.SESSION_USER_KEY);
		
		//本地绑定记录查询 如过没有则提示用户去购买
		// 存在绑定的卡 用户输入密码 然后查询
		shanglvSoapClient.getCardInfo(user.getWeixinUser().getPlatformCode(), "password");
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
