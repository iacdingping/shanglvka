package com.slk.core.entity.mp;

import com.thinkgem.jeesite.common.persistence.BaseEntity;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class WeixinUser extends BaseEntity<WeixinUser> {

	// alias
	public static final String TABLE_ALIAS = "微信用户";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_IDENTIFICATION = "身份标识";
	public static final String ALIAS_PLATFORM_CODE = "平台号码";
	public static final String ALIAS_TYPE = "类型 1 关注 2 取消关注 3 绑定";
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
	 * 身份标识 db_column: identification
	 */
	private java.lang.String identification;
	/**
	 * 平台号码 db_column: platform_code
	 */
	private java.lang.String platformCode;
	/**
	 * 类型 1 关注 2 取消关注 3 绑定 db_column: type
	 */
	private java.lang.Integer type;
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
	private java.lang.Integer delFlag;

	// columns END

	public WeixinUser() {
	}

	public WeixinUser(java.lang.Long id) {
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setIdentification(java.lang.String value) {
		this.identification = value;
	}

	public java.lang.String getIdentification() {
		return this.identification;
	}

	public void setPlatformCode(java.lang.String value) {
		this.platformCode = value;
	}

	public java.lang.String getPlatformCode() {
		return this.platformCode;
	}

	public void setType(java.lang.Integer value) {
		this.type = value;
	}

	public java.lang.Integer getType() {
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

	public void setDelFlag(java.lang.Integer value) {
		this.delFlag = value;
	}

	public java.lang.Integer getDelFlag() {
		return this.delFlag;
	}

	private String phone;
	private String isStaff;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(String isStaff) {
		this.isStaff = isStaff;
	}

	private String nickname;
	private int sex;
	private String province;
	private String city;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
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
}
