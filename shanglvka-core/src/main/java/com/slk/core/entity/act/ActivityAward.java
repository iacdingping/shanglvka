package com.slk.core.entity.act;

/**
 * 活动奖品
 */
public class ActivityAward {
	private Long awardID;
	private String name;
	private Integer type; //奖品类型
	private String needAttribute;//奖品属性
	private String extraAttribute;//额外属性
	
	public final static int TYPE_NOT_AWARD = 0; //未中奖类型
	public final static int TYPE_OF_TEL_CHARGE = 1; //话费类型
	
	/**
	 * 未中奖实例
	 * @return
	 */
	public static  ActivityAward NoAward(){
		ActivityAward aa = new ActivityAward();
		aa.setName("未中奖");
		aa.setAwardID(-1L);
		aa.setType(TYPE_NOT_AWARD);
		aa.setNeedAttribute("未中奖");
		return aa;
	}
	
	public Long getAwardID() {
		return awardID;
	}
	public void setAwardID(Long awardID) {
		this.awardID = awardID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getNeedAttribute() {
		return needAttribute;
	}
	public void setNeedAttribute(String needAttribute) {
		this.needAttribute = needAttribute;
	}
	public String getExtraAttribute() {
		return extraAttribute;
	}
	public void setExtraAttribute(String extraAttribute) {
		this.extraAttribute = extraAttribute;
	}

	@Override
	public String toString() {
		return "ActivityAward [awardID=" + awardID + ", name=" + name
				+ ", type=" + type + ", needAttribute=" + needAttribute
				+ ", extraAttribute=" + extraAttribute + "]";
	}
	
}
