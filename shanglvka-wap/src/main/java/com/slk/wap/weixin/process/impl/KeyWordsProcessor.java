package com.slk.wap.weixin.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slk.core.entity.mp.Keyword;
import com.slk.core.entity.mp.WeixinUser;
import com.slk.core.manager.mp.KeywordManager;
import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.controller.weixin.WeixinResponse;
import com.slk.wap.weixin.instruction.ResponseType;
import com.slk.wap.weixin.instruction.ResponseUtil;
import com.slk.wap.weixin.process.AbstractCompositeProcessor;

/**
 * 关键字查询之前需要先判断用户是否在答题
 * 此类用来获取关键字，通过关键字到w_platform_reply表找出对应的内容进行返回
 * @author "iacdp"
 *
 */
@Component
public class KeyWordsProcessor extends AbstractCompositeProcessor {

	@Autowired
	private KeywordManager keywordManager;
	
	@Override
	public WeixinResponse process(WeixinRequest request) {
		WeixinUser user = queryUser(request);
		
		Keyword keyword = keywordManager.findByKey(request.getContent());
		if(keyword == null) {
			keyword = keywordManager.findByKey("unknownMessage");
		}
		if(keyword == null) {
			return ResponseUtil.responseText(request, "懒得理你 T_T");
		}
		
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
