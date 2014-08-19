package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.RoleOfficeDao;
import com.slk.core.entity.sys.RoleOffice;
import com.slk.core.query.sys.RoleOfficeQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class RoleOfficeManager {

	@Autowired
	private RoleOfficeDao roleOfficeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setRoleOfficeDao(RoleOfficeDao dao) {
		this.roleOfficeDao = dao;
	}
	
	/** 
	 * 创建RoleOffice
	 **/
	public RoleOffice save(RoleOffice roleOffice) {
	    Assert.notNull(roleOffice,"'roleOffice' must be not null");
	    this.roleOfficeDao.save(roleOffice);
	    return roleOffice;
	}
	
	/** 
	 * 更新RoleOffice
	 **/	
    public RoleOffice update(RoleOffice roleOffice) {
        Assert.notNull(roleOffice,"'roleOffice' must be not null");
        this.roleOfficeDao.update(roleOffice);
        return roleOffice;
    }	
    
	/** 
	 * 删除RoleOffice
	 **/
    public void deleteById(java.lang.String id) {
        this.roleOfficeDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到RoleOffice
	 **/    
    public RoleOffice getById(java.lang.String id) {
        return this.roleOfficeDao.getById(id);
    }
    
	/** 
	 * 统计总数RoleOffice
	 **/ 
	public Long count(PageQuery query) {
		return roleOfficeDao.count(query);
	}
	
	/** 
	 * list RoleOffice
	 **/ 
	public List<RoleOffice> list(PageQuery query) {
		return roleOfficeDao.list(query);
	}
	
	/** 
	 * 分页查询: RoleOffice
	 **/      
	@Transactional(readOnly=true)
	public PageList<RoleOffice> findPage(RoleOfficeQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<RoleOffice>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
