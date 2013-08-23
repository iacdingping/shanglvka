package com.slk.core.entity.mp;

import com.thinkgem.jeesite.common.persistence.BaseEntity;

/**
 * 
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class WapHome extends BaseEntity<WapHome> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2846563691523730980L;
	// alias
	public static final String TABLE_ALIAS = "WapHome";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_LOCATION = "位置，1活动，2快捷图标，3底部列表";
	public static final String ALIAS_TITLE = "标题名称";
	public static final String ALIAS_LINK = "超链接";
	public static final String ALIAS_PIC = "图片地址";
	public static final String ALIAS_SORT = "排序（升序）";
	public static final String ALIAS_CREATE_BY = "创建人";
	public static final String ALIAS_CREATE_DATE = "创建时间";
	public static final String ALIAS_UPDATE_BY = "更新人";
	public static final String ALIAS_UPDATE_DATE = "更新时间";
	public static final String ALIAS_DEL_FLAG = "删除标记，0发布，1删除";

	// 可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// columns START
	/**
	 * id db_column: id
	 */
	private java.lang.Long id;
	/**
	 * 位置，1活动，2快捷图标，3底部列表 db_column: location
	 */
	private java.lang.Integer location;
	/**
	 * 标题名称 db_column: title
	 */
	private java.lang.String title;
	/**
	 * 超链接 db_column: link
	 */
	private java.lang.String link;
	/**
	 * 图片地址 db_column: pic
	 */
	private java.lang.String pic;
	/**
	 * 排序（升序） db_column: sort
	 */
	private java.lang.Integer sort;
	/**
	 * 创建人 db_column: create_by
	 */
	private java.lang.String createBy;
	/**
	 * 创建时间 db_column: create_date
	 */
	private java.util.Date createDate;
	/**
	 * 更新人 db_column: update_by
	 */
	private java.lang.String updateBy;
	/**
	 * 更新时间 db_column: update_date
	 */
	private java.util.Date updateDate;
	/**
	 * 删除标记，0发布，1删除 db_column: del_flag
	 */
	private java.lang.String delFlag;

	// columns END

	public WapHome() {
	}

	public WapHome(java.lang.Long id) {
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setLocation(java.lang.Integer value) {
		this.location = value;
	}

	public java.lang.Integer getLocation() {
		return this.location;
	}

	public void setTitle(java.lang.String value) {
		this.title = value;
	}

	public java.lang.String getTitle() {
		return this.title;
	}

	public void setLink(java.lang.String value) {
		this.link = value;
	}

	public java.lang.String getLink() {
		return this.link;
	}

	public void setPic(java.lang.String value) {
		this.pic = value;
	}

	public java.lang.String getPic() {
		return this.pic;
	}

	public void setSort(java.lang.Integer value) {
		this.sort = value;
	}

	public java.lang.Integer getSort() {
		return this.sort;
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

	public void setDelFlag(java.lang.String value) {
		this.delFlag = value;
	}

	public java.lang.String getDelFlag() {
		return this.delFlag;
	}
}
