package com.slk.core.entity.sys;

import org.springframework.util.StringUtils;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class User {
	
	//alias
	public static final String TABLE_ALIAS = "User";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "用户名";
	public static final String ALIAS_LOGIN_NAME = "loginName";
	public static final String ALIAS_PASSWORD = "密码";
	public static final String ALIAS_SALT = "salt";
	public static final String ALIAS_EMAIL = "email";
	public static final String ALIAS_LOGIN_ENABLE = "是否能登陆";
	public static final String ALIAS_IP_ENABLE = "允许登陆IP";
	public static final String ALIAS_CREATED = "created";
	public static final String ALIAS_DELETED = "deleted";
	public static final String ALIAS_LAST_OPERATE_TIME = "lastOperateTime";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * 用户名       db_column: name 
     */	
	private java.lang.String name;
    /**
     * loginName       db_column: login_name 
     */	
	private java.lang.String loginName;
    /**
     * 密码       db_column: password 
     */	
	private java.lang.String password;
    /**
     * salt       db_column: salt 
     */	
	private java.lang.String salt;
    /**
     * email       db_column: email 
     */	
	private java.lang.String email;
    /**
     * 是否能登陆       db_column: login_enable 
     */	
	private java.lang.Boolean loginEnable;
    /**
     * 允许登陆IP       db_column: ip_enable 
     */	
	private java.lang.String ipEnable;
    /**
     * created       db_column: created 
     */	
	private java.util.Date created;
    /**
     * deleted       db_column: deleted 
     */	
	private Integer deleted;
    /**
     * lastOperateTime       db_column: last_operate_time 
     */	
	private java.util.Date lastOperateTime;
	//columns END

	public User(){
	}

	public User(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	public java.lang.Long getId() {
		return this.id;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	public java.lang.String getName() {
		return this.name;
	}
	public void setLoginName(java.lang.String value) {
		this.loginName = value;
	}
	public java.lang.String getLoginName() {
		return this.loginName;
	}
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setSalt(java.lang.String value) {
		this.salt = value;
	}
	public java.lang.String getSalt() {
		return this.salt;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setLoginEnable(java.lang.Boolean value) {
		this.loginEnable = value;
	}
	public java.lang.Boolean getLoginEnable() {
		return this.loginEnable;
	}
	public void setIpEnable(java.lang.String value) {
		this.ipEnable = value;
	}
	public java.lang.String getIpEnable() {
		return this.ipEnable;
	}
	public void setCreated(java.util.Date value) {
		this.created = value;
	}
	public java.util.Date getCreated() {
		return this.created;
	}
	public void setDeleted(Integer value) {
		this.deleted = value;
	}
	public Integer getDeleted() {
		return this.deleted;
	}
	public void setLastOperateTime(java.util.Date value) {
		this.lastOperateTime = value;
	}
	public java.util.Date getLastOperateTime() {
		return this.lastOperateTime;
	}
	public UserState getUserState(String ip) {
		if(!this.getLoginEnable()) 
			return UserState.DISABLED;
		
		if(!StringUtils.isEmpty(getIpEnable()) && getIpEnable().indexOf(ip) == -1) {
			return UserState.IP_INVALID;
		}
		
		return UserState.ENABLED;
	}
}

