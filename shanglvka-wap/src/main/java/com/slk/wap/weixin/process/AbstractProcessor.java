package com.slk.wap.weixin.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slk.core.entity.platform.PlatformUser;
import com.slk.core.manager.platform.PlatformUserManager;
import com.slk.wap.controller.weixin.WeixinRequest;

@Service
@Transactional
public abstract class AbstractProcessor implements Processor<WeixinRequest> {

	@Autowired
	protected PlatformUserManager platformUserManager;
	
	public PlatformUser queryUser(WeixinRequest request) {
		PlatformUser user = platformUserManager.getByPlatformCode(request.getFromUserName());
		return user;
	}
}