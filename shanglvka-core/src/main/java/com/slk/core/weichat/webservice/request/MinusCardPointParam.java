package com.slk.core.weichat.webservice.request;

import com.slk.core.weichat.webservice.PropertyKey;

/**
 * 微信中使用积分兑换功能，由微信发起，减少多少积分，发送到预付费卡系统后，预付费卡系统对该卡进行积分减少
 * @author iacdp
 *
 */
public class MinusCardPointParam extends AbstractParam {

	@PropertyKey("WXNO")
	private String weChatNo;
	@PropertyKey("CardNO")
	private String cardNo;
	@PropertyKey("Point")
	private Integer value;
	public MinusCardPointParam() {
		super();
	}
	public MinusCardPointParam(String weChatNo, String cardNo, Integer value) {
		super();
		this.weChatNo = weChatNo;
		this.cardNo = cardNo;
		this.value = value;
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
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public String getMethod() {
		return "MinusCardPoint_WX";
	}
	@Override
	public String getMethodDesc() {
		return "微信积分减少";
	}
}
