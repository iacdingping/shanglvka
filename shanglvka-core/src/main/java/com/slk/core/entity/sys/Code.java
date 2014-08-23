package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Code {
	
	//alias
	public static final String TABLE_ALIAS = "Code";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_TYPE = "类型码";
	public static final String ALIAS_CODE = "编码";
	public static final String ALIAS_DICTIONARY_CODE = "字典码";
	public static final String ALIAS_DICTIONARY_VALUE = "字典值";
	public static final String ALIAS_RESERVE_VALUE = "备用值";
	public static final String ALIAS_COMMENT = "备注";
	public static final String ALIAS_CREATED = "created";
	public static final String ALIAS_DELETED = "deleted";
	public static final String ALIAS_LAST_OPERATE_TIME = "lastOperateTime";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * 类型码       db_column: type 
     */	
	private java.lang.String type;
    /**
     * 编码       db_column: code 
     */	
	private java.lang.String code;
    /**
     * 字典码       db_column: dictionary_code 
     */	
	private java.lang.String dictionaryCode;
    /**
     * 字典值       db_column: dictionary_value 
     */	
	private java.lang.String dictionaryValue;
    /**
     * 备用值       db_column: reserve_value 
     */	
	private java.lang.String reserveValue;
    /**
     * 备注       db_column: comment 
     */	
	private java.lang.String comment;
    /**
     * created       db_column: created 
     */	
	private java.util.Date created;
    /**
     * deleted       db_column: deleted 
     */	
	private Integer deleted;
    /**
     * lastOperateTime       db_column: last_operate_time 
     */	
	private java.util.Date lastOperateTime;
	//columns END

	public Code(){
	}

	public Code(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	public java.lang.Long getId() {
		return this.id;
	}
	public void setType(java.lang.String value) {
		this.type = value;
	}
	public java.lang.String getType() {
		return this.type;
	}
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	public java.lang.String getCode() {
		return this.code;
	}
	public void setDictionaryCode(java.lang.String value) {
		this.dictionaryCode = value;
	}
	public java.lang.String getDictionaryCode() {
		return this.dictionaryCode;
	}
	public void setDictionaryValue(java.lang.String value) {
		this.dictionaryValue = value;
	}
	public java.lang.String getDictionaryValue() {
		return this.dictionaryValue;
	}
	public void setReserveValue(java.lang.String value) {
		this.reserveValue = value;
	}
	public java.lang.String getReserveValue() {
		return this.reserveValue;
	}
	public void setComment(java.lang.String value) {
		this.comment = value;
	}
	public java.lang.String getComment() {
		return this.comment;
	}
	public void setCreated(java.util.Date value) {
		this.created = value;
	}
	public java.util.Date getCreated() {
		return this.created;
	}
	public void setDeleted(Integer value) {
		this.deleted = value;
	}
	public Integer getDeleted() {
		return this.deleted;
	}
	public void setLastOperateTime(java.util.Date value) {
		this.lastOperateTime = value;
	}
	public java.util.Date getLastOperateTime() {
		return this.lastOperateTime;
	}
}

