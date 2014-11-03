package com.slk.service.actiity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.slk.core.entity.act.Activity;
import com.slk.core.entity.act.AwardSetting;
import com.slk.wap.common.constant.ConstantActivity;
import com.slk.wap.service.activity.DrawService;

@Profile(value="production")
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class DrawServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private DrawService ds;
	
	private List<AwardSetting> awardSettings;
	
	@Before
	public void setUp(){
		awardSettings = new ArrayList<AwardSetting>();
		AwardSetting as1 = new AwardSetting();
		AwardSetting as2 = new AwardSetting();
		as1.setActivityID(ConstantActivity.DRAW_ACTIVIT_ID);
		as1.setAwardID(1l);
		as1.setAwardDesc("5元话费");
		as1.setItemDesc("一等奖");
		as1.setItemID(1L);
		as1.setPerDayLimit(100L);
		as1.setRate(5);
		awardSettings.add(as1);
		
		as2.setActivityID(ConstantActivity.DRAW_ACTIVIT_ID);
		as2.setAwardID(1l);
		as2.setAwardDesc("10元话费");
		as2.setItemDesc("二等奖");
		as2.setItemID(2L);
		as2.setPerDayLimit(100L);
		as2.setRate(50);
		awardSettings.add(as2);
		
		
		
	}
	
	/**
	 * 获取活动
	 */
	public void getActivity(){
		Activity act = ds.getActivity(1L);
		System.out.println(act);
	}
	/**
	 * 获取配置完成的活动
	 */
	public void getFullActivity(){
		ds.getAwardSettings(1l);
	}
	@Test
	public void draw(){
		System.out.println(" 结果 ："+ds.shootAwardItem(awardSettings));
	}
	
}
