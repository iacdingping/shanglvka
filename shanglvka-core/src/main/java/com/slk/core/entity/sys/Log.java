package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Log {
	
	//alias
	public static final String TABLE_ALIAS = "日志表";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_TYPE = "日志类型";
	public static final String ALIAS_CREATE_BY = "创建者";
	public static final String ALIAS_CREATE_DATE = "创建时间";
	public static final String ALIAS_REMOTE_ADDR = "操作IP地址";
	public static final String ALIAS_USER_AGENT = "用户代理";
	public static final String ALIAS_REQUEST_URI = "请求URI";
	public static final String ALIAS_METHOD = "操作方式";
	public static final String ALIAS_PARAMS = "操作提交的数据";
	public static final String ALIAS_EXCEPTION = "异常信息";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 编号       db_column: id 
     */	
	private java.lang.String id;
    /**
     * 日志类型       db_column: type 
     */	
	private java.lang.String type;
    /**
     * 创建者       db_column: create_by 
     */	
	private java.lang.String createBy;
    /**
     * 创建时间       db_column: create_date 
     */	
	private java.util.Date createDate;
    /**
     * 操作IP地址       db_column: remote_addr 
     */	
	private java.lang.String remoteAddr;
    /**
     * 用户代理       db_column: user_agent 
     */	
	private java.lang.String userAgent;
    /**
     * 请求URI       db_column: request_uri 
     */	
	private java.lang.String requestUri;
    /**
     * 操作方式       db_column: method 
     */	
	private java.lang.String method;
    /**
     * 操作提交的数据       db_column: params 
     */	
	private java.lang.String params;
    /**
     * 异常信息       db_column: exception 
     */	
	private java.lang.String exception;
	//columns END

	public Log(){
	}

	public Log(
		java.lang.String id
	){
		this.id = id;
	}

	public void setId(java.lang.String value) {
		this.id = value;
	}
	public java.lang.String getId() {
		return this.id;
	}
	public void setType(java.lang.String value) {
		this.type = value;
	}
	public java.lang.String getType() {
		return this.type;
	}
	public void setCreateBy(java.lang.String value) {
		this.createBy = value;
	}
	public java.lang.String getCreateBy() {
		return this.createBy;
	}
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	public void setRemoteAddr(java.lang.String value) {
		this.remoteAddr = value;
	}
	public java.lang.String getRemoteAddr() {
		return this.remoteAddr;
	}
	public void setUserAgent(java.lang.String value) {
		this.userAgent = value;
	}
	public java.lang.String getUserAgent() {
		return this.userAgent;
	}
	public void setRequestUri(java.lang.String value) {
		this.requestUri = value;
	}
	public java.lang.String getRequestUri() {
		return this.requestUri;
	}
	public void setMethod(java.lang.String value) {
		this.method = value;
	}
	public java.lang.String getMethod() {
		return this.method;
	}
	public void setParams(java.lang.String value) {
		this.params = value;
	}
	public java.lang.String getParams() {
		return this.params;
	}
	public void setException(java.lang.String value) {
		this.exception = value;
	}
	public java.lang.String getException() {
		return this.exception;
	}
}

