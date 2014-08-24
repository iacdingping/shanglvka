package com.slk.wap.weixin.process;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slk.wap.controller.weixin.ArticleItem;
import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.controller.weixin.WeixinResponse;
import com.slk.wap.weixin.instruction.ResponseUtil;

/**
 * 图文回复
 * @author "iacdp"
 *
 */
@Service
@Transactional
public abstract class AbstractNewsProcessor extends AbstractProcessor {

	/**
	 * 图文回复
	 */
	public abstract List<ArticleItem> newsProcess(WeixinRequest request);
	
	public WeixinResponse actualProcess(WeixinRequest request) {
		return ResponseUtil.responseNews(request, newsProcess(request));
	}
}
