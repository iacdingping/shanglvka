package com.slk.wap.weixin.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slk.core.manager.mp.WeixinUserManager;
import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.controller.weixin.WeixinResponse;
import com.slk.wap.weixin.instruction.ResponseUtil;
import com.slk.wap.weixin.process.AbstractCompositeProcessor;

@Component
public class CancelAttentionProcessor extends AbstractCompositeProcessor {

	@Autowired
	private WeixinUserManager weixinUserManager;
	
	@Override
	public WeixinResponse process(WeixinRequest request) {
		weixinUserManager.cancelAttentionUser(request.getFromUserName());
		return ResponseUtil.responseText(request, "就这样被你征服，又这样被你抛弃。");
	}
}
