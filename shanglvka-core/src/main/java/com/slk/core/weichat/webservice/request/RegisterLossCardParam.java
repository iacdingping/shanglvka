package com.slk.core.weichat.webservice.request;

import com.slk.core.weichat.webservice.PropertyKey;

/**
 * 根据卡号，密码，CVV码，设置卡状态为口头挂失
 * @author iacdp
 *
 */
public class RegisterLossCardParam extends AbstractParam {

	@PropertyKey("CardNO")
	private String cardNo;
	@PropertyKey("Password")
	private String password;
	@PropertyKey("Cvv")
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
