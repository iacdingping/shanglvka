package com.slk.wap.controller.weixin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.wap.weixin.instruction.InstructionMatcher;
import com.slk.wap.weixin.process.Processor;
import com.thinkgem.jeesite.common.mapper.JaxbMapper;

public class ServiceRunnable {

	private HttpServletRequest servletRequest;
    private HttpServletResponse servletResponse;
    private ThreadFerry threadFerry;
    WeixinRequest request;
    
	public ServiceRunnable(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse, ThreadFerry threadFerry) {
		this.servletRequest = servletRequest;
		this.servletResponse = servletResponse;
		this.threadFerry = threadFerry;
	}

	private WeixinRequest parseRequest() throws IOException {
		InputStream is = servletRequest.getInputStream();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int len = -1;
		while((len = is.read(b)) > 0) {
			os.write(b, 0, len);
		}
		return JaxbMapper.fromXml(os.toString(), WeixinRequest.class);
	}
	
	public WeixinResponse process() throws IOException {
		if (threadFerry != null) {
            threadFerry.doInDestThread();
        }
		request = parseRequest();
		
		Processor<WeixinRequest> processor = InstructionMatcher.match(request);
		return processor.process(request);
	}

}
