package com.slv.wap.weixin.process;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slv.wap.controller.weixin.WeixinRequest;
import com.slv.wap.controller.weixin.WeixinResponse;
import com.slv.wap.weixin.instruction.ResponseUtil;

/**
 * 纯文本消息回复
 * @author "iacdp"
 *
 */
@Service
@Transactional
public abstract class AbstractTextProcessor extends AbstractProcessor {

	/**
	 * 回复文本消息
	 * @return
	 */
	public abstract String textProcess(WeixinRequest request);
	
	public WeixinResponse process(WeixinRequest request) {
		return ResponseUtil.responseText(request, textProcess(request));
	}

}
