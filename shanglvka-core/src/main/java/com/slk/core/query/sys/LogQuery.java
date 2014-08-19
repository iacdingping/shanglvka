package com.slk.core.query.sys;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.slk.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class LogQuery extends PageQuery {
    

	/** 编号 */
	private java.lang.String id;
	/** 日志类型 */
	private java.lang.String type;
	/** 创建者 */
	private java.lang.String createBy;
	/** 创建时间 */
	private java.util.Date createDateBegin;
	private java.util.Date createDateEnd;
	/** 操作IP地址 */
	private java.lang.String remoteAddr;
	/** 用户代理 */
	private java.lang.String userAgent;
	/** 请求URI */
	private java.lang.String requestUri;
	/** 操作方式 */
	private java.lang.String method;
	/** 操作提交的数据 */
	private java.lang.String params;
	/** 异常信息 */
	private java.lang.String exception;

	public java.lang.String getId() {
		return this.id;
	}
	
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getType() {
		return this.type;
	}
	
	public void setType(java.lang.String value) {
		this.type = value;
	}
	
	public java.lang.String getCreateBy() {
		return this.createBy;
	}
	
	public void setCreateBy(java.lang.String value) {
		this.createBy = value;
	}
	
	public java.util.Date getCreateDateBegin() {
		return this.createDateBegin;
	}
	
	public void setCreateDateBegin(java.util.Date value) {
		this.createDateBegin = value;
	}	
	
	public java.util.Date getCreateDateEnd() {
		return this.createDateEnd;
	}
	
	public void setCreateDateEnd(java.util.Date value) {
		this.createDateEnd = value;
	}
	
	public java.lang.String getRemoteAddr() {
		return this.remoteAddr;
	}
	
	public void setRemoteAddr(java.lang.String value) {
		this.remoteAddr = value;
	}
	
	public java.lang.String getUserAgent() {
		return this.userAgent;
	}
	
	public void setUserAgent(java.lang.String value) {
		this.userAgent = value;
	}
	
	public java.lang.String getRequestUri() {
		return this.requestUri;
	}
	
	public void setRequestUri(java.lang.String value) {
		this.requestUri = value;
	}
	
	public java.lang.String getMethod() {
		return this.method;
	}
	
	public void setMethod(java.lang.String value) {
		this.method = value;
	}
	
	public java.lang.String getParams() {
		return this.params;
	}
	
	public void setParams(java.lang.String value) {
		this.params = value;
	}
	
	public java.lang.String getException() {
		return this.exception;
	}
	
	public void setException(java.lang.String value) {
		this.exception = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

