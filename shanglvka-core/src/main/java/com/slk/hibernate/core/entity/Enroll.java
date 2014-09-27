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
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.common.utils.DateUtils;

/**
 * 商旅活动Entity
 * 
 * @author 禹波
 * @version 2014-09-27
 */
@Entity
@Table(name = "slk_enroll")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Enroll extends BaseEntity<Enroll> {

	private static final long serialVersionUID = 1L;
	public static final String FIELD_CONTACT_PHONE = "contactPhone";

	private java.lang.Long id; // id
	private java.lang.String contact; // contact
	private java.lang.String contactPhone; // contact_phone
	private Date enrollDate; // enroll_date
	private Date enrollTime; // enroll_time
	private java.lang.String note; // note
	private Date createDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getContact() {
		return contact;
	}

	public void setContact(java.lang.String contact) {
		this.contact = contact;
	}

	public java.lang.String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(java.lang.String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}
	
	public void setEnrollDateStr(String enrollDateStr) {
		setEnrollDate(DateUtils.parseDate(enrollDateStr));
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getEnrollTime() {
		return enrollTime;
	}
	
	public void setEnrollTimeStr(String enrollTimeStr) {
		setEnrollTime(DateUtils.parseDate(enrollTimeStr));
	}

	public void setEnrollTime(Date enrollTime) {
		this.enrollTime = enrollTime;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
	}

}
