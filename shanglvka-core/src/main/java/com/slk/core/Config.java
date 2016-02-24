package com.slk.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

	@Value("${upload.prefix.url}")
	private String uploadUrlPrefix;
	
	@Value("${soap.wechat.url}")
	private String url = "http://localhost:7000/services/Service";
	@Value("${soap.wechat.username}")
	public String userName = "harmony3";
	@Value("${soap.wechat.password}")
	public String password = "harmony3";
	@Value("${soap.wechat.path}")
	private String path = "harmony.services.user.Pay.WX";

	public String getUploadUrlPrefix() {
		return uploadUrlPrefix;
	}

	public void setUploadUrlPrefix(String uploadUrlPrefix) {
		this.uploadUrlPrefix = uploadUrlPrefix;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
