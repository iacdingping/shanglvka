package com.slk.core.weichat.webservice.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinkgem.jeesite.common.utils.DateUtils;

public class GetCardNoResponse extends BaseResponse {

	@JsonProperty("Money")
	private Float money;
	@JsonProperty("Deadline")
	private String validTime;
	public GetCardNoResponse() {
		super();
	}
	public GetCardNoResponse(Integer result, String errorCode, String errorMsg) {
		super(result, errorCode, errorMsg);
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	public String getValidTime() {
		return validTime;
	}
	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}
	@JsonIgnore
	public Date getValidTimeAsDate() {
		return DateUtils.parseDate(validTime);
	}
}
