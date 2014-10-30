/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.service;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.slk.hibernate.core.dao.QuestionsDao;
import com.slk.hibernate.core.entity.Questions;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 常见问题解答Service
 * 
 * @author 禹波
 * @version 2014-10-29
 */
@Component
@Transactional(readOnly = true)
public class QuestionsService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory
			.getLogger(QuestionsService.class);

	@Autowired
	private QuestionsDao questionsDao;

	public Questions get(Long id) {
		return questionsDao.get(id);
	}

	public Page<Questions> find(Page<Questions> page, Questions questions) {
		DetachedCriteria dc = questionsDao.createDetachedCriteria();
		if (!com.thinkgem.jeesite.common.utils.StringUtils.isEmpty(questions
				.getType())) {
			dc.add(Restrictions.eq("type", questions.getType()));
		}
		dc.addOrder(Order.desc("id"));
		return questionsDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(Questions questions) {
		questionsDao.save(questions);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		questionsDao.deleteById(id);
	}

}
