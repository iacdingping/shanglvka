package com.slk.core.weichat.webservice.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.slk.core.weichat.webservice.PropertyKey;

@XmlRootElement
public class GetCardPointResponse extends BaseResponse {

	@PropertyKey("Point")
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
