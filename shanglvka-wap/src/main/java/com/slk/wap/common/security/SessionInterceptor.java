package com.slk.wap.common.security;

	import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.slk.core.entity.mp.WeixinUser;
import com.slk.core.manager.mp.WeixinUserManager;
import com.slk.wap.common.constant.ConstantActivity;
import com.thinkgem.jeesite.common.web.Servlets;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory
			.getLogger(SessionInterceptor.class);
	
	@Autowired
	private WeixinUserManager weixinUserManager;

	// 重写 preHandle()方法，在业务处理器处理请求之前对该请求进行拦截处理
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 404 的url 直接返回
		if (!(handler instanceof HandlerMethod))
			return true;

		preparedSessionUser(request, response);
		logUerOperation(request, response);
		return true;
	}

	/**
	 * 查看用户是否登录，如未登录到cookie中找用户信息 from=weixin 查询绑定号码 > 免登陆 > cookie
	 * 在获取免登陆时候会判定是否在appkey表中有来源记录 需要注意不存在的时候 mobile 为null 直接返回不记载from参数
	 * 
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	private void preparedSessionUser(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		String uri = request.getRequestURI();
		
		HttpSession session = request.getSession();
		SessionUser user = (SessionUser)session.getAttribute(ConstantActivity.SESSION_USER_KEY);
		if(user == null) {
			user = new SessionUser();
			session.setAttribute(ConstantActivity.SESSION_USER_KEY, user);
		}
		
		String openid = request.getParameter(ConstantActivity.PLATFORM_PARAM);
		if(StringUtils.isNotBlank(openid)) {
			Servlets.setCookieOnce(response, ConstantActivity.PLATFORM_PARAM, openid);
			
			WeixinUser weixinUser = weixinUserManager.getbyPlatformCode(openid);
			user.setWeixinUser(weixinUser);
		}
	}

	/**
	 * 用户操作记载日志
	 * 
	 * @throws IOException
	 */
	private void logUerOperation(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
