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
public class MenuQuery extends PageQuery {
    

	/** 编号 */
	private java.lang.String id;
	/** 父级编号 */
	private java.lang.String parentId;
	/** 所有父级编号 */
	private java.lang.String parentIds;
	/** 菜单名称 */
	private java.lang.String name;
	/** 链接 */
	private java.lang.String href;
	/** 目标 */
	private java.lang.String target;
	/** 图标 */
	private java.lang.String icon;
	/** 排序（升序） */
	private java.lang.Integer sort;
	/** 是否在菜单中显示 */
	private java.lang.String isShow;
	/** 是否同步工作流 */
	private java.lang.String isActiviti;
	/** 权限标识 */
	private java.lang.String permission;
	/** 创建者 */
	private java.lang.String createBy;
	/** 创建时间 */
	private java.util.Date createDateBegin;
	private java.util.Date createDateEnd;
	/** 更新者 */
	private java.lang.String updateBy;
	/** 更新时间 */
	private java.util.Date updateDateBegin;
	private java.util.Date updateDateEnd;
	/** 备注信息 */
	private java.lang.String remarks;
	/** 删除标记 */
	private java.lang.String delFlag;

	public java.lang.String getId() {
		return this.id;
	}
	
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.String value) {
		this.parentId = value;
	}
	
	public java.lang.String getParentIds() {
		return this.parentIds;
	}
	
	public void setParentIds(java.lang.String value) {
		this.parentIds = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getHref() {
		return this.href;
	}
	
	public void setHref(java.lang.String value) {
		this.href = value;
	}
	
	public java.lang.String getTarget() {
		return this.target;
	}
	
	public void setTarget(java.lang.String value) {
		this.target = value;
	}
	
	public java.lang.String getIcon() {
		return this.icon;
	}
	
	public void setIcon(java.lang.String value) {
		this.icon = value;
	}
	
	public java.lang.Integer getSort() {
		return this.sort;
	}
	
	public void setSort(java.lang.Integer value) {
		this.sort = value;
	}
	
	public java.lang.String getIsShow() {
		return this.isShow;
	}
	
	public void setIsShow(java.lang.String value) {
		this.isShow = value;
	}
	
	public java.lang.String getIsActiviti() {
		return this.isActiviti;
	}
	
	public void setIsActiviti(java.lang.String value) {
		this.isActiviti = value;
	}
	
	public java.lang.String getPermission() {
		return this.permission;
	}
	
	public void setPermission(java.lang.String value) {
		this.permission = value;
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
	
	public java.lang.String getUpdateBy() {
		return this.updateBy;
	}
	
	public void setUpdateBy(java.lang.String value) {
		this.updateBy = value;
	}
	
	public java.util.Date getUpdateDateBegin() {
		return this.updateDateBegin;
	}
	
	public void setUpdateDateBegin(java.util.Date value) {
		this.updateDateBegin = value;
	}	
	
	public java.util.Date getUpdateDateEnd() {
		return this.updateDateEnd;
	}
	
	public void setUpdateDateEnd(java.util.Date value) {
		this.updateDateEnd = value;
	}
	
	public java.lang.String getRemarks() {
		return this.remarks;
	}
	
	public void setRemarks(java.lang.String value) {
		this.remarks = value;
	}
	
	public java.lang.String getDelFlag() {
		return this.delFlag;
	}
	
	public void setDelFlag(java.lang.String value) {
		this.delFlag = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

