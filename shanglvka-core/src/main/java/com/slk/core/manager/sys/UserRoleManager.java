package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.UserRoleDao;
import com.slk.core.entity.sys.UserRole;
import com.slk.core.query.sys.UserRoleQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class UserRoleManager {

	@Autowired
	private UserRoleDao userRoleDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUserRoleDao(UserRoleDao dao) {
		this.userRoleDao = dao;
	}
	
	/** 
	 * 创建UserRole
	 **/
	public UserRole save(UserRole userRole) {
	    Assert.notNull(userRole,"'userRole' must be not null");
	    this.userRoleDao.save(userRole);
	    return userRole;
	}
	
	/** 
	 * 更新UserRole
	 **/	
    public UserRole update(UserRole userRole) {
        Assert.notNull(userRole,"'userRole' must be not null");
        this.userRoleDao.update(userRole);
        return userRole;
    }	
    
	/** 
	 * 删除UserRole
	 **/
    public void deleteById(java.lang.Long id) {
        this.userRoleDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到UserRole
	 **/    
    public UserRole getById(java.lang.Long id) {
        return this.userRoleDao.getById(id);
    }
    
	/** 
	 * 统计总数UserRole
	 **/ 
	public Long count(PageQuery query) {
		return userRoleDao.count(query);
	}
	
	/** 
	 * list UserRole
	 **/ 
	public List<UserRole> list(PageQuery query) {
		return userRoleDao.list(query);
	}
	
	/** 
	 * 分页查询: UserRole
	 **/      
	@Transactional(readOnly=true)
	public PageList<UserRole> findPage(UserRoleQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<UserRole>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}

	public List<UserRole> getByUser(Long userId) {
		UserRoleQuery query = new UserRoleQuery();
		query.setUser(userId);
		return list(query);
	}
	
}
