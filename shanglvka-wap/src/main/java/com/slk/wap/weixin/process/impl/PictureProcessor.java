package com.slk.wap.weixin.process.impl;

import org.springframework.stereotype.Component;

import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.weixin.process.AbstractTextProcessor;

@Component
public class PictureProcessor extends AbstractTextProcessor {

	@Override
	public String textProcess(WeixinRequest request) {
		return "此物只应天上有，人间能得几回寻！";
	}
}
