package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class UserRole {
	
	//alias
	public static final String TABLE_ALIAS = "UserRole";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER = "用户";
	public static final String ALIAS_ROLE = "角色";
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
     * 用户       db_column: user 
     */	
	private java.lang.Long user;
    /**
     * 角色       db_column: role 
     */	
	private java.lang.Long role;
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

	public UserRole(){
	}

	public UserRole(
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
	public java.lang.Long getUser() {
		return user;
	}
	public void setUser(java.lang.Long user) {
		this.user = user;
	}
	public java.lang.Long getRole() {
		return role;
	}
	public void setRole(java.lang.Long role) {
		this.role = role;
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
}

