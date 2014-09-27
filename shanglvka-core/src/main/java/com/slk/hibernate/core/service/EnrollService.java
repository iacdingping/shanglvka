/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.service;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.slk.hibernate.core.dao.EnrollDao;
import com.slk.hibernate.core.entity.Enroll;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;



/**
 * 商旅活动Service
 * @author 禹波
 * @version 2014-09-27
 */
@Component
@Transactional(readOnly = true)
public class EnrollService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(EnrollService.class);
	
	@Autowired
	private EnrollDao enrollDao;
	
	public Enroll get(Long id) {
		return enrollDao.get(id);
	}
	
	public Page<Enroll> find(Page<Enroll> page, Enroll enroll) {
		DetachedCriteria dc = enrollDao.createDetachedCriteria();
		//添加查询条件
		//dc.add(Restrictions.eq(Enroll.DEL_FLAG, Enroll.DEL_FLAG_NORMAL));
		//dc.addOrder(Order.desc("id"));
		return enrollDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Enroll enroll) {
		enroll.setCreateDate(new Date());
		enrollDao.save(enroll);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		enrollDao.deleteById(id);
	}

	@Transactional(readOnly = false)
	public boolean exists(String contactPhone) {
		DetachedCriteria dc = enrollDao.createDetachedCriteria();
		dc.add(Restrictions.eq(Enroll.FIELD_CONTACT_PHONE, contactPhone));
		return enrollDao.count(dc) > 0;
	}
	
}
