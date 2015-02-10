package com.slk.core.weichat.webservice.response;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinkgem.jeesite.common.utils.DateUtils;

@XmlRootElement
public class GetCardInfoResponse extends BaseResponse {

	@JsonProperty("Money")
	private Float money;
	@JsonProperty("Deadline")
	private String validTime;
	public GetCardInfoResponse() {
		super();
	}
	public GetCardInfoResponse(Integer result, String errorCode, String errorMsg) {
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
