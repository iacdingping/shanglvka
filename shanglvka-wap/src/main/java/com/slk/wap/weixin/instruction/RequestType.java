package com.slk.wap.weixin.instruction;

/**
 * 微信请求类型
 * @author "iacdp"
 *
 */
public enum RequestType {
	TEXT(0, "text", "文本"),
	IMAGE(2, "image", "图片"),
	LOCATION(3, "location", "地理位置"),
	LINK(4, "link", "链接消息"),
	EVENT(5, "event", "事件推送。事件类型，subscribe(订阅)、unsubscribe(取消订阅)、CLICK(自定义菜单点击事件)"),
	
	VOICE(6, "voice", "声音消息");
	
	private Integer type;
	private String value;
	private String desc;
	
	private RequestType(Integer type, String value, String desc) {
		this.type = type;
		this.value = value;
		this.desc = desc;
	}
	
	public static RequestType getByValue(String value) {
		for(RequestType rt : RequestType.values()) {
			if(rt.getValue().equals(value))
				return rt;
		}
		throw new RuntimeException("unknown value of request type.");
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
