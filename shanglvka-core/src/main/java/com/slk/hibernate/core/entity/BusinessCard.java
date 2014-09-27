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

import com.thinkgem.jeesite.common.persistence.BaseEntity;

/**
 * 商旅地图Entity
 * 
 * @author 禹波
 * @version 2014-09-27
 */
@Entity
@Table(name = "slk_business_card")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BusinessCard extends BaseEntity<BusinessCard> {

	private static final long serialVersionUID = 1L;

	private java.lang.Long id; // id
	private java.lang.String name; // name
	private java.lang.String phone; // phone
	private java.lang.String mail; // mail
	private java.lang.String address; // address
	private java.lang.String icoHeader; // address
	private java.lang.String job; //工作 

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

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getMail() {
		return mail;
	}

	public void setMail(java.lang.String mail) {
		this.mail = mail;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getIcoHeader() {
		return icoHeader;
	}

	public void setIcoHeader(java.lang.String icoHeader) {
		this.icoHeader = icoHeader;
	}

	public java.lang.String getJob() {
		return job;
	}

	public void setJob(java.lang.String job) {
		this.job = job;
	}

}
