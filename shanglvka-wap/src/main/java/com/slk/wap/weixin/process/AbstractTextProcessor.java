package com.slk.wap.weixin.process;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.controller.weixin.WeixinResponse;
import com.slk.wap.weixin.instruction.ResponseUtil;

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
