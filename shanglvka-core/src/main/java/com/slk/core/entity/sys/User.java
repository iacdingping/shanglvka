package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class User {
	
	//alias
	public static final String TABLE_ALIAS = "用户表";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_COMPANY_ID = "归属公司";
	public static final String ALIAS_OFFICE_ID = "归属部门";
	public static final String ALIAS_LOGIN_NAME = "登录名";
	public static final String ALIAS_PASSWORD = "密码";
	public static final String ALIAS_NO = "工号";
	public static final String ALIAS_NAME = "姓名";
	public static final String ALIAS_EMAIL = "邮箱";
	public static final String ALIAS_PHONE = "电话";
	public static final String ALIAS_MOBILE = "手机";
	public static final String ALIAS_USER_TYPE = "用户类型";
	public static final String ALIAS_LOGIN_IP = "最后登陆IP";
	public static final String ALIAS_LOGIN_DATE = "最后登陆时间";
	public static final String ALIAS_CREATE_BY = "创建者";
	public static final String ALIAS_CREATE_DATE = "创建时间";
	public static final String ALIAS_UPDATE_BY = "更新者";
	public static final String ALIAS_UPDATE_DATE = "更新时间";
	public static final String ALIAS_REMARKS = "备注信息";
	public static final String ALIAS_DEL_FLAG = "删除标记";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 编号       db_column: id 
     */	
	private java.lang.String id;
    /**
     * 归属公司       db_column: company_id 
     */	
	private java.lang.String companyId;
    /**
     * 归属部门       db_column: office_id 
     */	
	private java.lang.String officeId;
    /**
     * 登录名       db_column: login_name 
     */	
	private java.lang.String loginName;
    /**
     * 密码       db_column: password 
     */	
	private java.lang.String password;
    /**
     * 工号       db_column: no 
     */	
	private java.lang.String no;
    /**
     * 姓名       db_column: name 
     */	
	private java.lang.String name;
    /**
     * 邮箱       db_column: email 
     */	
	private java.lang.String email;
    /**
     * 电话       db_column: phone 
     */	
	private java.lang.String phone;
    /**
     * 手机       db_column: mobile 
     */	
	private java.lang.String mobile;
    /**
     * 用户类型       db_column: user_type 
     */	
	private java.lang.String userType;
    /**
     * 最后登陆IP       db_column: login_ip 
     */	
	private java.lang.String loginIp;
    /**
     * 最后登陆时间       db_column: login_date 
     */	
	private java.util.Date loginDate;
    /**
     * 创建者       db_column: create_by 
     */	
	private java.lang.String createBy;
    /**
     * 创建时间       db_column: create_date 
     */	
	private java.util.Date createDate;
    /**
     * 更新者       db_column: update_by 
     */	
	private java.lang.String updateBy;
    /**
     * 更新时间       db_column: update_date 
     */	
	private java.util.Date updateDate;
    /**
     * 备注信息       db_column: remarks 
     */	
	private java.lang.String remarks;
    /**
     * 删除标记       db_column: del_flag 
     */	
	private java.lang.String delFlag;
	//columns END

	public User(){
	}

	public User(
		java.lang.String id
	){
		this.id = id;
	}

	public void setId(java.lang.String value) {
		this.id = value;
	}
	public java.lang.String getId() {
		return this.id;
	}
	public void setCompanyId(java.lang.String value) {
		this.companyId = value;
	}
	public java.lang.String getCompanyId() {
		return this.companyId;
	}
	public void setOfficeId(java.lang.String value) {
		this.officeId = value;
	}
	public java.lang.String getOfficeId() {
		return this.officeId;
	}
	public void setLoginName(java.lang.String value) {
		this.loginName = value;
	}
	public java.lang.String getLoginName() {
		return this.loginName;
	}
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setNo(java.lang.String value) {
		this.no = value;
	}
	public java.lang.String getNo() {
		return this.no;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	public java.lang.String getName() {
		return this.name;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setUserType(java.lang.String value) {
		this.userType = value;
	}
	public java.lang.String getUserType() {
		return this.userType;
	}
	public void setLoginIp(java.lang.String value) {
		this.loginIp = value;
	}
	public java.lang.String getLoginIp() {
		return this.loginIp;
	}
	public void setLoginDate(java.util.Date value) {
		this.loginDate = value;
	}
	public java.util.Date getLoginDate() {
		return this.loginDate;
	}
	public void setCreateBy(java.lang.String value) {
		this.createBy = value;
	}
	public java.lang.String getCreateBy() {
		return this.createBy;
	}
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	public void setUpdateBy(java.lang.String value) {
		this.updateBy = value;
	}
	public java.lang.String getUpdateBy() {
		return this.updateBy;
	}
	public void setUpdateDate(java.util.Date value) {
		this.updateDate = value;
	}
	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}
	public void setRemarks(java.lang.String value) {
		this.remarks = value;
	}
	public java.lang.String getRemarks() {
		return this.remarks;
	}
	public void setDelFlag(java.lang.String value) {
		this.delFlag = value;
	}
	public java.lang.String getDelFlag() {
		return this.delFlag;
	}
}

