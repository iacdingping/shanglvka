/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.BaseEntity;

/**
 * 商旅品牌Entity
 * 
 * @author 禹波
 * @version 2014-11-01
 */
@Entity
@Table(name = "slk_merchant_brand")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MerchantBrand extends BaseEntity<MerchantBrand> {

	private static final long serialVersionUID = 1L;

	private java.lang.Long id; // id
	private java.lang.String name; // name
	private java.lang.String pic;
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private String delFlag;

	@Length(min = 1, max = 1)
	@Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public MerchantBrand() {
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public java.lang.String getPic() {
		return pic;
	}

	public void setPic(java.lang.String pic) {
		this.pic = pic;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
}
