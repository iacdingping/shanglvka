package com.slv.wap.weixin.instruction;

/**
 * 回复文档
 * @author "iacdp"
 *
 */
public enum ResponseType {
	TEXT(0, "文本消息"),
	NEWS(1, "图文消息"),
	MUSIC(2, "音乐消息");
	
	private Integer value;
	private String desc;
	
	private ResponseType(Integer value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
