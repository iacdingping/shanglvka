package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Area {
	
	//alias
	public static final String TABLE_ALIAS = "区域表";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_PARENT_ID = "父级编号";
	public static final String ALIAS_PARENT_IDS = "所有父级编号";
	public static final String ALIAS_CODE = "区域编码";
	public static final String ALIAS_NAME = "区域名称";
	public static final String ALIAS_TYPE = "区域类型";
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
     * 区域编码       db_column: code 
     */	
	private java.lang.String code;
    /**
     * 区域名称       db_column: name 
     */	
	private java.lang.String name;
    /**
     * 区域类型       db_column: type 
     */	
	private java.lang.String type;
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

	public Area(){
	}

	public Area(
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

