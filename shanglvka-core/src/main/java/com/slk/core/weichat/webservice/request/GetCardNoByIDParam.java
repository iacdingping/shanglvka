package com.slk.core.weichat.webservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 根据身份证号查询名下所有卡号集合
 * @author iacdp
 *
 */
public class GetCardNoByIDParam extends AbstractParam {

	@JsonProperty("IDNO")
	private String identificationCard;
	public GetCardNoByIDParam() {
	}
	public GetCardNoByIDParam(String identificationCard) {
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
		return "getCardNOByIDNO_WX";
	}
	
	@Override
	public String getMethodDesc() {
		return "查询身份证下卡号集合";
	}
	
}
