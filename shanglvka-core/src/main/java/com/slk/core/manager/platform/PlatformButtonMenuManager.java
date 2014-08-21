package com.slk.core.manager.platform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.platform.PlatformButtonMenuDao;
import com.slk.core.entity.platform.PlatformButtonMenu;
import com.slk.core.query.platform.PlatformButtonMenuQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class PlatformButtonMenuManager {

	@Autowired
	private PlatformButtonMenuDao platformButtonMenuDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setPlatformButtonMenuDao(PlatformButtonMenuDao dao) {
		this.platformButtonMenuDao = dao;
	}
	
	/** 
	 * 创建PlatformButtonMenu
	 **/
	public PlatformButtonMenu save(PlatformButtonMenu platformButtonMenu) {
	    Assert.notNull(platformButtonMenu,"'platformButtonMenu' must be not null");
	    this.platformButtonMenuDao.save(platformButtonMenu);
	    return platformButtonMenu;
	}
	
	/** 
	 * 更新PlatformButtonMenu
	 **/	
    public PlatformButtonMenu update(PlatformButtonMenu platformButtonMenu) {
        Assert.notNull(platformButtonMenu,"'platformButtonMenu' must be not null");
        this.platformButtonMenuDao.update(platformButtonMenu);
        return platformButtonMenu;
    }	
    
	/** 
	 * 删除PlatformButtonMenu
	 **/
    public void deleteById(java.lang.Long id) {
        this.platformButtonMenuDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到PlatformButtonMenu
	 **/    
    public PlatformButtonMenu getById(java.lang.Long id) {
        return this.platformButtonMenuDao.getById(id);
    }
    
	/** 
	 * 统计总数PlatformButtonMenu
	 **/ 
	public Long count(PageQuery query) {
		return platformButtonMenuDao.count(query);
	}
	
	/** 
	 * list PlatformButtonMenu
	 **/ 
	public List<PlatformButtonMenu> list(PageQuery query) {
		return platformButtonMenuDao.list(query);
	}
	
	/** 
	 * 分页查询: PlatformButtonMenu
	 **/      
	@Transactional(readOnly=true)
	public PageList<PlatformButtonMenu> findPage(PlatformButtonMenuQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<PlatformButtonMenu>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
