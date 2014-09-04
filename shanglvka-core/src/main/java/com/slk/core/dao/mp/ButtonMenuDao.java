package com.slk.core.dao.mp;

import com.slk.core.BaseMyBatisRepository;
import com.slk.core.entity.mp.ButtonMenu;
import com.slk.core.query.mp.ButtonMenuQuery;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@MyBatisDao
public interface ButtonMenuDao extends
		BaseMyBatisRepository<ButtonMenu, java.lang.Long> {
	public void deleteByParentId(Long parent);
	public Long countByParent(ButtonMenuQuery buttonMenuQuery);
	
	
}
