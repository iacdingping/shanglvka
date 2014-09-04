/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.thinkgem.jeesite.modules.cms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.cms.entity.Voting;
import com.thinkgem.jeesite.modules.cms.entity.VotingLog;
import com.thinkgem.jeesite.modules.cms.dao.VotingDao;
import com.thinkgem.jeesite.modules.cms.dao.VotingLogDao;

/**
 * 投票记录Service
 * 
 * @author 禹波
 * @version 2014-09-04
 */
@Component
@Transactional(readOnly = true)
public class VotingLogService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory
			.getLogger(VotingLogService.class);

	@Autowired
	private VotingLogDao votingLogDao;
	@Autowired
	private VotingDao votingDao;

	public VotingLog get(Long id) {
		return votingLogDao.get(id);
	}

	public Page<VotingLog> find(Page<VotingLog> page, VotingLog votingLog) {
		DetachedCriteria dc = votingLogDao.createDetachedCriteria();
		// 添加查询条件
		if (null != votingLog.getVoting() && votingLog.getVoting() > 0) {
			dc.add(Restrictions.eq("voting", votingLog.getVoting()));
		}
		// dc.add(Restrictions.eq(VotingLog.DEL_FLAG,
		// VotingLog.DEL_FLAG_NORMAL));
		// dc.addOrder(Order.desc("id"));
		return votingLogDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(VotingLog votingLog) {
		votingLogDao.save(votingLog);
	}

	@Transactional(readOnly = false)
	public void saveAll(String articleId, String phone, String[] voteSelect,
			String ip) {
		List<VotingLog> votingLogs = new ArrayList<VotingLog>();
		for (String str : voteSelect) {
			Voting voting = votingDao.get(Long.valueOf(str));
			voting.setVoteCount(voting.getVoteCount() + 1);
			votingDao.save(voting);
			VotingLog votingLog = new VotingLog();
			votingLog.setArticleId(articleId);
			votingLog.setVoting(voting.getId());
			votingLog.setCreateTime(new Date());
			votingLog.setPhone(phone);
			votingLog.setIp(ip);
			votingLogs.add(votingLog);
		}
		votingLogDao.save(votingLogs);
	}

	public boolean checkIsVoted(String phone, String articleId) {
		DetachedCriteria dc = votingLogDao.createDetachedCriteria();
		dc.add(Restrictions.eq("phone", phone));
		dc.add(Restrictions.eq("articleId", articleId));
		return votingLogDao.count(dc) == 0l;
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		votingLogDao.deleteById(id);
	}

}
