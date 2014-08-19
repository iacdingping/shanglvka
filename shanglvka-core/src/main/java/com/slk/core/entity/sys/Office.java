package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Office {
	
	//alias
	public static final String TABLE_ALIAS = "机构表";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_PARENT_ID = "父级编号";
	public static final String ALIAS_PARENT_IDS = "所有父级编号";
	public static final String ALIAS_AREA_ID = "归属区域";
	public static final String ALIAS_CODE = "区域编码";
	public static final String ALIAS_NAME = "机构名称";
	public static final String ALIAS_TYPE = "机构类型";
	public static final String ALIAS_GRADE = "机构等级";
	public static final String ALIAS_ADDRESS = "联系地址";
	public static final String ALIAS_ZIP_CODE = "邮政编码";
	public static final String ALIAS_MASTER = "负责人";
	public static final String ALIAS_PHONE = "电话";
	public static final String ALIAS_FAX = "传真";
	public static final String ALIAS_EMAIL = "邮箱";
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
     * 父级编号       db_column: parent_id 
     */	
	private java.lang.String parentId;
    /**
     * 所有父级编号       db_column: parent_ids 
     */	
	private java.lang.String parentIds;
    /**
     * 归属区域       db_column: area_id 
     */	
	private java.lang.String areaId;
    /**
     * 区域编码       db_column: code 
     */	
	private java.lang.String code;
    /**
     * 机构名称       db_column: name 
     */	
	private java.lang.String name;
    /**
     * 机构类型       db_column: type 
     */	
	private java.lang.String type;
    /**
     * 机构等级       db_column: grade 
     */	
	private java.lang.String grade;
    /**
     * 联系地址       db_column: address 
     */	
	private java.lang.String address;
    /**
     * 邮政编码       db_column: zip_code 
     */	
	private java.lang.String zipCode;
    /**
     * 负责人       db_column: master 
     */	
	private java.lang.String master;
    /**
     * 电话       db_column: phone 
     */	
	private java.lang.String phone;
    /**
     * 传真       db_column: fax 
     */	
	private java.lang.String fax;
    /**
     * 邮箱       db_column: email 
     */	
	private java.lang.String email;
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

	public Office(){
	}

	public Office(
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
	public void setParentId(java.lang.String value) {
		this.parentId = value;
	}
	public java.lang.String getParentId() {
		return this.parentId;
	}
	public void setParentIds(java.lang.String value) {
		this.parentIds = value;
	}
	public java.lang.String getParentIds() {
		return this.parentIds;
	}
	public void setAreaId(java.lang.String value) {
		this.areaId = value;
	}
	public java.lang.String getAreaId() {
		return this.areaId;
	}
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	public java.lang.String getCode() {
		return this.code;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	public java.lang.String getName() {
		return this.name;
	}
	public void setType(java.lang.String value) {
		this.type = value;
	}
	public java.lang.String getType() {
		return this.type;
	}
	public void setGrade(java.lang.String value) {
		this.grade = value;
	}
	public java.lang.String getGrade() {
		return this.grade;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setZipCode(java.lang.String value) {
		this.zipCode = value;
	}
	public java.lang.String getZipCode() {
		return this.zipCode;
	}
	public void setMaster(java.lang.String value) {
		this.master = value;
	}
	public java.lang.String getMaster() {
		return this.master;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	public java.lang.String getFax() {
		return this.fax;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	public java.lang.String getEmail() {
		return this.email;
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

