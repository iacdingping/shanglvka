package com.slk.core.dao.mp;

import com.slk.core.BaseMyBatisRepository;
import com.slk.core.entity.mp.WeixinUser;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@MyBatisDao
public interface WeixinUserDao extends BaseMyBatisRepository<WeixinUser,java.lang.Long>{

	void cancelAttentionUser(String fromUserName);
}
