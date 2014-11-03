package com.slk.core.entity.act;

import java.util.Date;
import java.util.List;
/**
 * 活动对象
 */	
public class Activity {
	private Long activityID;
	private String name;
	private Date startTime;
	private Date endTime;
	private List<AwardSetting> awardSettings;
	
	
	public Activity() {
	}
	public Activity(Long activityID) {
		this.activityID = activityID;
	}
	public Long getActivityID() {
		return activityID;
	}
	public void setActivityID(Long activityID) {
		this.activityID = activityID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public List<AwardSetting> getAwardSettings() {
		return awardSettings;
	}
	public void setAwardSettings(List<AwardSetting> awardSettings) {
		this.awardSettings = awardSettings;
	}
	@Override
	public String toString() {
		return "Activity [activityID=" + activityID + ", name=" + name
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}
