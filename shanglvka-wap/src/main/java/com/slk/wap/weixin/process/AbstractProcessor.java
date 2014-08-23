package com.slk.wap.weixin.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slk.core.entity.mp.WeixinUser;
import com.slk.core.manager.mp.WeixinUserManager;
import com.slk.wap.controller.weixin.WeixinRequest;

@Service
@Transactional
public abstract class AbstractProcessor implements Processor<WeixinRequest> {

	@Autowired
	protected WeixinUserManager weixinUserManager;
	
	public WeixinUser queryUser(WeixinRequest request) {
		WeixinUser user = weixinUserManager.getbyPlatformCode(request.getFromUserName());
		return user;
	}
}
