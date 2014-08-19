package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class RoleMenu {
	
	//alias
	public static final String TABLE_ALIAS = "角色-菜单";
	public static final String ALIAS_ROLE_ID = "角色编号";
	public static final String ALIAS_MENU_ID = "菜单编号";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 角色编号       db_column: role_id 
     */	
	private java.lang.String roleId;
    /**
     * 菜单编号       db_column: menu_id 
     */	
	private java.lang.String menuId;
	//columns END

	public RoleMenu(){
	}

	public RoleMenu(
		java.lang.String roleId,
		java.lang.String menuId
	){
		this.roleId = roleId;
		this.menuId = menuId;
	}

	public void setRoleId(java.lang.String value) {
		this.roleId = value;
	}
	public java.lang.String getRoleId() {
		return this.roleId;
	}
	public void setMenuId(java.lang.String value) {
		this.menuId = value;
	}
	public java.lang.String getMenuId() {
		return this.menuId;
	}
}

