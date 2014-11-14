package com.slk.wap.weixin.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slk.core.entity.mp.WeixinUser;
import com.slk.core.entity.mp.WeixinUserType;
import com.slk.core.manager.mp.WeixinUserManager;
import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.controller.weixin.WeixinResponse;
import com.slk.wap.weixin.process.AbstractCompositeProcessor;

@Component
public class WelcomeProcessor extends AbstractCompositeProcessor {

	@Autowired
	private WeixinUserManager weixinUserManager;
	
	@Autowired
	private KeyWordsProcessor keyWordsProcessor;
	
	@Override
	public WeixinResponse process(WeixinRequest request) {
		// 记录用户表 失败的呢 /。  在用户绑定再去处理好了
		WeixinUser user = weixinUserManager.getbyPlatformCode(request.getFromUserName());
		
		if(user == null) {
			user = new WeixinUser();
			user.setPlatformCode(request.getFromUserName());
			user.setType(WeixinUserType.JUST_PAY_ATTENTION.ordinal());
			user.setQueried(false);
			weixinUserManager.save(user);
		} else {
			user.setType(WeixinUserType.JUST_PAY_ATTENTION.ordinal());
			weixinUserManager.update(user);
		}
		request.setContent("welcome");
		return keyWordsProcessor.process(request);
	}
}
