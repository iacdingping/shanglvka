package com.thinkgem.jeesite.modules.sys.utils;

/**
 * ajax返回类
 * @author 施浩
 *
 */
public class ResponseBean {

	private boolean success = false;;
	
	private String message;
	
	private Object result;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
}
