package com.slk.core.weichat.webservice.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.slk.core.weichat.webservice.PropertyKey;

@XmlRootElement
public class BaseResponse {

	@PropertyKey("RESULT")
	private Integer result;
	@PropertyKey("ERRORCODE")
	private String errorCode;
	@PropertyKey("ERRORMSG")
	private String errorMsg;
	public BaseResponse() {
	}
	public BaseResponse(Integer result, String errorCode, String errorMsg) {
		this.result = result;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public boolean isSuccess() {
		return this.getResult() != null && this.getResult().intValue() == ResponseResult.SUCCESS.ordinal();
	}
}
