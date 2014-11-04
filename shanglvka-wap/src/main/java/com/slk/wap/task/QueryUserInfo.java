package com.slk.wap.task;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import com.slk.core.entity.mp.WeixinUser;
import com.slk.core.manager.mp.WeixinUserManager;
import com.slk.core.query.mp.ChatRequestComponent;
import com.slk.core.query.mp.ChatRequestComponent.UserInfo;
import com.slk.core.query.mp.InvalidTokenException;
import com.slk.core.query.mp.ResponseError;
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
	
	JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();
	@Autowired
	ChatRequestComponent chatRequestComponent;
	
	@Autowired
	private WeixinUserManager weixinUserManager;
	private WeixinUserQuery query;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@PostConstruct
	public void start() {
		query = new WeixinUserQuery();
		query.setQueried(false);
		
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
		UserInfo userInfo;
		try {
			userInfo = chatRequestComponent.synUserInfoByGlobalToken(user.getPlatformCode());
		} catch (ResponseError e) {
			log.warn(String.format("Query weixin user[%s] information error.", user.getPlatformCode()), e);
			Threads.sleep(30000);
			return false;
		} catch (InvalidTokenException e) {
			chatRequestComponent.setGlobalAccessToken();
			return false;
		}
		
		user.setNickname(userInfo.getNickname());
		user.setSex(userInfo.getSex().toString());
		user.setProvince(userInfo.getProvince());
		user.setCity(userInfo.getCity());
		user.setQueried(true);
		return true;
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

}
