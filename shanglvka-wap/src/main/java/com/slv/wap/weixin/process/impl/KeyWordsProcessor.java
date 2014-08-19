package com.slv.wap.weixin.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slk.core.entity.platform.PlatformKeyword;
import com.slk.core.entity.platform.PlatformUser;
import com.slk.core.manager.platform.PlatformKeywordManager;
import com.slv.wap.controller.weixin.WeixinRequest;
import com.slv.wap.controller.weixin.WeixinResponse;
import com.slv.wap.weixin.instruction.ResponseType;
import com.slv.wap.weixin.instruction.ResponseUtil;
import com.slv.wap.weixin.process.AbstractCompositeProcessor;

/**
 * 关键字查询之前需要先判断用户是否在答题
 * 此类用来获取关键字，通过关键字到w_platform_reply表找出对应的内容进行返回
 * @author "iacdp"
 *
 */
@Component
public class KeyWordsProcessor extends AbstractCompositeProcessor {

	@Autowired
	private PlatformKeywordManager platformKeywordManager;
	
	@Override
	public WeixinResponse process(WeixinRequest request) {
		PlatformUser user = queryUser(request);
		
		PlatformKeyword keyword = platformKeywordManager.findByKey(request.getContent());
		boolean responseBindMessage = keyword.getNeedBind() && user != null;
		ResponseType responseType = ResponseType.valueOf(keyword.getResponseType());
		WeixinResponse response = null;
		switch(responseType) {
		case TEXT :
			response =  ResponseUtil.responseText(request, 
					responseBindMessage ? keyword.getContent() : keyword.getUnbindContent());
			break;
		case NEWS :
			response = ResponseUtil.responseSingleNews(
					request, keyword.getTitle(), keyword.getUrl(), keyword.getPicture(), 
					responseBindMessage ? keyword.getContent() : keyword.getUnbindContent());
			break;
		case MUSIC :
		default :
			throw new RuntimeException("Unknown type of response type with id :" + keyword.getId()); 
		}
		return response;
	}
}
