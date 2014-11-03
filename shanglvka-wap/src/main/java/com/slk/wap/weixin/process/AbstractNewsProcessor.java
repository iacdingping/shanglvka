package com.slk.wap.weixin.process;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slk.wap.common.constant.ConstantActivity;
import com.slk.wap.controller.weixin.ArticleItem;
import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.controller.weixin.WeixinResponse;
import com.slk.wap.weixin.instruction.ResponseUtil;
import com.thinkgem.jeesite.common.utils.StringUtils;

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
		WeixinResponse response = ResponseUtil.responseNews(request, newsProcess(request));
		List<ArticleItem> articles = response.getItems();
		for(ArticleItem item : articles) {
			//增加openid参数
			item.setUrl(StringUtils.appendURLParam(item.getUrl(), ConstantActivity.PLATFORM_PARAM, request.getFromUserName()));
		}
		return response;
	}
}
