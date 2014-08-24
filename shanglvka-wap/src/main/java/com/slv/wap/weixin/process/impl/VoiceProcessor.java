package com.slv.wap.weixin.process.impl;

import org.springframework.stereotype.Component;

import com.slv.wap.controller.weixin.WeixinRequest;
import com.slv.wap.weixin.process.AbstractTextProcessor;

@Component
public class VoiceProcessor extends AbstractTextProcessor {

	@Override
	public String textProcess(WeixinRequest request) {
		return "主人的声音在管家心中最好听了！！！";
	}

}
