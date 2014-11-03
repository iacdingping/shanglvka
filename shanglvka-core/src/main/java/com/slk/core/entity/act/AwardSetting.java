package com.slk.core.entity.act;

/**
 * 奖品设置
 */
public class AwardSetting {
	private Long itemID ;
	private String itemDesc ;
	private Integer rate ; //百分比的值
	private Long perDayLimit ; //每日数量限制
	private Long activityID ;  //活动ID
	private Long awardID ; //奖品ID
	private String awardDesc ; //奖品名称
	public Long getItemID() {
		return itemID;
	}
	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Long getPerDayLimit() {
		return perDayLimit;
	}
	public void setPerDayLimit(Long perDayLimit) {
		this.perDayLimit = perDayLimit;
	}
	public Long getActivityID() {
		return activityID;
	}
	public void setActivityID(Long activityID) {
		this.activityID = activityID;
	}
	public Long getAwardID() {
		return awardID;
	}
	public void setAwardID(Long awardID) {
		this.awardID = awardID;
	}
	public String getAwardDesc() {
		return awardDesc;
	}
	public void setAwardDesc(String awardDesc) {
		this.awardDesc = awardDesc;
	}
	
	
}
