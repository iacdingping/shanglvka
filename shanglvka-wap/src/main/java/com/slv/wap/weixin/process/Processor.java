package com.slv.wap.weixin.process;

import com.slv.wap.controller.weixin.WeixinResponse;


public interface Processor<T> {

	public WeixinResponse process(T request);
}

