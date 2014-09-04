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

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.persistence.IdEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 投票Entity
 * 
 * @author 禹波
 * @version 2014-09-04
 */
@Entity
@Table(name = "cms_voting")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Voting extends DataEntity<Voting> {

	private static final long serialVersionUID = 1L;

	private java.lang.Long id; // id
	private java.lang.String title; // title
	private java.lang.String description; // description
	private Long voteCount; // vote_count
	private java.lang.String articleId; // article_id
	private Voting() {

	}

	public Voting(String title, String articleId) {
		this.title = title;
		this.description = title;
		this.voteCount = 0l;
		this.articleId = articleId;
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

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public Long getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Long voteCount) {
		this.voteCount = voteCount;
	}

	public java.lang.String getArticleId() {
		return articleId;
	}

	public void setArticleId(java.lang.String articleId) {
		this.articleId = articleId;
	}
}
