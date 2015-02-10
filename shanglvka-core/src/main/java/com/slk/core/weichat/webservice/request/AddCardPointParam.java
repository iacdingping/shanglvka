package com.slk.core.weichat.webservice.request;

import com.slk.core.weichat.webservice.PropertyKey;

/**
 * 微信中存在签到送积分，即签到后，由微信发起，绑定到某张商旅卡，增加多少积分，发送到预付费卡系统后，预付费卡系统对该卡进行积分增加
 * @author iacdp
 *
 */
public class AddCardPointParam extends AbstractParam {

	@PropertyKey("WXNO")
	private String weChatNo;
	@PropertyKey("CardNO")
	private String cardNo;
	@PropertyKey("Point")
	private Integer value;
	public AddCardPointParam() {
	}
	public AddCardPointParam(String weChatNo, String cardNo, Integer value) {
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
		return "AddCardPoint_WX";
	}
	
	@Override
	public String getMethodDesc() {
		return "增加积分";
	}
	
}
