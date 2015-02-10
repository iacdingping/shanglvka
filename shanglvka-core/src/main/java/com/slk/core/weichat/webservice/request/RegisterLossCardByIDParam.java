package com.slk.core.weichat.webservice.request;

import com.slk.core.weichat.webservice.PropertyKey;

/**
 * 根据身份证号码获取所有名下的卡，设置卡状态为口头挂失。
 * @author iacdp
 *
 */
public class RegisterLossCardByIDParam extends AbstractParam {

	@PropertyKey("IDNO")
	private String identificationCard;
	public RegisterLossCardByIDParam() {
	}
	public RegisterLossCardByIDParam(String identificationCard) {
		this.identificationCard = identificationCard;
	}
	public String getIdentificationCard() {
		return identificationCard;
	}
	public void setIdentificationCard(String identificationCard) {
		this.identificationCard = identificationCard;
	}
	@Override
	public String getMethod() {
		return "RegisterLossCardByIDNO_WX";
	}
	
	@Override
	public String getMethodDesc() {
		return "挂失身份证下所有卡号";
	}
	
}
