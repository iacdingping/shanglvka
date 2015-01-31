package com.slk.core.weichat.webservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信系统发送卡号、微信号到卡系统，卡系统把卡号与微信号绑定，存储在卡系统
 * @author iacdp
 *
 */
public class BindParam extends AbstractParam {

	@JsonProperty("WXNO")
	private String weChatNo;
	@JsonProperty("CardNO")
	private String cardNo;
	public BindParam() {
	}
	public BindParam(String weChatNo, String cardNo) {
		this.weChatNo = weChatNo;
		this.cardNo = cardNo;
	}
	public String getWeChatNo() {
		return weChatNo;
	}
	public void setWeChatNo(String weChatNo) {
		this.weChatNo = weChatNo;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@Override
	public String getMethod() {
		return "CardNO_WXNO";
	}
	@Override
	public String getMethodDesc() {
		return "卡号、微信号绑定";
	}
}
