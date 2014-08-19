package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class RoleOffice {
	
	//alias
	public static final String TABLE_ALIAS = "角色-机构";
	public static final String ALIAS_ROLE_ID = "角色编号";
	public static final String ALIAS_OFFICE_ID = "机构编号";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 角色编号       db_column: role_id 
     */	
	private java.lang.String roleId;
    /**
     * 机构编号       db_column: office_id 
     */	
	private java.lang.String officeId;
	//columns END

	public RoleOffice(){
	}

	public RoleOffice(
		java.lang.String roleId,
		java.lang.String officeId
	){
		this.roleId = roleId;
		this.officeId = officeId;
	}

	public void setRoleId(java.lang.String value) {
		this.roleId = value;
	}
	public java.lang.String getRoleId() {
		return this.roleId;
	}
	public void setOfficeId(java.lang.String value) {
		this.officeId = value;
	}
	public java.lang.String getOfficeId() {
		return this.officeId;
	}
}

