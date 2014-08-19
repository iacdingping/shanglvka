package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.OfficeDao;
import com.slk.core.entity.sys.Office;
import com.slk.core.query.sys.OfficeQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class OfficeManager {

	@Autowired
	private OfficeDao officeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setOfficeDao(OfficeDao dao) {
		this.officeDao = dao;
	}
	
	/** 
	 * 创建Office
	 **/
	public Office save(Office office) {
	    Assert.notNull(office,"'office' must be not null");
	    this.officeDao.save(office);
	    return office;
	}
	
	/** 
	 * 更新Office
	 **/	
    public Office update(Office office) {
        Assert.notNull(office,"'office' must be not null");
        this.officeDao.update(office);
        return office;
    }	
    
	/** 
	 * 删除Office
	 **/
    public void deleteById(java.lang.String id) {
        this.officeDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Office
	 **/    
    public Office getById(java.lang.String id) {
        return this.officeDao.getById(id);
    }
    
	/** 
	 * 统计总数Office
	 **/ 
	public Long count(PageQuery query) {
		return officeDao.count(query);
	}
	
	/** 
	 * list Office
	 **/ 
	public List<Office> list(PageQuery query) {
		return officeDao.list(query);
	}
	
	/** 
	 * 分页查询: Office
	 **/      
	@Transactional(readOnly=true)
	public PageList<Office> findPage(OfficeQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Office>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
