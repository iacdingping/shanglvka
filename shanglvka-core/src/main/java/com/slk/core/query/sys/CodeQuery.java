package com.slk.core.query.sys;

import com.slk.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class CodeQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** 类型码 */
	private java.lang.String type;
	/** 编码 */
	private java.lang.String code;
	/** 字典码 */
	private java.lang.String dictionaryCode;
	/** 字典值 */
	private java.lang.String dictionaryValue;
	/** 备用值 */
	private java.lang.String reserveValue;
	/** 备注 */
	private java.lang.String comment;
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
	
	public java.lang.String getType() {
		return this.type;
	}
	
	public void setType(java.lang.String value) {
		this.type = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getDictionaryCode() {
		return this.dictionaryCode;
	}
	
	public void setDictionaryCode(java.lang.String value) {
		this.dictionaryCode = value;
	}
	
	public java.lang.String getDictionaryValue() {
		return this.dictionaryValue;
	}
	
	public void setDictionaryValue(java.lang.String value) {
		this.dictionaryValue = value;
	}
	
	public java.lang.String getReserveValue() {
		return this.reserveValue;
	}
	
	public void setReserveValue(java.lang.String value) {
		this.reserveValue = value;
	}
	
	public java.lang.String getComment() {
		return this.comment;
	}
	
	public void setComment(java.lang.String value) {
		this.comment = value;
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

