package com.slk.core.query.sys;

import com.slk.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class RoleModuleQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** 名称 */
	private java.lang.String name;
	/** 图标 */
	private java.lang.String icon;
	/** 模块 */
	private java.lang.Long module;
	/** 角色 */
	private java.lang.Long role;
	/** 权限 */
	private java.lang.String permission;
	/** created */
	private java.util.Date createdBegin;
	private java.util.Date createdEnd;
	/** deleted */
	private Integer deleted;
	/** lastOperateTime */
	private java.util.Date lastOperateTimeBegin;
	private java.util.Date lastOperateTimeEnd;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getIcon() {
		return this.icon;
	}
	
	public void setIcon(java.lang.String value) {
		this.icon = value;
	}
	
	public java.lang.Long getModule() {
		return this.module;
	}
	
	public void setModule(java.lang.Long value) {
		this.module = value;
	}
	
	public java.lang.Long getRole() {
		return this.role;
	}
	
	public void setRole(java.lang.Long value) {
		this.role = value;
	}
	
	public java.lang.String getPermission() {
		return this.permission;
	}
	
	public void setPermission(java.lang.String value) {
		this.permission = value;
	}
	
	public java.util.Date getCreatedBegin() {
		return this.createdBegin;
	}
	
	public void setCreatedBegin(java.util.Date value) {
		this.createdBegin = value;
	}	
	
	public java.util.Date getCreatedEnd() {
		return this.createdEnd;
	}
	
	public void setCreatedEnd(java.util.Date value) {
		this.createdEnd = value;
	}
	
	public Integer getDeleted() {
		return this.deleted;
	}
	
	public void setDeleted(Integer value) {
		this.deleted = value;
	}
	
	public java.util.Date getLastOperateTimeBegin() {
		return this.lastOperateTimeBegin;
	}
	
	public void setLastOperateTimeBegin(java.util.Date value) {
		this.lastOperateTimeBegin = value;
	}	
	
	public java.util.Date getLastOperateTimeEnd() {
		return this.lastOperateTimeEnd;
	}
	
	public void setLastOperateTimeEnd(java.util.Date value) {
		this.lastOperateTimeEnd = value;
	}
	
}
