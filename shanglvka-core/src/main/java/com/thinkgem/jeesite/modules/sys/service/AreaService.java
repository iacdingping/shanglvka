/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slk.hibernate.core.entity.MerchantType;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.sys.dao.AreaDao;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 区域Service
 * 
 * @author ThinkGem
 * @version 2013-5-29
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends BaseService {

	@Autowired
	private AreaDao areaDao;

	public Area get(String id) {
		return areaDao.get(id);
	}

	public List<Area> findAll(String pid) {
		return UserUtils.getAreaList(pid);
	}

	public List<Area> findAllByPid(String pid) {
		@SuppressWarnings("unchecked")
		List<Area> areaList = (List<Area>) UserUtils
				.getCache(UserUtils.CACHE_AREA_LIST + pid);
		if (areaList == null) {
			DetachedCriteria dc = areaDao.createDetachedCriteria();
			dc.add(Restrictions.eq("parent.id", pid));
			dc.add(Restrictions.eq(Area.FIELD_DEL_FLAG, Area.DEL_FLAG_NORMAL));
			dc.addOrder(Order.asc("sort")).addOrder(Order.desc("id"));
			areaList = areaDao.find(dc);
			UserUtils.putCache(UserUtils.CACHE_AREA_LIST + pid, areaList);
		}
		return areaList;
	}

	@Transactional(readOnly = false)
	public void save(Area area) {
		area.setParent(this.get(area.getParent().getId()));
		String oldParentIds = area.getParentIds(); // 获取修改前的parentIds，用于更新子节点的parentIds
		area.setParentIds(area.getParent().getParentIds()
				+ area.getParent().getId() + ",");
		areaDao.clear();
		areaDao.save(area);
		// 更新子节点 parentIds
		List<Area> list = areaDao.findByParentIdsLike("%," + area.getId()
				+ ",%");
		for (Area e : list) {
			e.setParentIds(e.getParentIds().replace(oldParentIds,
					area.getParentIds()));
		}
		areaDao.save(list);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}

	@Transactional(readOnly = false)
	public void delete(String id) {
		areaDao.deleteById(id, "%," + id + ",%");
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}

	public Area getByCode(String code) {
		return areaDao.getByCode(code);
	}

}
