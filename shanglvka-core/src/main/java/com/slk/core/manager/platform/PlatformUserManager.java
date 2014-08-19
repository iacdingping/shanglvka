package com.slk.core.manager.platform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.platform.PlatformUserDao;
import com.slk.core.entity.platform.PlatformUser;
import com.slk.core.query.platform.PlatformUserQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class PlatformUserManager {

	@Autowired
	private PlatformUserDao platformUserDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setPlatformUserDao(PlatformUserDao dao) {
		this.platformUserDao = dao;
	}
	
	/** 
	 * 创建PlatformUser
	 **/
	public PlatformUser save(PlatformUser platformUser) {
	    Assert.notNull(platformUser,"'platformUser' must be not null");
	    this.platformUserDao.save(platformUser);
	    return platformUser;
	}
	
	/** 
	 * 更新PlatformUser
	 **/	
    public PlatformUser update(PlatformUser platformUser) {
        Assert.notNull(platformUser,"'platformUser' must be not null");
        this.platformUserDao.update(platformUser);
        return platformUser;
    }	
    
	/** 
	 * 删除PlatformUser
	 **/
    public void deleteById(java.lang.Long id) {
        this.platformUserDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到PlatformUser
	 **/    
    public PlatformUser getById(java.lang.Long id) {
        return this.platformUserDao.getById(id);
    }
    
	/** 
	 * 统计总数PlatformUser
	 **/ 
	public Long count(PageQuery query) {
		return platformUserDao.count(query);
	}
	
	/** 
	 * list PlatformUser
	 **/ 
	public List<PlatformUser> list(PageQuery query) {
		return platformUserDao.list(query);
	}
	
	/** 
	 * 分页查询: PlatformUser
	 **/      
	@Transactional(readOnly=true)
	public PageList<PlatformUser> findPage(PlatformUserQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<PlatformUser>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}

	public PlatformUser getByPlatformCode(String fromUserName) {
		PlatformUserQuery query = new PlatformUserQuery();
		query.setPlatformCode(fromUserName);
		List<PlatformUser> lists = list(query);
		return lists.isEmpty() ? null : lists.get(0);
	}
	
}
