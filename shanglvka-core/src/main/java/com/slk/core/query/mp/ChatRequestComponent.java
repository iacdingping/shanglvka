package com.slk.core.query.mp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinkgem.jeesite.common.mapper.JsonMapper;

/**
 * 微信平台请求容器
 * spring template 方式很方便 但是尝试了几次获取用户信息（包含中文）
 * 都是乱码后 改用httpClient方式
 * Be careful:
 * GlobalAccessToken 在调用自定义按钮部分需要用到 会有冲突
 * @author IAC-DINGPING
 *
 */
@Component
public class ChatRequestComponent {

	RestTemplate template = new RestTemplate();
	@Value("${weixin.appid}")
	private String appid;
	@Value("${weixin.secret}")
	private String secret;
	JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();
	
	private String globalAccessToken;
	private CloseableHttpClient httpclient;
	private RequestConfig config;
	
	private String queryGlobalAccessToken() {
		String json = template.getForObject("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}", 
				String.class, appid, secret);
		System.out.println("queryGlobalAccessToken return : " + json);
		GlobalAccessToken result = jsonMapper.fromJson(json, GlobalAccessToken.class);
		return result.getAccessToken();
	}
	
	@PostConstruct
	private void init() {
		setGlobalAccessToken();
		httpclient = HttpClients.createDefault();
		config = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(10000).build();
	}
	
	/**
	 * 两种获取方式
	 * <ul>
	 *  <li>全局获取accessToken，openid 即为消息交互中fromUser</li>
	 *  <li>页面用户授权获取openid与accessToken</li>
	 * </ul>
	 * 
	 * 在抛出InvalidTokenException异常后应重新获取token
	 * 如果是全局的方式，请调用{@link #setGlobalAccessToken()}
	 * @return
	 * @throws ResponseError 
	 * @throws InvalidTokenException 
	 */
	public UserInfo synUserInfo(String accessToken, String openid) throws ResponseError, InvalidTokenException {
		try {
			String responseJson = queryUserInfo(accessToken, openid);
			return parseUserInfo(responseJson);
		} catch (IOException e) {
			throw new ResponseError("SynUserInfo error between request to weixin server.", e);
		}
	}
	
	public UserInfo synUserInfoByGlobalToken(String openid) throws ResponseError, InvalidTokenException {
		return synUserInfo(globalAccessToken, openid);
	}
	
	/**
	 * 
	 * @param accessToken 
	 * @param openid 即platform_code
	 * @return
	 * @throws IOException
	 */
	public String queryUserInfo(String accessToken, String openid) throws IOException {
		List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
		formParams.add(new BasicNameValuePair("access_token", accessToken));
		formParams.add(new BasicNameValuePair("openid", openid));
		HttpEntity entity = new UrlEncodedFormEntity(formParams, "utf-8");
		HttpPost request = new HttpPost("https://api.weixin.qq.com/cgi-bin/user/info");
		
		request.setConfig(config);
		request.setEntity(entity);
		HttpEntity responseEntity = null;
		
		try{
			CloseableHttpResponse response = httpclient.execute(request);
			responseEntity = response.getEntity();
			return EntityUtils.toString(responseEntity, "utf-8");
		} finally {
			EntityUtils.consume(responseEntity);
		}
	}
	
	public UserInfo parseUserInfo(String responseJson) throws InvalidTokenException, ResponseError {
		if(responseJson.indexOf("errcode") > -1) {
			NomalResponse result = jsonMapper.fromJson(responseJson, NomalResponse.class);
			if("40001,40014,42001".indexOf(result.getErrcode().toString()) > -1) {
				throw new InvalidTokenException("sync user info error, invalid token: " + responseJson);
			} else {
				throw new ResponseError("Query weixin user information error, return : " + responseJson);
			}
		}
		
		try {
			return jsonMapper.fromJson(responseJson, UserInfo.class);
		} catch(Exception e) {
			throw new ResponseError("Parse weixin user information error, return : " + responseJson);
		}
	}
	
	/**
	 * 用户授权后获取用户授权token 正确响应：<br> 
	 * { 
	 * "access_token":"ACCESS_TOKEN", 
	 * "expires_in":7200,
	 * "refresh_token":"REFRESH_TOKEN", 
	 * "openid":"OPENID", 
	 * "scope":"SCOPE" 
	 * }
	 * 
	 * @param code
	 * @return
	 * @throws ResponseError 
	 */
	public AccessToken queryAccessToken(String code) throws ResponseError {
		String result = template.getForObject(
				"https://api.weixin.qq.com/sns/oauth2/access_token?appid={appid}&secret={secret}&code={code}&grant_type=authorization_code", 
				String.class, appid, secret, code);
		
		return parseToken(result);
	}
	
	/**
	 * 刷新token 
	 * @param refreshToken
	 * @return
	 * @throws ResponseError 
	 */
	public AccessToken refreshToken(String refreshToken) throws ResponseError {
		String result = template.getForObject(
				"https://api.weixin.qq.com/sns/oauth2/refresh_token?appid={appid}&grant_type=refresh_token&refresh_token={refreshToken}", 
				String.class, appid, refreshToken);
		
		return parseToken(result);
	}
	
	private  AccessToken parseToken(String responseJson) throws ResponseError {
		if(responseJson.indexOf("errcode") > -1) {
			throw new ResponseError("Get user access token error, returned: " + responseJson);
		}
		
		try {
			AccessToken token = jsonMapper.fromJson(responseJson, AccessToken.class);
			return token;
		} catch(Exception e) {
			throw new ResponseError("Response deserilize error, returned: " + responseJson);
		}
	}
	
	public boolean checkTokenValid(String token, String openid) {
		String result = template.getForObject("https://api.weixin.qq.com/sns/auth?access_token={accessToken}&openid={openid}", 
				String.class, token, openid);
		
		return result.indexOf("\"errcode\":0") > -1;
	}
	
	public String getGlobalAccessToken() {
		return globalAccessToken;
	}

	/**
	 * 设置全局accessToken
	 */
	public void setGlobalAccessToken() {
		this.globalAccessToken = queryGlobalAccessToken();
	}
	
	public static class AccessToken {
		@JsonProperty("access_token")
		private String accessToken;
		@JsonProperty("expires_in")
		private Integer expires;
		@JsonProperty("refresh_token")
		private String refreshToken;
		@JsonProperty("openid")
		private String openid;
		@JsonProperty("scope")
		private String scope;
		public String getAccessToken() {
			return accessToken;
		}
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}
		public Integer getExpires() {
			return expires;
		}
		public void setExpires(Integer expires) {
			this.expires = expires;
		}
		public String getRefreshToken() {
			return refreshToken;
		}
		public void setRefreshToken(String refreshToken) {
			this.refreshToken = refreshToken;
		}
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		public String getScope() {
			return scope;
		}
		public void setScope(String scope) {
			this.scope = scope;
		}
	}
	
	public static class UserInfo {
		private String subscribe;
		private String openid;
		private String nickname;
		private Integer sex;
		private String language;
		private String city;
		private String province;
		private String country;
		private String headimgurl;
		@JsonProperty("subscribe_time")
		private String subscribeTime;
		private String unionid;
		
		private List<String> privilege;
		public String getSubscribe() {
			return subscribe;
		}
		public void setSubscribe(String subscribe) {
			this.subscribe = subscribe;
		}
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public Integer getSex() {
			return sex;
		}
		public void setSex(Integer sex) {
			this.sex = sex;
		}
		public String getUnionid() {
			return unionid;
		}
		public void setUnionid(String unionid) {
			this.unionid = unionid;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getHeadimgurl() {
			return headimgurl;
		}
		public void setHeadimgurl(String headimgurl) {
			this.headimgurl = headimgurl;
		}
		public String getSubscribeTime() {
			return subscribeTime;
		}
		public void setSubscribeTime(String subscribeTime) {
			this.subscribeTime = subscribeTime;
		}
		public List<String> getPrivilege() {
			return privilege;
		}
		public void setPrivilege(List<String> privilege) {
			this.privilege = privilege;
		}
	}
	public static class NomalResponse {
		private Integer errcode;
		private String errmsg;
		public Integer getErrcode() {
			return errcode;
		}
		public void setErrcode(Integer errcode) {
			this.errcode = errcode;
		}
		public String getErrmsg() {
			return errmsg;
		}
		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}
	} 
	public static class GlobalAccessToken {
		@JsonProperty("access_token")
		private String accessToken;
		@JsonProperty("expires_in")
		private Integer expires;
		public String getAccessToken() {
			return accessToken;
		}
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}
		public Integer getExpires() {
			return expires;
		}
		public void setExpires(Integer expires) {
			this.expires = expires;
		}
	}
}
