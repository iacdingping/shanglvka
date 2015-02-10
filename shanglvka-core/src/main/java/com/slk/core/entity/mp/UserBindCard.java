package com.slk.core.entity.mp;

import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.common.utils.StringUtils;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
public class UserBindCard extends BaseEntity<UserBindCard> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5346304482079694611L;
	//alias
	public static final String TABLE_ALIAS = "UserBindCard";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_PLATFORM_CODE = "平台openid";
	public static final String ALIAS_CARD_NO = "绑定卡号";
	public static final String ALIAS_STATUS = "状态，0 删除绑定 1 绑定成功 2 绑定失败";
	public static final String ALIAS_UPDATE_TIME = "绑定时间";
	public static final String ALIAS_CREATE_DATE = "createDate";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * 平台openid       db_column: platform_code 
     */	
	private java.lang.String platformCode;
    /**
     * 绑定卡号       db_column: card_no 
     */	
	private java.lang.String cardNo;
    /**
     * 状态，0 删除绑定 1 绑定成功 2 绑定失败       db_column: status 
     */	
	private java.lang.Integer status;
    /**
     * 绑定时间       db_column: update_time 
     */	
	private java.util.Date updateTime;
    /**
     * createDate       db_column: create_date 
     */	
	private java.util.Date createDate;
	//columns END

	public UserBindCard(){
	}

	public UserBindCard(
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
	public void setPlatformCode(java.lang.String value) {
		this.platformCode = value;
	}
	public java.lang.String getPlatformCode() {
		return this.platformCode;
	}
	public void setCardNo(java.lang.String value) {
		this.cardNo = value;
	}
	public java.lang.String getCardNo() {
		return this.cardNo;
	}
	public String getHiddenCardNo() {
		return StringUtils.isNotEmpty(cardNo) ? 
				cardNo.substring(0, 4) + "********" + cardNo.subSequence(cardNo.length() - 4, cardNo.length())
				: "";
	}
	
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	public static void main(String[] args) {
		UserBindCard card = new UserBindCard();
		card.setCardNo("123sdfaskvadf0987");
		System.out.println(card.getHiddenCardNo());
	}
}

