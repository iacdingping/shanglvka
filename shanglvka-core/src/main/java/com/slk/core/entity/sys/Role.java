package com.slk.core.entity.sys;



/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class Role {
	
	//alias
	public static final String TABLE_ALIAS = "Role";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_PARENT = "父角色";
	public static final String ALIAS_NAME = "名称";
	public static final String ALIAS_ICON = "图标";
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
     * 父角色       db_column: parent 
     */	
	private java.lang.String parent;
    /**
     * 名称       db_column: name 
     */	
	private java.lang.String name;
    /**
     * 图标       db_column: icon 
     */	
	private java.lang.String icon;
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

	public Role(){
	}

	public Role(
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
	public void setParent(java.lang.String value) {
		this.parent = value;
	}
	public java.lang.String getParent() {
		return this.parent;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	public java.lang.String getName() {
		return this.name;
	}
	public void setIcon(java.lang.String value) {
		this.icon = value;
	}
	public java.lang.String getIcon() {
		return this.icon;
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

