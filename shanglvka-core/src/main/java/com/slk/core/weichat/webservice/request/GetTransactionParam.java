package com.slk.core.weichat.webservice.request;

import com.slk.core.weichat.webservice.PropertyKey;

/**
 * 根据卡号、密码、起止交易时间查询交易记录。
 * @author iacdp
 *
 */
public class GetTransactionParam extends AbstractParam {

	@PropertyKey("CardNO")
	private String cardNo;
	@PropertyKey("Password")
	private String password;
	@PropertyKey("BeginTime")
	private String beginTime;
	@PropertyKey("EndTime")
	private String endTime;
	public GetTransactionParam() {
	}
	public GetTransactionParam(String cardNo, String password,
			String beginTime, String endTime) {
		super();
		this.cardNo = cardNo;
		this.password = password;
		this.beginTime = beginTime;
		this.endTime = endTime;
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
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String getMethod() {
		return "getTransactionLog_WX";
	}
	
	@Override
	public String getMethodDesc() {
		return "查询交易记录";
	}
	
}
