package com.slv.wap.weixin.process.impl;

import org.springframework.stereotype.Component;

import com.slv.wap.controller.weixin.WeixinRequest;
import com.slv.wap.controller.weixin.WeixinResponse;
import com.slv.wap.weixin.process.AbstractCompositeProcessor;

/**
 * 关键字查询之前需要先判断用户是否在答题
 * 此类用来获取关键字，通过关键字到w_platform_reply表找出对应的内容进行返回
 * @author "iacdp"
 *
 */
@Component
public class KeyWordsProcessor extends AbstractCompositeProcessor {

	@Override
	public WeixinResponse process(WeixinRequest request) {
		return null;
	}
}
