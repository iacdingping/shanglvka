package com.slk.core.query.mp;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.slk.core.PageQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class KeywordQuery extends PageQuery {
    

	/** id */
	private java.lang.Long id;
	/** 关键字 */
	private java.lang.String key;
	/** 回复类型 */
	private java.lang.String responseType;
	/** 内容 */
	private java.lang.String content;
	/** 标题 */
	private java.lang.String title;
	/** 图片地址 */
	private java.lang.String picture;
	/** 链接 */
	private java.lang.String url;
	/** 匹配优先级 越大优先级越高 */
	private java.lang.Integer priority;
	/** 是否需要绑定 */
	private java.lang.Integer needBind;
	/** 未绑定内容 */
	private java.lang.String unbindContent;
	/** createDate */
	private java.util.Date createDateBegin;
	private java.util.Date createDateEnd;
	/** updateDate */
	private java.util.Date updateDateBegin;
	private java.util.Date updateDateEnd;
	/** delFlag */
	private java.lang.Integer delFlag;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.String getKey() {
		return this.key;
	}
	
	public void setKey(java.lang.String value) {
		this.key = value;
	}
	
	public java.lang.String getResponseType() {
		return this.responseType;
	}
	
	public void setResponseType(java.lang.String value) {
		this.responseType = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	public java.lang.String getPicture() {
		return this.picture;
	}
	
	public void setPicture(java.lang.String value) {
		this.picture = value;
	}
	
	public java.lang.String getUrl() {
		return this.url;
	}
	
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	
	public java.lang.Integer getPriority() {
		return this.priority;
	}
	
	public void setPriority(java.lang.Integer value) {
		this.priority = value;
	}
	
	public java.lang.Integer getNeedBind() {
		return this.needBind;
	}
	
	public void setNeedBind(java.lang.Integer value) {
		this.needBind = value;
	}
	
	public java.lang.String getUnbindContent() {
		return this.unbindContent;
	}
	
	public void setUnbindContent(java.lang.String value) {
		this.unbindContent = value;
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
	
	public java.lang.Integer getDelFlag() {
		return this.delFlag;
	}
	
	public void setDelFlag(java.lang.Integer value) {
		this.delFlag = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

