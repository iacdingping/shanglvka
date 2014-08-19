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
public class OfficeQuery extends PageQuery {
    

	/** 编号 */
	private java.lang.String id;
	/** 父级编号 */
	private java.lang.String parentId;
	/** 所有父级编号 */
	private java.lang.String parentIds;
	/** 归属区域 */
	private java.lang.String areaId;
	/** 区域编码 */
	private java.lang.String code;
	/** 机构名称 */
	private java.lang.String name;
	/** 机构类型 */
	private java.lang.String type;
	/** 机构等级 */
	private java.lang.String grade;
	/** 联系地址 */
	private java.lang.String address;
	/** 邮政编码 */
	private java.lang.String zipCode;
	/** 负责人 */
	private java.lang.String master;
	/** 电话 */
	private java.lang.String phone;
	/** 传真 */
	private java.lang.String fax;
	/** 邮箱 */
	private java.lang.String email;
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
	
	public java.lang.String getAreaId() {
		return this.areaId;
	}
	
	public void setAreaId(java.lang.String value) {
		this.areaId = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getType() {
		return this.type;
	}
	
	public void setType(java.lang.String value) {
		this.type = value;
	}
	
	public java.lang.String getGrade() {
		return this.grade;
	}
	
	public void setGrade(java.lang.String value) {
		this.grade = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(java.lang.String value) {
		this.zipCode = value;
	}
	
	public java.lang.String getMaster() {
		return this.master;
	}
	
	public void setMaster(java.lang.String value) {
		this.master = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getFax() {
		return this.fax;
	}
	
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
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

