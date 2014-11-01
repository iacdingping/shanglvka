/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
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

	private MerchantBrand merchantBrand;

	@ManyToOne(cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	public MerchantBrand getMerchantBrand() {
		return merchantBrand;
	}

	public void setMerchantBrand(MerchantBrand merchantBrand) {
		this.merchantBrand = merchantBrand;
	}

	private Area area;

	@ManyToOne(cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "area_id", referencedColumnName = "id")
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

	private List<MerchantType> typeList = Lists.newArrayList(); // 拥有类型列表

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "slk_map_type", joinColumns = { @JoinColumn(name = "map_id") }, inverseJoinColumns = { @JoinColumn(name = "type_id") })
	// @Where(clause = "del_flag='" + DEL_FLAG_NORMAL + "'")
	@OrderBy("id")
	@Fetch(FetchMode.SUBSELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JsonIgnore
	public List<MerchantType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<MerchantType> typeList) {
		this.typeList = typeList;
	}

	@Transient
	public List<Long> getTypeIdList() {
		List<Long> typeIdList = Lists.newArrayList();
		for (MerchantType merchantType : typeList) {
			typeIdList.add(merchantType.getId());
		}
		return typeIdList;
	}

	@Transient
	public void setTypeIdList(List<Long> typeIdList) {
		typeList = Lists.newArrayList();
		for (Long typeId : typeIdList) {
			MerchantType type = new MerchantType();
			type.setId(typeId);
			typeList.add(type);
		}
	}

	@Transient
	public String getTypeIds() {
		List<Long> nameIdList = Lists.newArrayList();
		for (MerchantType type : typeList) {
			nameIdList.add(type.getId());
		}
		return StringUtils.join(nameIdList, ",");
	}

	@Transient
	public void setTypeIds(String typeIds) {
		typeList = Lists.newArrayList();
		if (typeIds != null) {
			String[] ids = StringUtils.split(typeIds, ",");
			for (String typeId : ids) {
				MerchantType type = new MerchantType();
				type.setId(Long.valueOf(typeId));
				typeList.add(type);
			}
		}
	}

}
