package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class UserRole {
	
	//alias
	public static final String TABLE_ALIAS = "用户-角色";
	public static final String ALIAS_USER_ID = "用户编号";
	public static final String ALIAS_ROLE_ID = "角色编号";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 用户编号       db_column: user_id 
     */	
	private java.lang.String userId;
    /**
     * 角色编号       db_column: role_id 
     */	
	private java.lang.String roleId;
	//columns END

	public UserRole(){
	}

	public UserRole(
		java.lang.String userId,
		java.lang.String roleId
	){
		this.userId = userId;
		this.roleId = roleId;
	}

	public void setUserId(java.lang.String value) {
		this.userId = value;
	}
	public java.lang.String getUserId() {
		return this.userId;
	}
	public void setRoleId(java.lang.String value) {
		this.roleId = value;
	}
	public java.lang.String getRoleId() {
		return this.roleId;
	}
}

