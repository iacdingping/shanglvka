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

import com.slk.hibernate.core.dao.BusinessCardDao;
import com.slk.hibernate.core.entity.BusinessCard;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 商旅地图Service
 * 
 * @author 禹波
 * @version 2014-09-27
 */
@Component
@Transactional(readOnly = true)
public class BusinessCardService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory
			.getLogger(BusinessCardService.class);

	@Autowired
	private BusinessCardDao businessCardDao;

	public BusinessCard get(Long id) {
		return businessCardDao.get(id);
	}

	public Page<BusinessCard> find(Page<BusinessCard> page,
			BusinessCard businessCard) {
		DetachedCriteria dc = businessCardDao.createDetachedCriteria();
		// 添加查询条件
		// dc.add(Restrictions.eq(BusinessCard.DEL_FLAG,
		// BusinessCard.DEL_FLAG_NORMAL));
		// dc.addOrder(Order.desc("id"));
		return businessCardDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(BusinessCard businessCard) {
		businessCardDao.save(businessCard);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		businessCardDao.deleteById(id);
	}

}
