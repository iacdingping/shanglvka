package com.slk.wap.service.activity;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.slk.core.entity.act.Activity;
import com.slk.core.entity.act.ActivityAward;
import com.slk.core.entity.act.AwardSetting;
import com.slk.wap.common.utils.NumberUtils;

@Service
public class DrawService {

	/**
	 * 根据ID获取活动
	 * 
	 * @param activityId
	 * @return
	 */
	public Activity getActivity(long activityID) {
		return new Activity(activityID);
	}

	/**
	 * 获取活动奖品配置
	 * 
	 * @param activityID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AwardSetting> getAwardSettings(long activityID) {
		return Collections.EMPTY_LIST;
	}
	/**
	 * 根据ID获取奖品
	 * @param awardID
	 * @return
	 */
	public ActivityAward getActivityAwardByID(long awardID){
		return null;
	}
	
	/**
	 * 抽奖业务(没有抽奖权限的限制，随便玩~)
	 * @param activityID
	 * @return
	 */
	public ActivityAward draw(long activityID){
		List<AwardSetting> awardSettings = getAwardSettings(activityID);
		ActivityAward result = ActivityAward.NoAward();
		if(awardSettings.size() > 0 ){
			//数量限制
			boolean enoughAward = true;
			if(enoughAward)
				result = shootAwardItem(awardSettings);
		}
		return result;
	}
	/**
	 *  命中一个奖项
	 * @param awardSettings
	 * @return 
	 */
	public ActivityAward shootAwardItem(List<AwardSetting> awardSettings) {
		Double tempRandom = Math.random()*100+1; // 1 <= tempRandom+1 < 101
		int intRandom = tempRandom.intValue();
		int rateCount = 0 ;
		for(int i = 0 ; i < awardSettings.size() ; i++ ){
			boolean isShootTarget = NumberUtils.compareNumberBetween(rateCount, awardSettings.get(i).getRate()+rateCount, intRandom);
			rateCount += awardSettings.get(i).getRate();
			if(isShootTarget){
				return getActivityAwardByID(awardSettings.get(i).getAwardID());
			}
		}
		return ActivityAward.NoAward();
	}
	
	
}
