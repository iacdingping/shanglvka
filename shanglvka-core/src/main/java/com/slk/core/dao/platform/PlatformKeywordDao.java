package com.slk.core.dao.platform;

import com.slk.core.BaseMyBatisRepository;
import com.slk.core.MyBatisRepository;
import com.slk.core.entity.platform.PlatformKeyword;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@MyBatisRepository
public interface PlatformKeywordDao extends BaseMyBatisRepository<PlatformKeyword,java.lang.Long>{

	PlatformKeyword findByKey(String content);


}
