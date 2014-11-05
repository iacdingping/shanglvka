package com.slk.core.weichat;

/**
 * 权限类型 基本权限只能获取到用户openid，无需用户授权
 * 用户信息权限需要用户授权，可获取用户信息
 * @author IAC-DINGPING
 *
 */
public enum AuthorizeType {
	BASE("snsapi_base"),
	USER_INFO("snsapi_userinfo");
	private String value;
	private AuthorizeType(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}