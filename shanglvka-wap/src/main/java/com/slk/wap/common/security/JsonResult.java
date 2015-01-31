package com.slk.wap.common.security;

/**
 * ajax request returned object
 * @author dingp
 *
 */
public class JsonResult {

	private boolean success;
	private String message;	
	private boolean needLogin;
	private Object object;		//external information
	
	public JsonResult(boolean success, String message, boolean needLogin, Object object) {
		super();
		this.success = success;
		this.message = message;
		this.needLogin = needLogin;
		this.object = object;
	}

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
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public boolean isNeedLogin() {
		return needLogin;
	}
	public void setNeedLogin(boolean needLogin) {
		this.needLogin = needLogin;
	}
}
