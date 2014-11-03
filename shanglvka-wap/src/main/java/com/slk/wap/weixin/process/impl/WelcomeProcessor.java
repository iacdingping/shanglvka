package com.slk.wap.weixin.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slk.core.entity.mp.WeixinUser;
import com.slk.core.entity.mp.WeixinUserType;
import com.slk.core.manager.mp.WeixinUserManager;
import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.controller.weixin.WeixinResponse;
import com.slk.wap.weixin.instruction.ResponseUtil;
import com.slk.wap.weixin.process.AbstractCompositeProcessor;

@Component
public class WelcomeProcessor extends AbstractCompositeProcessor {

	@Autowired
	private WeixinUserManager weixinUserManager;
	
	@Override
	public WeixinResponse process(WeixinRequest request) {
		// 记录用户表 失败的呢 /。  在用户绑定再去处理好了
		if(!weixinUserManager.exists(request.getFromUserName())) {
			WeixinUser user = new WeixinUser();
			user.setPlatformCode(request.getFromUserName());
			user.setType(WeixinUserType.JUST_PAY_ATTENTION.ordinal());
			user.setQueried(false);
			weixinUserManager.save(user);
		}
		return ResponseUtil.responseText(request, "welcome 更多精彩等你发现");
	}
}
