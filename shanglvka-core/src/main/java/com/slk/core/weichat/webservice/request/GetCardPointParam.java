package com.slk.core.weichat.webservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信中使用发送卡号、微信号，查询积分
 * @author iacdp
 *
 */
public class GetCardPointParam extends AbstractParam {

	@JsonProperty("WXNO")
	private String weChatNo;
	@JsonProperty("CardNO")
	private String cardNo;
	public GetCardPointParam() {
		super();
	}
	public GetCardPointParam(String weChatNo, String cardNo) {
		super();
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
		return "getCardPoint_WX";
	}
	@Override
	public String getMethodDesc() {
		return "微信积分查询";
	}
}
