package com.slk.core.query.sys;

import com.slk.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class ModuleQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** 父模块 */
	private java.lang.String parent;
	/** 名称 */
	private java.lang.String name;
	/** 图标 */
	private java.lang.String icon;
	/** 是否展开 */
	private java.lang.String expanded;
	/** 类型 1菜单 2功能 */
	private java.lang.Integer type;
	/** 权限query edit delete */
	private java.lang.String permission;
	/** 排序 */
	private java.lang.Integer order;
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
	
	public java.lang.String getParent() {
		return this.parent;
	}
	
	public void setParent(java.lang.String value) {
		this.parent = value;
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
	
	public java.lang.String getExpanded() {
		return this.expanded;
	}
	
	public void setExpanded(java.lang.String value) {
		this.expanded = value;
	}
	
	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
	public java.lang.String getPermission() {
		return this.permission;
	}
	
	public void setPermission(java.lang.String value) {
		this.permission = value;
	}
	
	public java.lang.Integer getOrder() {
		return this.order;
	}
	
	public void setOrder(java.lang.Integer value) {
		this.order = value;
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

