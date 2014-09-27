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

	private java.lang.Long id; // id
	private java.lang.String contact; // contact
	private java.lang.String contactPhone; // contact_phone
	private String enrollDate; // enroll_date
	private String enrollTime; // enroll_time
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

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getEnrollTime() {
		return enrollTime;
	}

	public void setEnrollTime(String enrollTime) {
		this.enrollTime = enrollTime;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
	}

}
