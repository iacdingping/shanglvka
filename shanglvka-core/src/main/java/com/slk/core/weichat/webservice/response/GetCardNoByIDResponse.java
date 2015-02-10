package com.slk.core.weichat.webservice.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.slk.core.weichat.webservice.PropertyKey;

@XmlRootElement
public class GetCardNoByIDResponse extends BaseResponse {

	@PropertyKey("CardNO")
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
