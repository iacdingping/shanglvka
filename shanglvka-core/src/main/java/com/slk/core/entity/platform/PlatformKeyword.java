package com.slk.core.entity.platform;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class PlatformKeyword {
	
	//alias
	public static final String TABLE_ALIAS = "平台关键字自动回复";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_KEY = "关键字";
	public static final String ALIAS_RESPONSE_TYPE = "回复类型";
	public static final String ALIAS_CONTENT = "内容";
	public static final String ALIAS_TITLE = "标题";
	public static final String ALIAS_PICTURE = "图片地址";
	public static final String ALIAS_URL = "链接";
	public static final String ALIAS_PRIORITY = "匹配优先级 越大优先级越高";
	public static final String ALIAS_NEED_BIND = "是否需要绑定";
	public static final String ALIAS_UNBIND_CONTENT = "未绑定内容";
	public static final String ALIAS_CREATE_DATE = "createDate";
	public static final String ALIAS_UPDATE_DATE = "updateDate";
	public static final String ALIAS_DEL_FLAG = "delFlag";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * 关键字       db_column: key 
     */	
	private java.lang.String key;
    /**
     * 回复类型       db_column: response_type 
     */	
	private java.lang.String responseType;
    /**
     * 内容       db_column: content 
     */	
	private java.lang.String content;
    /**
     * 标题       db_column: title 
     */	
	private java.lang.String title;
    /**
     * 图片地址       db_column: picture 
     */	
	private java.lang.String picture;
    /**
     * 链接       db_column: url 
     */	
	private java.lang.String url;
    /**
     * 匹配优先级 越大优先级越高       db_column: priority 
     */	
	private java.lang.Integer priority;
    /**
     * 是否需要绑定       db_column: need_bind 
     */	
	private java.lang.Boolean needBind;
    /**
     * 未绑定内容       db_column: unbind_content 
     */	
	private java.lang.String unbindContent;
    /**
     * createDate       db_column: create_date 
     */	
	private java.util.Date createDate;
    /**
     * updateDate       db_column: update_date 
     */	
	private java.util.Date updateDate;
    /**
     * delFlag       db_column: del_flag 
     */	
	private java.lang.Integer delFlag;
	//columns END

	public PlatformKeyword(){
	}

	public PlatformKeyword(
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
	public void setKey(java.lang.String value) {
		this.key = value;
	}
	public java.lang.String getKey() {
		return this.key;
	}
	public void setResponseType(java.lang.String value) {
		this.responseType = value;
	}
	public java.lang.String getResponseType() {
		return this.responseType;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	public java.lang.String getContent() {
		return this.content;
	}
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	public java.lang.String getTitle() {
		return this.title;
	}
	public void setPicture(java.lang.String value) {
		this.picture = value;
	}
	public java.lang.String getPicture() {
		return this.picture;
	}
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	public java.lang.String getUrl() {
		return this.url;
	}
	public void setPriority(java.lang.Integer value) {
		this.priority = value;
	}
	public java.lang.Integer getPriority() {
		return this.priority;
	}
	public java.lang.Boolean getNeedBind() {
		return needBind;
	}
	public void setNeedBind(java.lang.Boolean needBind) {
		this.needBind = needBind;
	}
	public void setUnbindContent(java.lang.String value) {
		this.unbindContent = value;
	}
	public java.lang.String getUnbindContent() {
		return this.unbindContent;
	}
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	public void setUpdateDate(java.util.Date value) {
		this.updateDate = value;
	}
	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}
	public void setDelFlag(java.lang.Integer value) {
		this.delFlag = value;
	}
	public java.lang.Integer getDelFlag() {
		return this.delFlag;
	}
}

