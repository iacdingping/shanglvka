package com.slk.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

	@Value("${upload.prefix.url}")
	private String uploadUrlPrefix;

	public String getUploadUrlPrefix() {
		return uploadUrlPrefix;
	}

	public void setUploadUrlPrefix(String uploadUrlPrefix) {
		this.uploadUrlPrefix = uploadUrlPrefix;
	}
	
}
