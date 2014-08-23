package com.slk.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

import com.slk.service.ShiroDbRealm.ShiroUser;

@Component
public class UserUtil {

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	public ShiroUser getCurrentUser() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user;
	}
}
