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
public class WeixinUserQuery extends PageQuery {

	/** id */
	private java.lang.Long id;
	/** 身份标识 */
	private java.lang.String identification;
	/** 平台号码 */
	private java.lang.String platformCode;
	/** 类型 1 关注 2 取消关注 3 绑定 */
	private java.lang.Integer type;
	/** createDate */
	private java.util.Date createDateBegin;
	private java.util.Date createDateEnd;
	/** updateDate */
	private java.util.Date updateDateBegin;
	private java.util.Date updateDateEnd;
	/** delFlag */
	private java.lang.Integer delFlag;
	private String nickname;
	private String sex;
	private String province;
	private String city;
	private String phone;
	private Boolean isStaff;
	private Boolean queried;

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}

	public java.lang.String getIdentification() {
		return this.identification;
	}

	public void setIdentification(java.lang.String value) {
		this.identification = value;
	}

	public java.lang.String getPlatformCode() {
		return this.platformCode;
	}

	public void setPlatformCode(java.lang.String value) {
		this.platformCode = value;
	}

	public java.lang.Integer getType() {
		return this.type;
	}

	public void setType(java.lang.Integer value) {
		this.type = value;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(Boolean isStaff) {
		this.isStaff = isStaff;
	}

	public Boolean getQueried() {
		return queried;
	}

	public void setQueried(Boolean queried) {
		this.queried = queried;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
