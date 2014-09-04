/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.thinkgem.jeesite.modules.cms.service;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.persistence.Parameter;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.cms.entity.Voting;
import com.thinkgem.jeesite.modules.cms.dao.VotingDao;

/**
 * 投票Service
 * 
 * @author 禹波
 * @version 2014-09-04
 */
@Component
@Transactional(readOnly = true)
public class VotingService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(VotingService.class);

	@Autowired
	private VotingDao votingDao;

	public Voting get(Long id) {
		return votingDao.get(id);
	}

	public Page<Voting> find(Page<Voting> page, Voting voting) {
		DetachedCriteria dc = votingDao.createDetachedCriteria();
		// 添加查询条件
		if (null != voting.getTitle()
				&& StringUtils.isNotEmpty(voting.getTitle().toString())) {
			dc.add(Restrictions.like("title", "%" + voting.getTitle() + "%"));
		}
		if (null != voting.getArticleId()
				&& StringUtils.isNotEmpty(voting.getArticleId().toString())) {
			dc.add(Restrictions.eq("articleId", voting.getArticleId()));
		}
		// dc.addOrder(Order.desc("id"));
		return votingDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(Voting voting) {
		votingDao.save(voting);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		votingDao.deleteById(id);
	}

	public List<Voting> listByArticleId(String articleId) {
		DetachedCriteria dc = votingDao.createDetachedCriteria();
		dc.add(Restrictions.eq("articleId", articleId));
		return votingDao.find(dc);
	}
}
