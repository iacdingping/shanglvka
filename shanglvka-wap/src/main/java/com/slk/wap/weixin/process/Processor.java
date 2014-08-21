package com.slk.wap.weixin.process;

import com.slk.wap.controller.weixin.WeixinResponse;


public interface Processor<T> {

	public WeixinResponse process(T request);
}

