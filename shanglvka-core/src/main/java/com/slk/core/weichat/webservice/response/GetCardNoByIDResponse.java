package com.slk.core.weichat.webservice.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class GetCardNoByIDResponse extends BaseResponse {

	@JsonProperty("CardNO")
	private List<String> cardNos;
	public GetCardNoByIDResponse() {
		super();
	}
	public GetCardNoByIDResponse(Integer result, String errorCode, String errorMsg) {
		super(result, errorCode, errorMsg);
	}
	public List<String> getCardNos() {
		return cardNos;
	}
	public void setCardNos(List<String> cardNos) {
		this.cardNos = cardNos;
	}
}
