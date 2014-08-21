package com.slk.wap.weixin.instruction;

import java.util.Arrays;
import java.util.List;

import com.slk.wap.controller.weixin.ArticleItem;
import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.controller.weixin.WeixinResponse;

public class ResponseUtil {

	/**
	 * 响应文本消息
	 * @param io
	 * @param content
	 */
	public static WeixinResponse responseText(WeixinRequest request, String content) {
		WeixinResponse response = new WeixinResponse(request);
		response.setMsgType(ResponseType.TEXT.toString());
		response.setContent(content);
		return response;
	}
	
	/**
	 * 响应图文消息
	 * @param io
	 * @param content
	 */
	public static WeixinResponse responseNews(WeixinRequest request, List<ArticleItem> items) {
		WeixinResponse response = new WeixinResponse(request);
		response.setFuncFlag(1);
		response.setMsgType(ResponseType.NEWS.toString());
		response.setArticleCount(items.size());
		response.setItems(items);
		return response;
	}
	
	/**
	 * 响应单图文消息
	 * @param io
	 * @param content
	 */
	public static WeixinResponse responseSingleNews(WeixinRequest request, String title, String url, String picUrl, String desc) {
		ArticleItem articleItem=new ArticleItem();
		articleItem.setTitle(title);
		articleItem.setUrl(url);
		articleItem.setPicUrl(picUrl);
		articleItem.setDescription(desc);
		return responseNews(request, Arrays.asList(articleItem));
	}
}
