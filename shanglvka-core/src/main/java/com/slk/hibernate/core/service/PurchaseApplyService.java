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

import com.slk.hibernate.core.dao.PurchaseApplyDao;
import com.slk.hibernate.core.entity.PurchaseApply;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;



/**
 * 申购单Service
 * @author 禹波
 * @version 2014-10-29
 */
@Component
@Transactional(readOnly = true)
public class PurchaseApplyService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PurchaseApplyService.class);
	
	@Autowired
	private PurchaseApplyDao purchaseApplyDao;
	
	public PurchaseApply get(Long id) {
		return purchaseApplyDao.get(id);
	}
	
	public Page<PurchaseApply> find(Page<PurchaseApply> page, PurchaseApply purchaseApply) {
		DetachedCriteria dc = purchaseApplyDao.createDetachedCriteria();
		//添加查询条件
		//dc.add(Restrictions.eq(PurchaseApply.DEL_FLAG, PurchaseApply.DEL_FLAG_NORMAL));
		//dc.addOrder(Order.desc("id"));
		return purchaseApplyDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(PurchaseApply purchaseApply) {
		purchaseApplyDao.save(purchaseApply);
	}
	
	@Transactional(readOnly = false)
	public void treat(Long id) {
		purchaseApplyDao.treatById(id);
	}
	
}
