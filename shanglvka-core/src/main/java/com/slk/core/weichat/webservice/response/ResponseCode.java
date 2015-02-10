package com.slk.core.weichat.webservice.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum ResponseCode {
	SUCCESS("000000", "请求成功"),
	INVALID_SERVICE("-1000000", "内部服务错误");
	
	private String code;
	private String message;
	private ResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
