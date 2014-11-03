package com.slk.wap.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.client.RestTemplate;

import com.slk.core.entity.mp.WeixinUser;
import com.slk.core.manager.mp.WeixinUserManager;
import com.slk.core.query.mp.WeixinUserQuery;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.Threads;

/**
 * 查询微信用户基本信息
 * @author IAC-DINGPING
 *
 */
public class QueryUserInfo implements Runnable {

	private String cronExpression;

	private int shutdownTimeout = Integer.MAX_VALUE;

	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
	private String globalAccessToken;
	@Value("${weixin.appid}")
	private String appid;
	@Value("${weixin.secret}")
	private String secret;
	RestTemplate template = new RestTemplate();
	private CloseableHttpClient httpclient;
	private RequestConfig config;
	
	JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();
	
	@Autowired
	private WeixinUserManager weixinUserManager;
	private WeixinUserQuery query;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@PostConstruct
	public void start() {
		query = new WeixinUserQuery();
		query.setQueried(false);
		queryGlobalAccessToken();
		
		httpclient = HttpClients.createDefault();
		config = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(10000).build();
		
		threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setThreadNamePrefix("QueryUserInfo");
		threadPoolTaskScheduler.initialize();

		threadPoolTaskScheduler.schedule(this, new CronTrigger(cronExpression));
		System.out.println("QueryUserInfo started");
	}

	@PreDestroy
	public void stop() {
		ScheduledExecutorService scheduledExecutorService = threadPoolTaskScheduler.getScheduledExecutor();
		Threads.normalShutdown(scheduledExecutorService, shutdownTimeout, TimeUnit.SECONDS);
	}

	@Override
	public void run() {
		List<WeixinUser> userList = weixinUserManager.findPage(query).getItems();
		
		for(WeixinUser user : userList) {
			if(queryWeixinUserInfo(user))
				weixinUserManager.update(user);
		}
	}

	private boolean queryWeixinUserInfo(WeixinUser user) {
		String response;
		try {
			response = request(user.getPlatformCode());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		if(response.indexOf("errcode") > -1) {
			Map result = jsonMapper.fromJson(response, Map.class);
			Integer errcode = (Integer)result.get("errcode");
			String message = (String)result.get("errmsg");
			if("40001,40014,42001".indexOf(errcode + "") > -1) {
				queryGlobalAccessToken();
			} else {
				log.warn(String.format("Query weixin user information error, return code [%s], return message [%s], openId [%s]", errcode, message, user.getPlatformCode()));
				Threads.sleep(30000);
			}
			return false;
		} 
		
		UserInfo userInfo = jsonMapper.fromJson(response, UserInfo.class);
		user.setNickname(userInfo.getNickname());
		user.setSex(userInfo.getSex());
		user.setProvince(userInfo.getProvince());
		user.setCity(userInfo.getCity());
		user.setQueried(true);
		return true;
	}
	
	private String request(String platformCode) throws IOException {
		List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
		formParams.add(new BasicNameValuePair("access_token", globalAccessToken));
		formParams.add(new BasicNameValuePair("openid", platformCode));
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

	
	private void queryGlobalAccessToken() {
		String json = template.getForObject("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}", 
				String.class, appid, secret);
		System.out.println("queryGlobalAccessToken return : " + json);
		Map result = jsonMapper.fromJson(json, Map.class);
		globalAccessToken = (String)result.get("access_token");
	}
	
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	/**
	 * 设置normalShutdown的等待时间,单位秒.
	 */
	public void setShutdownTimeout(int shutdownTimeout) {
		this.shutdownTimeout = shutdownTimeout;
	}

	static class UserInfo {
		private String subscribe;
		private String openid;
		private String nickname;
		private String sex;
		private String language;
		private String city;
		private String province;
		private String country;
		private String headimgurl;
		private String subscribe_time;
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
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
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
		public String getSubscribe_time() {
			return subscribe_time;
		}
		public void setSubscribe_time(String subscribe_time) {
			this.subscribe_time = subscribe_time;
		}
	}
}
