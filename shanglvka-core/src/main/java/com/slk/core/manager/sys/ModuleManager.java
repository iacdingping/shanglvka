package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.ModuleDao;
import com.slk.core.entity.sys.Module;
import com.slk.core.query.sys.ModuleQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class ModuleManager {

	@Autowired
	private ModuleDao moduleDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setModuleDao(ModuleDao dao) {
		this.moduleDao = dao;
	}
	
	/** 
	 * 创建Module
	 **/
	public Module save(Module module) {
	    Assert.notNull(module,"'module' must be not null");
	    this.moduleDao.save(module);
	    return module;
	}
	
	/** 
	 * 更新Module
	 **/	
    public Module update(Module module) {
        Assert.notNull(module,"'module' must be not null");
        this.moduleDao.update(module);
        return module;
    }	
    
	/** 
	 * 删除Module
	 **/
    public void deleteById(java.lang.Long id) {
        this.moduleDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Module
	 **/    
    public Module getById(java.lang.Long id) {
        return this.moduleDao.getById(id);
    }
    
	/** 
	 * 统计总数Module
	 **/ 
	public Long count(PageQuery query) {
		return moduleDao.count(query);
	}
	
	/** 
	 * list Module
	 **/ 
	public List<Module> list(PageQuery query) {
		return moduleDao.list(query);
	}
	
	/** 
	 * list Module
	 **/ 
	public List<Module> listAll() {
		PageQuery query = new PageQuery();
		return list(query);
	}
	
	/** 
	 * 分页查询: Module
	 **/      
	@Transactional(readOnly=true)
	public PageList<Module> findPage(ModuleQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Module>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
