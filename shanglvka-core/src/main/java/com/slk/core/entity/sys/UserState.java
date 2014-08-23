package com.slk.core.entity.sys;

public enum UserState {
	IP_INVALID("非法IP"), 
	DISABLED("禁止登陆"),
	ENABLED("");
	
	private String description;
	private UserState(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
