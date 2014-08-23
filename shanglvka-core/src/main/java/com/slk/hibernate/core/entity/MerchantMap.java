/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.Area;

/**
 * 商旅地图Entity
 * 
 * @author 禹波
 * @version 2014-08-23
 */
@Entity
@Table(name = "slk_merchant_map")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MerchantMap extends DataEntity<MerchantMap> {

	private static final long serialVersionUID = 1L;

	private java.lang.Long id; // id
	private java.lang.String title; // title
	private java.lang.String smallPic; // small_pic
	private java.lang.String bgPic; // bg_pic
	private java.lang.String address; // address
	private java.lang.String phone; // phone
	private java.lang.String offer; // offer
	private java.lang.String detail; // detail
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private Area area;

	@ManyToOne(cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "area_id", referencedColumnName = "code")
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getSmallPic() {
		return smallPic;
	}

	public void setSmallPic(java.lang.String smallPic) {
		this.smallPic = smallPic;
	}

	public java.lang.String getBgPic() {
		return bgPic;
	}

	public void setBgPic(java.lang.String bgPic) {
		this.bgPic = bgPic;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getOffer() {
		return offer;
	}

	public void setOffer(java.lang.String offer) {
		this.offer = offer;
	}

	public java.lang.String getDetail() {
		return detail;
	}

	public void setDetail(java.lang.String detail) {
		this.detail = detail;
	}
}
