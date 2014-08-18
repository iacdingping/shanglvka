package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.RoleDao;
import com.slk.core.entity.sys.Role;
import com.slk.core.query.sys.RoleQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class RoleManager {

	@Autowired
	private RoleDao roleDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setRoleDao(RoleDao dao) {
		this.roleDao = dao;
	}
	
	/** 
	 * 创建Role
	 **/
	public Role save(Role role) {
	    Assert.notNull(role,"'role' must be not null");
	    this.roleDao.save(role);
	    return role;
	}
	
	/** 
	 * 更新Role
	 **/	
    public Role update(Role role) {
        Assert.notNull(role,"'role' must be not null");
        this.roleDao.update(role);
        return role;
    }	
    
	/** 
	 * 删除Role
	 **/
    public void deleteById(java.lang.Long id) {
        this.roleDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Role
	 **/    
    public Role getById(java.lang.Long id) {
        return this.roleDao.getById(id);
    }
    
	/** 
	 * 统计总数Role
	 **/ 
	public Long count(PageQuery query) {
		return roleDao.count(query);
	}
	
	/** 
	 * list Role
	 **/ 
	public List<Role> list(PageQuery query) {
		return roleDao.list(query);
	}
	
	/** 
	 * 分页查询: Role
	 **/      
	@Transactional(readOnly=true)
	public PageList<Role> findPage(RoleQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Role>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
