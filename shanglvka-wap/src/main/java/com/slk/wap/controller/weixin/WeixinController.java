package com.slk.wap.controller.weixin;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slk.wap.weixin.instruction.ResponseUtil;
import com.thinkgem.jeesite.common.mapper.JaxbMapper;

@Controller
@RequestMapping(value = { "/weixin" })
public class WeixinController {

	private Logger log = LoggerFactory.getLogger(WeixinController.class);

	private ThreadPoolExecutor threadPoolExecutor;

	@RequestMapping
	@ResponseBody
	public String request(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (request.getParameter("echostr") != null) {
			return valid(request, response);
		}

		WeixinResponse weixinResponse = process(request, response);
		if(weixinResponse != null) {
			return JaxbMapper.toXml(weixinResponse);
		}
		return null;
	}

	@PostConstruct
	private void init() {
		if (this.threadPoolExecutor == null) {
			this.threadPoolExecutor = new ThreadPoolExecutor(200,
					Integer.MAX_VALUE, 5 * 60, TimeUnit.SECONDS,
					new LinkedBlockingDeque<Runnable>());
		}
	}

	private WeixinResponse process(HttpServletRequest request,
			HttpServletResponse response) {
		final ServiceRunnable runnable = new ServiceRunnable(request, response, null);
		try {
			
			Future<WeixinResponse> future = this.threadPoolExecutor.submit(new Callable<WeixinResponse>() {
				@Override
				public WeixinResponse call() throws Exception {
					return runnable.process();
				}
			});
			while (!future.isDone()) {
				return future.get(5, TimeUnit.SECONDS);
			}
		} catch (RejectedExecutionException ree) {
			log.warn("调用服务方法:process，超过最大资源限制，无法提供服务。", ree);
			return ResponseUtil.responseText(runnable.request, "服务器繁忙");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return null;
		} catch (TimeoutException e) {
			log.warn("调用服务方法:process超时", e);
			return ResponseUtil.responseText(runnable.request, "服务器繁忙");
		} catch (Throwable e) {
			log.warn("调用服务方法:process异常", e);
			return ResponseUtil.responseText(runnable.request, "服务器正在维护，请稍候重试");
		} 
		log.warn("调用服务方法:process return null, impossiable!!!");
		return ResponseUtil.responseText(runnable.request, "服务器繁忙");
	}

	private String valid(HttpServletRequest request,
			HttpServletResponse response) {
		return request.getParameter("echostr");
	}

}
