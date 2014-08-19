package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.MenuDao;
import com.slk.core.entity.sys.Menu;
import com.slk.core.query.sys.MenuQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class MenuManager {

	@Autowired
	private MenuDao menuDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setMenuDao(MenuDao dao) {
		this.menuDao = dao;
	}
	
	/** 
	 * 创建Menu
	 **/
	public Menu save(Menu menu) {
	    Assert.notNull(menu,"'menu' must be not null");
	    this.menuDao.save(menu);
	    return menu;
	}
	
	/** 
	 * 更新Menu
	 **/	
    public Menu update(Menu menu) {
        Assert.notNull(menu,"'menu' must be not null");
        this.menuDao.update(menu);
        return menu;
    }	
    
	/** 
	 * 删除Menu
	 **/
    public void deleteById(java.lang.String id) {
        this.menuDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Menu
	 **/    
    public Menu getById(java.lang.String id) {
        return this.menuDao.getById(id);
    }
    
	/** 
	 * 统计总数Menu
	 **/ 
	public Long count(PageQuery query) {
		return menuDao.count(query);
	}
	
	/** 
	 * list Menu
	 **/ 
	public List<Menu> list(PageQuery query) {
		return menuDao.list(query);
	}
	
	/** 
	 * 分页查询: Menu
	 **/      
	@Transactional(readOnly=true)
	public PageList<Menu> findPage(MenuQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Menu>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
