package com.slk.core.dao.mp;

import com.slk.core.BaseMyBatisRepository;
import com.slk.core.entity.mp.Keyword;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@MyBatisDao
public interface KeywordDao extends BaseMyBatisRepository<Keyword,java.lang.Long>{

	Keyword findByKey(String content);
}
