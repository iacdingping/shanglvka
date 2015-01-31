package com.slk.core.manager.mp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.mp.UserBindCardDao;
import com.slk.core.entity.mp.UserBindCard;
import com.slk.core.query.mp.UserBindCardQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class UserBindCardManager {

	@Autowired
	private UserBindCardDao userBindCardDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUserBindCardDao(UserBindCardDao dao) {
		this.userBindCardDao = dao;
	}
	
	/** 
	 * 创建UserBindCard
	 **/
	public UserBindCard save(UserBindCard userBindCard) {
	    Assert.notNull(userBindCard,"'userBindCard' must be not null");
	    this.userBindCardDao.save(userBindCard);
	    return userBindCard;
	}
	
	/** 
	 * 更新UserBindCard
	 **/	
    public UserBindCard update(UserBindCard userBindCard) {
        Assert.notNull(userBindCard,"'userBindCard' must be not null");
        this.userBindCardDao.update(userBindCard);
        return userBindCard;
    }	
    
    public void saveOrUpdate(UserBindCard userBindCard) {
		if(userBindCard.getId() == null) {
			this.userBindCardDao.save(userBindCard);
		} else {
			this.userBindCardDao.update(userBindCard);
		}
	}
    
	/** 
	 * 删除UserBindCard
	 **/
    public void deleteById(java.lang.Long id) {
        this.userBindCardDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到UserBindCard
	 **/    
    public UserBindCard getById(java.lang.Long id) {
        return this.userBindCardDao.getById(id);
    }
    
	/** 
	 * 统计总数UserBindCard
	 **/ 
	public Long count(PageQuery query) {
		return userBindCardDao.count(query);
	}
	
	/** 
	 * list UserBindCard
	 **/ 
	public List<UserBindCard> list(PageQuery query) {
		return userBindCardDao.list(query);
	}
	
	/** 
	 * 分页查询: UserBindCard
	 **/      
	@Transactional(readOnly=true)
	public PageList<UserBindCard> findPage(UserBindCardQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<UserBindCard>(userBindCardDao.findPage(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
    
}
