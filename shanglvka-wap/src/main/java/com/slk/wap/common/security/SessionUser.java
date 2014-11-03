package com.slk.wap.common.security;

import com.slk.core.entity.mp.WeixinUser;

public class SessionUser {

	private WeixinUser weixinUser;
	private String from;
	public WeixinUser getWeixinUser() {
		return weixinUser;
	}
	public void setWeixinUser(WeixinUser weixinUser) {
		this.weixinUser = weixinUser;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
}
