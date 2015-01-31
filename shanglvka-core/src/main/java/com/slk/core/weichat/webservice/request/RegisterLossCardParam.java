package com.slk.core.weichat.webservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 根据卡号，密码，CVV码，设置卡状态为口头挂失
 * @author iacdp
 *
 */
public class RegisterLossCardParam extends AbstractParam {

	@JsonProperty("CardNO")
	private String cardNo;
	@JsonProperty("Password")
	private String password;
	@JsonProperty("Cvv")
	private String cvv;
	public RegisterLossCardParam() {
	}
	public RegisterLossCardParam(String cardNo, String password, String cvv) {
		super();
		this.cardNo = cardNo;
		this.password = password;
		this.cvv = cvv;
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
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	@Override
	public String getMethod() {
		return "RegisterLossCard_WX";
	}
	
	@Override
	public String getMethodDesc() {
		return "挂失单卡";
	}
	
}
