package com.slk.wap.weixin.process.impl;

import org.springframework.stereotype.Component;

import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.weixin.process.AbstractTextProcessor;

@Component
public class UnknowRequestTypeProcessor extends AbstractTextProcessor {

	@Override
	public String textProcess(WeixinRequest request) {
		return "想要查流量、订购流量包、看管家吐槽卖萌吗？试着戳下“管家帮助”吧。";
	}
}
