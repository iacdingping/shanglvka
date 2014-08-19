package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.RoleMenuDao;
import com.slk.core.entity.sys.RoleMenu;
import com.slk.core.query.sys.RoleMenuQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class RoleMenuManager {

	@Autowired
	private RoleMenuDao roleMenuDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setRoleMenuDao(RoleMenuDao dao) {
		this.roleMenuDao = dao;
	}
	
	/** 
	 * 创建RoleMenu
	 **/
	public RoleMenu save(RoleMenu roleMenu) {
	    Assert.notNull(roleMenu,"'roleMenu' must be not null");
	    this.roleMenuDao.save(roleMenu);
	    return roleMenu;
	}
	
	/** 
	 * 更新RoleMenu
	 **/	
    public RoleMenu update(RoleMenu roleMenu) {
        Assert.notNull(roleMenu,"'roleMenu' must be not null");
        this.roleMenuDao.update(roleMenu);
        return roleMenu;
    }	
    
	/** 
	 * 删除RoleMenu
	 **/
    public void deleteById(java.lang.String id) {
        this.roleMenuDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到RoleMenu
	 **/    
    public RoleMenu getById(java.lang.String id) {
        return this.roleMenuDao.getById(id);
    }
    
	/** 
	 * 统计总数RoleMenu
	 **/ 
	public Long count(PageQuery query) {
		return roleMenuDao.count(query);
	}
	
	/** 
	 * list RoleMenu
	 **/ 
	public List<RoleMenu> list(PageQuery query) {
		return roleMenuDao.list(query);
	}
	
	/** 
	 * 分页查询: RoleMenu
	 **/      
	@Transactional(readOnly=true)
	public PageList<RoleMenu> findPage(RoleMenuQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<RoleMenu>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
    
}
