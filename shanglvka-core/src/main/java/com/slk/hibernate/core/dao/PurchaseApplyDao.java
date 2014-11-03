/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.slk.hibernate.core.entity.PurchaseApply;
import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.common.persistence.Parameter;
import com.thinkgem.jeesite.common.utils.Reflections;

/**
 * 申购单DAO接口
 * 
 * @author 禹波
 * @version 2014-10-29
 */
@Repository
public class PurchaseApplyDao extends BaseDao<PurchaseApply> {
	/**
	 * 逻辑删除
	 * 
	 * @param id
	 * @return
	 */
	public int treatById(Serializable id) {
		return update("update "
				+ Reflections.getClassGenricType(getClass()).getSimpleName()
				+ " set isTreat='" + BaseEntity.DEL_FLAG_DELETE
				+ "' where id = :p1", new Parameter(id));
	}
}