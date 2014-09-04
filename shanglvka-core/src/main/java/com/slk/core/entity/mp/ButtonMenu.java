package com.slk.core.entity.mp;

import com.thinkgem.jeesite.common.persistence.BaseEntity;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class ButtonMenu extends BaseEntity<ButtonMenu> {

	// alias
	public static final String TABLE_ALIAS = "微信平台自定义菜单";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "菜单名称";
	public static final String ALIAS_KEY = "响应键标识(mp_platform_keyword关键字对应)";
	public static final String ALIAS_PARENT = "父ID";
	public static final String ALIAS_TYPE = "类型 BUTTON,LINK";
	public static final String ALIAS_CREATE_DATE = "createDate";
	public static final String ALIAS_UPDATE_DATE = "updateDate";
	public static final String ALIAS_DEL_FLAG = "delFlag";

	// 可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// columns START
	/**
	 * id db_column: id
	 */
	private java.lang.Long id;
	/**
	 * 菜单名称 db_column: name
	 */
	private java.lang.String name;
	/**
	 * 响应键标识(mp_platform_keyword关键字对应) db_column: key
	 */
	private java.lang.String key;
	/**
	 * 父ID db_column: parent
	 */
	private ButtonMenu parent;
	/**
	 * 类型 BUTTON,LINK db_column: type
	 */
	private java.lang.String type;
	/**
	 * createDate db_column: create_date
	 */
	private java.util.Date createDate;
	/**
	 * updateDate db_column: update_date
	 */
	private java.util.Date updateDate;
	/**
	 * delFlag db_column: del_flag
	 */
	private java.lang.Boolean delFlag;

	private boolean parentClass;
	private boolean subClass;

	// columns END

	public ButtonMenu() {
	}

	public ButtonMenu(java.lang.Long id) {
		this.id = id;
	}

	public boolean isSubClass() {
		return subClass;
	}

	public void setSubClass(boolean subClass) {
		this.subClass = subClass;
	}

	public boolean isParentClass() {
		return parentClass;
	}

	public void setParentClass(boolean parentClass) {
		this.parentClass = parentClass;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setName(java.lang.String value) {
		this.name = value;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setKey(java.lang.String value) {
		this.key = value;
	}

	public java.lang.String getKey() {
		return this.key;
	}

	// public void setParent(java.lang.Long value) {
	// this.parent = value;
	// }
	// public java.lang.Long getParent() {
	// return this.parent;
	// }
	public void setType(java.lang.String value) {
		this.type = value;
	}

	public java.lang.String getType() {
		return this.type;
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

	public void setDelFlag(java.lang.Boolean value) {
		this.delFlag = value;
	}

	public java.lang.Boolean getDelFlag() {
		return this.delFlag;
	}

	public ButtonMenu getParent() {
		return parent;
	}

	public void setParent(ButtonMenu parent) {
		this.parent = parent;
	}

}
