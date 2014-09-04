/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.thinkgem.jeesite.modules.cms.entity;

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
import com.thinkgem.jeesite.common.persistence.IdEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 投票记录Entity
 * 
 * @author 禹波
 * @version 2014-09-04
 */
@Entity
@Table(name = "cms_voting_log")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VotingLog extends BaseEntity<VotingLog> {

	private static final long serialVersionUID = 1L;

	private java.lang.Long id; // id
	private java.lang.String ip; // ip
	private java.lang.String articleId; // article_id
	private java.util.Date createTime; // create_time
	private Long voting;
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getIp() {
		return ip;
	}

	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}

	public java.lang.String getArticleId() {
		return articleId;
	}

	public void setArticleId(java.lang.String articleId) {
		this.articleId = articleId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public Long getVoting() {
		return voting;
	}

	public void setVoting(Long voting) {
		this.voting = voting;
	}

}
