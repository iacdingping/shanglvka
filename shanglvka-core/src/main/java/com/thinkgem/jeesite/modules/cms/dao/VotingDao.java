/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.thinkgem.jeesite.modules.cms.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.Parameter;
import com.thinkgem.jeesite.modules.cms.entity.Voting;

/**
 * 投票DAO接口
 * 
 * @author 禹波
 * @version 2014-09-04
 */
@Repository
public class VotingDao extends BaseDao<Voting> {
	public int deleteAllByArticleId(Serializable articleId) {
		return update("delete from  Voting where articleId=:p1", new Parameter(
				articleId));
	}
}