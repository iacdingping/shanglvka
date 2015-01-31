package com.slk.wap.common.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.slk.wap.common.constant.ConstantActivity;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.Encodes;
import com.thinkgem.jeesite.common.web.Servlets;


public class NeedLoginInterceptor extends HandlerInterceptorAdapter {

	private JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(!(handler instanceof HandlerMethod)) 
			return true;
		
		HandlerMethod handler2 = (HandlerMethod) handler;
		NeedLogin login = handler2.getBean().getClass().getAnnotation(NeedLogin.class);
		if (null == login) {
			login = handler2.getMethodAnnotation(NeedLogin.class);
		}
		if (null == login) {
			// 没有声明权限,放行
			return true;
		}
		HttpSession session = request.getSession();
		// 取得session中的用户信息, 以便判断是否登录了系统
		Object user = session.getAttribute(ConstantActivity.SESSION_USER_KEY);
		if (null == user) {
			if(StringUtils.isNotBlank(login.noLloginUrl())) {
				response.sendRedirect(request.getContextPath()+ 
						(login.noLloginUrl().startsWith("/") ? login.noLloginUrl() : "/" + login.noLloginUrl()));
				return false;
			}
			
			//需要登录
			String redirectUrl = Servlets.getRelativeUrl(request);
			redirectUrl = request.getContextPath() + 
					(login.loginUrl().startsWith("/") ? login.loginUrl() : "/" + login.loginUrl()) + "?" +
					login.redirectKey() + "=" + Encodes.urlEncode(redirectUrl);
			if (login.value() == ResultType.page) {
				response.sendRedirect(redirectUrl);
			} else if (login.value() == ResultType.json) {
				// ajax页面的登录
				Servlets.writeResponse(response,
						jsonMapper.toJson(new JsonResult(false, login.message(), true, null)));
			}
			return false;
		}
		return true;
	}
}
