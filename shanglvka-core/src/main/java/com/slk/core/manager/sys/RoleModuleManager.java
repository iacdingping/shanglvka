package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.RoleModuleDao;
import com.slk.core.entity.sys.RoleModule;
import com.slk.core.query.sys.RoleModuleQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class RoleModuleManager {

	@Autowired
	private RoleModuleDao roleModuleDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setRoleModuleDao(RoleModuleDao dao) {
		this.roleModuleDao = dao;
	}
	
	/** 
	 * 创建RoleModule
	 **/
	public RoleModule save(RoleModule roleModule) {
	    Assert.notNull(roleModule,"'roleModule' must be not null");
	    this.roleModuleDao.save(roleModule);
	    return roleModule;
	}
	
	/** 
	 * 更新RoleModule
	 **/	
    public RoleModule update(RoleModule roleModule) {
        Assert.notNull(roleModule,"'roleModule' must be not null");
        this.roleModuleDao.update(roleModule);
        return roleModule;
    }	
    
	/** 
	 * 删除RoleModule
	 **/
    public void deleteById(java.lang.Long id) {
        this.roleModuleDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到RoleModule
	 **/    
    public RoleModule getById(java.lang.Long id) {
        return this.roleModuleDao.getById(id);
    }
    
	/** 
	 * 统计总数RoleModule
	 **/ 
	public Long count(PageQuery query) {
		return roleModuleDao.count(query);
	}
	
	/** 
	 * list RoleModule
	 **/ 
	public List<RoleModule> list(PageQuery query) {
		return roleModuleDao.list(query);
	}
	
	/** 
	 * 分页查询: RoleModule
	 **/      
	@Transactional(readOnly=true)
	public PageList<RoleModule> findPage(RoleModuleQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<RoleModule>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}

	public List<RoleModule> listByRole(Long roleId) {
		RoleModuleQuery query = new RoleModuleQuery();
		query.setRole(roleId);
		return list(query);
	}
	
}
