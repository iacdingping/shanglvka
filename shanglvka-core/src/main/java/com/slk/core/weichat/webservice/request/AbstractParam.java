package com.slk.core.weichat.webservice.request;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slk.core.Config;
import com.slk.core.weichat.webservice.PropertyKey;
import com.slk.core.weichat.webservice.RequestUtil;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;

public abstract class AbstractParam {
	@JsonIgnore
	@XmlTransient
	private Config config = SpringContextHolder.getBean(Config.class);
	
	@PropertyKey("UserName")
	private String userName = config.getUserName();
	@PropertyKey("Password_sys")
	private String password = config.getPassword();
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	@XmlTransient
	public abstract String getMethod();
	
	@JsonIgnore
	@XmlTransient
	public abstract String getMethodDesc();
	
	@JsonIgnore
	@XmlTransient
	public String getExample() {
		String xml = RequestUtil.assembleRequestXml(this);
		System.out.println("AbstractParam map to DataSet xml : " + xml);
		return xml;
	};
	
}
