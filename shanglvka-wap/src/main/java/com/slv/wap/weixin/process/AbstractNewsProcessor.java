package com.slv.wap.weixin.process;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slv.wap.controller.weixin.ArticleItem;
import com.slv.wap.controller.weixin.WeixinRequest;
import com.slv.wap.controller.weixin.WeixinResponse;
import com.slv.wap.weixin.instruction.ResponseUtil;

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
