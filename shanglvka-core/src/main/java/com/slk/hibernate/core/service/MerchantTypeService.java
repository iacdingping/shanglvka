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

import com.slk.hibernate.core.dao.MerchantTypeDao;
import com.slk.hibernate.core.entity.MerchantType;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 商旅类别Service
 * 
 * @author 禹波
 * @version 2014-11-01
 */
@Component
@Transactional(readOnly = true)
public class MerchantTypeService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory
			.getLogger(MerchantTypeService.class);

	@Autowired
	private MerchantTypeDao merchantTypeDao;

	public MerchantType get(Long id) {
		return merchantTypeDao.get(id);
	}

	public List<MerchantType> findAll() {
		return UserUtils.findAllMerchantType();
	}

	public List<MerchantType> findAllByPid(Long pid) {
		@SuppressWarnings("unchecked")
		List<MerchantType> typeList = (List<MerchantType>) UserUtils
				.getCache(UserUtils.CACHE_MERCHANT_TYPE_LIST + pid);
		if (typeList == null) {
			DetachedCriteria dc = merchantTypeDao.createDetachedCriteria();
			// 添加查询条件
			dc.add(Restrictions.eq(MerchantType.FIELD_DEL_FLAG,
					MerchantType.DEL_FLAG_NORMAL));
			dc.add(Restrictions.eq("parentId", pid));
			dc.addOrder(Order.desc("id"));
			typeList = UserUtils.findAllMerchantType();
			UserUtils.putCache(UserUtils.CACHE_MERCHANT_TYPE_LIST + pid,
					typeList);
		}
		return typeList;
	}

	public Page<MerchantType> find(Page<MerchantType> page,
			MerchantType merchantType) {
		DetachedCriteria dc = merchantTypeDao.createDetachedCriteria();
		// 添加查询条件
		dc.add(Restrictions.eq(MerchantType.FIELD_DEL_FLAG,
				MerchantType.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return merchantTypeDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(MerchantType merchantType) {
		merchantType.setParent(this.get(merchantType.getParent().getId()));
		merchantTypeDao.clear();
		merchantTypeDao.save(merchantType);
		UserUtils.removeCache(UserUtils.CACHE_MERCHANT_TYPE_LIST);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		merchantTypeDao.deleteById(id);
		UserUtils.removeCache(UserUtils.CACHE_MERCHANT_TYPE_LIST);
	}

}
