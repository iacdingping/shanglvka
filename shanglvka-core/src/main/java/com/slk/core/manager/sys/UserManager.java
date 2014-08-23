package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.UserDao;
import com.slk.core.entity.sys.User;
import com.slk.core.query.sys.UserQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class UserManager {

	@Autowired
	private UserDao userDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUserDao(UserDao dao) {
		this.userDao = dao;
	}
	
	/** 
	 * 创建User
	 **/
	public User save(User user) {
	    Assert.notNull(user,"'user' must be not null");
	    this.userDao.save(user);
	    return user;
	}
	
	/** 
	 * 更新User
	 **/	
    public User update(User user) {
        Assert.notNull(user,"'user' must be not null");
        this.userDao.update(user);
        return user;
    }	
    
	/** 
	 * 删除User
	 **/
    public void deleteById(java.lang.Long id) {
        this.userDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到User
	 **/    
    public User getById(java.lang.Long id) {
        return this.userDao.getById(id);
    }
    
	/** 
	 * 统计总数User
	 **/ 
	public Long count(PageQuery query) {
		return userDao.count(query);
	}
	
	/** 
	 * list User
	 **/ 
	public List<User> list(PageQuery query) {
		return userDao.list(query);
	}
	
	/** 
	 * 分页查询: User
	 **/      
	@Transactional(readOnly=true)
	public PageList<User> findPage(UserQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<User>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
	@Transactional(readOnly=true)
	public User getByLoginName(java.lang.String v) {
		return userDao.getByLoginName(v);
	}	
    
}
