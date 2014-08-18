package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class RoleModule {
	
	//alias
	public static final String TABLE_ALIAS = "RoleModule";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "名称";
	public static final String ALIAS_ICON = "图标";
	public static final String ALIAS_MODULE = "模块";
	public static final String ALIAS_ROLE = "角色";
	public static final String ALIAS_PERMISSION = "权限";
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
     * 名称       db_column: name 
     */	
	private java.lang.String name;
    /**
     * 图标       db_column: icon 
     */	
	private java.lang.String icon;
    /**
     * 模块       db_column: module 
     */	
	private java.lang.Long module;
    /**
     * 角色       db_column: role 
     */	
	private java.lang.Long role;
    /**
     * 权限       db_column: permission 
     */	
	private java.lang.String permission;
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

	public RoleModule(){
	}

	public RoleModule(
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
	public void setIcon(java.lang.String value) {
		this.icon = value;
	}
	public java.lang.String getIcon() {
		return this.icon;
	}
	public void setModule(java.lang.Long value) {
		this.module = value;
	}
	public java.lang.Long getModule() {
		return this.module;
	}
	public void setRole(java.lang.Long value) {
		this.role = value;
	}
	public java.lang.Long getRole() {
		return this.role;
	}
	public void setPermission(java.lang.String value) {
		this.permission = value;
	}
	public java.lang.String getPermission() {
		return this.permission;
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

