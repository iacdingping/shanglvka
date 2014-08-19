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
public class UserQuery extends PageQuery {
    

	/** 编号 */
	private java.lang.String id;
	/** 归属公司 */
	private java.lang.String companyId;
	/** 归属部门 */
	private java.lang.String officeId;
	/** 登录名 */
	private java.lang.String loginName;
	/** 密码 */
	private java.lang.String password;
	/** 工号 */
	private java.lang.String no;
	/** 姓名 */
	private java.lang.String name;
	/** 邮箱 */
	private java.lang.String email;
	/** 电话 */
	private java.lang.String phone;
	/** 手机 */
	private java.lang.String mobile;
	/** 用户类型 */
	private java.lang.String userType;
	/** 最后登陆IP */
	private java.lang.String loginIp;
	/** 最后登陆时间 */
	private java.util.Date loginDateBegin;
	private java.util.Date loginDateEnd;
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
	
	public java.lang.String getCompanyId() {
		return this.companyId;
	}
	
	public void setCompanyId(java.lang.String value) {
		this.companyId = value;
	}
	
	public java.lang.String getOfficeId() {
		return this.officeId;
	}
	
	public void setOfficeId(java.lang.String value) {
		this.officeId = value;
	}
	
	public java.lang.String getLoginName() {
		return this.loginName;
	}
	
	public void setLoginName(java.lang.String value) {
		this.loginName = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getNo() {
		return this.no;
	}
	
	public void setNo(java.lang.String value) {
		this.no = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getUserType() {
		return this.userType;
	}
	
	public void setUserType(java.lang.String value) {
		this.userType = value;
	}
	
	public java.lang.String getLoginIp() {
		return this.loginIp;
	}
	
	public void setLoginIp(java.lang.String value) {
		this.loginIp = value;
	}
	
	public java.util.Date getLoginDateBegin() {
		return this.loginDateBegin;
	}
	
	public void setLoginDateBegin(java.util.Date value) {
		this.loginDateBegin = value;
	}	
	
	public java.util.Date getLoginDateEnd() {
		return this.loginDateEnd;
	}
	
	public void setLoginDateEnd(java.util.Date value) {
		this.loginDateEnd = value;
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

