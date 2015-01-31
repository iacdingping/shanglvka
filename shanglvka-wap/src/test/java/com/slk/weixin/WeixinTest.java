package com.slk.weixin;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.slk.wap.controller.weixin.WeixinRequest;
import com.thinkgem.jeesite.common.mapper.JaxbMapper;

public class WeixinTest {
	
//	public static String s = "http://127.0.0.1:8080/weixin";
	public static String s = "http://101.71.9.68/weixin";

	public static void main(String[] args) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(s);
		try {
			WeixinRequest request = new WeixinRequest();
//			request.setContent("JC#18120102150");//18067908749");//18120102150");
			//request.setContent("BD#18067908749");
			//request.setContent("CX");
			request.setContent("你好");
			request.setMsgType("text");
			//request.setPicUrl("PicUrl");
			//request.setMsgId(5963598821158876070L);
			//request.setMediaId("MediaId");
			//request.setCreateTime(System.currentTimeMillis() + "");
			//request.setFromUserName("oyAj1jp9SRkcBCG-SVJB9w4XW3-o");//平台号，绑定对应的手机号码  表 w_platform_bind_mobile
			request.setFromUserName("oyAj1jmrdpo6J1Ms98doSyEGwxZ4");//ye oyAj1jmrdpo6J1Ms98doSyEGwxZ4
		   // request.setFromUserName("oyAj1jp9SRkcBCG-SVJB9w4XW3-o");//18120102150
		   // request.setFromUserName("oyAj1jtQYNKg98k6bZAPGmMTPVn0");//18905710189
			request.setToUserName("liuliangguanjia");
//			request.setMsgType("event");
//			request.setEvent("CLICK");
//			request.setEvent("subscribe");
			request.setEventKey("SYLL");
			String requestBody = JaxbMapper.toXml(request);
			System.out.println(requestBody);
			post.setEntity(new StringEntity(requestBody, "utf-8"));
			CloseableHttpResponse  httpResponse = httpclient.execute(post);
			System.out.println(httpResponse.getStatusLine());
		    HttpEntity entity2 = httpResponse.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
			System.out.println(EntityUtils.toString(entity2));
			EntityUtils.consume(entity2);
		} finally {
			if(post != null)
				post.releaseConnection();
		}
	}
}
