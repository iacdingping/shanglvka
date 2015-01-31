package com.slk.core.weichat.webservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCardPointResponse extends BaseResponse {

	@JsonProperty("Point")
	private Integer point;
	public GetCardPointResponse() {
		super();
	}
	public GetCardPointResponse(Integer result, String errorCode, String errorMsg) {
		super(result, errorCode, errorMsg);
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
}
