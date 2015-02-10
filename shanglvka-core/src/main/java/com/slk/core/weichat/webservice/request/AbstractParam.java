package com.slk.core.weichat.webservice.request;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.slk.core.weichat.webservice.RequestUtil;
import com.slk.core.weichat.webservice.ShangLvSoapClient;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;

public abstract class AbstractParam {
	@JsonIgnore
	@XmlTransient
	private ShangLvSoapClient client = SpringContextHolder.getBean(ShangLvSoapClient.class);
	
	@JsonProperty("UserName")
	private String userName = client.userName;
	@JsonProperty("Password_sys")
	private String password = client.password;
	
	
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
