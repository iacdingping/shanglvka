/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 申购单Entity
 * 
 * @author 禹波
 * @version 2014-10-29
 */
@Entity
@Table(name = "slk_purchase_apply")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PurchaseApply extends BaseEntity<PurchaseApply> {

	private static final long serialVersionUID = 1L;

	private java.lang.Long id; // id
	private java.lang.String platformCode; // platform_code
	private String buyMoney; // buy_money
	private java.lang.String buyName; // buy_name
	private java.lang.String buyPhone; // buy_phone
	private java.lang.String buyUnit; // buy_unit
	private java.util.Date createTime; // create_time
	private String isTreat;

	public String getIsTreat() {
		return isTreat;
	}

	public void setIsTreat(String isTreat) {
		this.isTreat = isTreat;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(java.lang.String platformCode) {
		this.platformCode = platformCode;
	}

	public String getBuyMoney() {
		return buyMoney;
	}

	public void setBuyMoney(String buyMoney) {
		this.buyMoney = buyMoney;
	}

	public java.lang.String getBuyName() {
		return buyName;
	}

	public void setBuyName(java.lang.String buyName) {
		this.buyName = buyName;
	}

	public java.lang.String getBuyPhone() {
		return buyPhone;
	}

	public void setBuyPhone(java.lang.String buyPhone) {
		this.buyPhone = buyPhone;
	}

	public java.lang.String getBuyUnit() {
		return buyUnit;
	}

	public void setBuyUnit(java.lang.String buyUnit) {
		this.buyUnit = buyUnit;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

}
