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
public class RoleQuery extends PageQuery {
    

	/** 编号 */
	private java.lang.String id;
	/** 归属机构 */
	private java.lang.String officeId;
	/** 角色名称 */
	private java.lang.String name;
	/** 数据范围 */
	private java.lang.String dataScope;
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
	
	public java.lang.String getOfficeId() {
		return this.officeId;
	}
	
	public void setOfficeId(java.lang.String value) {
		this.officeId = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getDataScope() {
		return this.dataScope;
	}
	
	public void setDataScope(java.lang.String value) {
		this.dataScope = value;
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

