/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.slk.hibernate.core.dao.MerchantBrandDao;
import com.slk.hibernate.core.entity.MerchantBrand;
import com.slk.hibernate.core.entity.MerchantType;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 商旅品牌Service
 * 
 * @author 禹波
 * @version 2014-11-01
 */
@Component
@Transactional(readOnly = true)
public class MerchantBrandService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory
			.getLogger(MerchantBrandService.class);

	@Autowired
	private MerchantBrandDao merchantBrandDao;

	public MerchantBrand get(Long id) {
		return merchantBrandDao.get(id);
	}

	public List<MerchantBrand> list() {
		DetachedCriteria dc = merchantBrandDao.createDetachedCriteria();
		// 添加查询条件
		dc.add(Restrictions.eq(MerchantType.FIELD_DEL_FLAG,
				MerchantType.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return merchantBrandDao.find(dc);
	}

	public Page<MerchantBrand> find(Page<MerchantBrand> page,
			MerchantBrand merchantBrand) {
		DetachedCriteria dc = merchantBrandDao.createDetachedCriteria();
		// 添加查询条件
		dc.add(Restrictions.eq(MerchantType.FIELD_DEL_FLAG,
				MerchantType.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return merchantBrandDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(MerchantBrand merchantBrand) {
		merchantBrandDao.save(merchantBrand);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		merchantBrandDao.deleteById(id);
	}

	public List<MerchantBrand> findAllByTypeAndArea(Long typeId, String areaId,
			String name) {
		return merchantBrandDao.findAllByTypeAndArea(typeId, areaId, name);
	}

}
