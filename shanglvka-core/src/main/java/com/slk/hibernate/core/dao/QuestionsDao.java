/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.slk.hibernate.core.entity.Questions;
import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.common.persistence.Parameter;
import com.thinkgem.jeesite.common.utils.Reflections;

/**
 * 常见问题解答DAO接口
 * 
 * @author 禹波
 * @version 2014-10-29
 */
@Repository
public class QuestionsDao extends BaseDao<Questions> {
	/**
	 * 物理删除
	 * 
	 * @param id
	 * @param likeParentIds
	 * @return
	 */
	@Override
	public int deleteById(Serializable id) {
		return update("delete "
				+ Reflections.getClassGenricType(getClass()).getSimpleName()
				+ " where id = :p1 ", new Parameter(id));
	}
}