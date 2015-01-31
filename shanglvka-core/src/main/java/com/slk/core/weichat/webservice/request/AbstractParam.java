package com.slk.core.weichat.webservice.request;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.mapper.JsonMapper;

public abstract class AbstractParam {
	protected JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();
	
	@JsonIgnore
	@XmlTransient
	public abstract String getMethod();
	
	@JsonIgnore
	@XmlTransient
	public abstract String getMethodDesc();
	
	@JsonIgnore
	@XmlTransient
	public String getExample() {
		return jsonMapper.toJson(this);
	};
}
