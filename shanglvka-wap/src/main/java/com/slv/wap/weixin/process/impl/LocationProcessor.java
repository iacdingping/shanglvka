package com.slv.wap.weixin.process.impl;

import org.springframework.stereotype.Component;

import com.slv.wap.controller.weixin.WeixinRequest;
import com.slv.wap.weixin.process.AbstractTextProcessor;

@Component
public class LocationProcessor extends AbstractTextProcessor {

	@Override
	public String textProcess(WeixinRequest request) {
		return "众里寻您千百度，蓦然回首，主人却在，灯火阑珊处。！！！";
	}
}
