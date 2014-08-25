package com.slk.wap.weixin.process.impl;

import org.springframework.stereotype.Component;

import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.controller.weixin.WeixinResponse;
import com.slk.wap.weixin.instruction.ResponseUtil;
import com.slk.wap.weixin.process.AbstractCompositeProcessor;

@Component
public class WelcomeProcessor extends AbstractCompositeProcessor {

	@Override
	public WeixinResponse process(WeixinRequest request) {
		return ResponseUtil.responseText(request, "welcome 更多精彩等你发现");
	}
}
