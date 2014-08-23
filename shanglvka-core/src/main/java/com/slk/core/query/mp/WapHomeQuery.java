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
public class WapHomeQuery extends PageQuery {

	/** id */
	private java.lang.Long id;
	/** 位置，1活动，2快捷图标，3底部列表 */
	private java.lang.Integer location;
	/** 标题名称 */
	private java.lang.String title;
	/** 超链接 */
	private java.lang.String link;
	/** 图片地址 */
	private java.lang.String pic;
	/** 排序（升序） */
	private java.lang.Integer sort;
	/** 创建人 */
	private java.lang.String createBy;
	/** 创建时间 */
	private java.util.Date createDateBegin;
	private java.util.Date createDateEnd;
	/** 更新人 */
	private java.lang.String updateBy;
	/** 更新时间 */
	private java.util.Date updateDateBegin;
	private java.util.Date updateDateEnd;
	/** 删除标记，0发布，1删除 */
	private java.lang.String delFlag;

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}

	public java.lang.Integer getLocation() {
		return this.location;
	}

	public void setLocation(java.lang.Integer value) {
		this.location = value;
	}

	public java.lang.String getTitle() {
		return this.title;
	}

	public void setTitle(java.lang.String value) {
		this.title = value;
	}

	public java.lang.String getLink() {
		return this.link;
	}

	public void setLink(java.lang.String value) {
		this.link = value;
	}

	public java.lang.String getPic() {
		return this.pic;
	}

	public void setPic(java.lang.String value) {
		this.pic = value;
	}

	public java.lang.Integer getSort() {
		return this.sort;
	}

	public void setSort(java.lang.Integer value) {
		this.sort = value;
	}

	public java.lang.String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(java.lang.String value) {
		this.createBy = value;
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

	public java.lang.String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(java.lang.String value) {
		this.updateBy = value;
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

	public java.lang.String getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(java.lang.String value) {
		this.delFlag = value;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
