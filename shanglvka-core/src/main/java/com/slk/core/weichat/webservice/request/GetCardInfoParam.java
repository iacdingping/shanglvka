package com.slk.core.weichat.webservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 根据卡号、密码查询余额及有效期
 * @author iacdp
 *
 */
public class GetCardInfoParam extends AbstractParam {

	@JsonProperty("CardNO")
	private String cardNo;
	@JsonProperty("Password")
	private String password;
	public GetCardInfoParam() {
	}
	public GetCardInfoParam(String cardNo, String password) {
		super();
		this.cardNo = cardNo;
		this.password = password;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getMethod() {
		return "getCardInfo_WX";
	}
	
	@Override
	public String getMethodDesc() {
		return "查询余额及有效期";
	}
	
}
