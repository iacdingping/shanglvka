package com.slk.core.weichat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessToken {
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("expires_in")
	private Integer expires;
	@JsonProperty("refresh_token")
	private String refreshToken;
	@JsonProperty("openid")
	private String openid;
	@JsonProperty("scope")
	private String scope;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Integer getExpires() {
		return expires;
	}
	public void setExpires(Integer expires) {
		this.expires = expires;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
}
