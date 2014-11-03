package com.slk.wap.controller.weixin;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.mapper.JsonMapper;

@Component
public class AfterResponseTask {

	private Logger log = LoggerFactory.getLogger(getClass());
	private static BlockingQueue<Task> queue = new LinkedBlockingDeque<Task>();
	private static volatile boolean stopped = false;
	
	@PostConstruct
	public void init() {
		ProcessResponse thread = new ProcessResponse();
		new Thread(thread, "ProcessResponse").start();
	}
	
	/**
	 * When no space or thread has been stopped, it will throw IllegalStateException.
	 * @param request
	 * @param response
	 */
	public static void submitTask(WeixinRequest request, WeixinResponse response) {
		if(stopped) {
			throw new IllegalStateException("Thread has been stopped! Do not receive task.");
		}
		
		queue.add(new Task(request, response));
	}
	
	class ProcessResponse implements Runnable  {
		@Override
		public void run() {
			while(!stopped) {
				try {
					Task task = queue.take();
					
					process(task);
				} catch (InterruptedException e) {
					stopped = true;
					Thread.currentThread().interrupt();
				}
			}
			// Write queue record into logging file.
			log.info(JsonMapper.toJsonString(queue));
			log.info("AsyncTask " + Thread.currentThread().getName() + " stopped!");
		}
	}

	private void process(Task task) {
		// 1 记录数据库访问日志
		// 2 mp_user表中是否存在用户 以及调用微信接口 获取用户信息
	}

	@PreDestroy
	public void stop() {
		log.info("AsyncTask " + Thread.currentThread().getName() + " going to stop!");
		stopped = true;
	}
	
	static class Task {
		WeixinRequest request;
		WeixinResponse response;
		
		public Task(WeixinRequest request, WeixinResponse response) {
			super();
			this.request = request;
			this.response = response;
		}
		public WeixinRequest getRequest() {
			return request;
		}
		public void setRequest(WeixinRequest request) {
			this.request = request;
		}
		public WeixinResponse getResponse() {
			return response;
		}
		public void setResponse(WeixinResponse response) {
			this.response = response;
		}
	}
}
