/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.slk.hibernate.core.dao.MerchantMapDao;
import com.slk.hibernate.core.entity.MerchantMap;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 商旅地图Service
 * 
 * @author 禹波
 * @version 2014-08-23
 */
@Component
@Transactional(readOnly = true)
public class MerchantMapService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory
			.getLogger(MerchantMapService.class);

	@Autowired
	private MerchantMapDao merchantMapDao;

	public MerchantMap get(Long id) {
		return merchantMapDao.get(id);
	}

	public List<MerchantMap> listByBrand(Long brandId) {
		DetachedCriteria dc = merchantMapDao.createDetachedCriteria();
		dc.add(Restrictions.eq(MerchantMap.FIELD_DEL_FLAG,
				MerchantMap.DEL_FLAG_NORMAL));
		dc.add(Restrictions.eq("merchantBrand.id", brandId));
		return merchantMapDao.find(dc);
	}

	public Page<MerchantMap> find(Page<MerchantMap> page,
			MerchantMap merchantMap) {
		DetachedCriteria dc = merchantMapDao.createDetachedCriteria();
		if (com.thinkgem.jeesite.common.utils.StringUtils
				.isNotBlank(merchantMap.getTitle())) {
			// 添加查询条件
			dc.add(Restrictions.like("title", merchantMap.getTitle(),
					MatchMode.ANYWHERE));
		}
		dc.add(Restrictions.eq(MerchantMap.FIELD_DEL_FLAG,
				MerchantMap.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return merchantMapDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(MerchantMap merchantMap) {
		merchantMapDao.clear();
		merchantMapDao.save(merchantMap);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		merchantMapDao.deleteById(id);
	}

}
