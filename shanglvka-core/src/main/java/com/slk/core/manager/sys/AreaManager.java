package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.AreaDao;
import com.slk.core.entity.sys.Area;
import com.slk.core.query.sys.AreaQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class AreaManager {

	@Autowired
	private AreaDao areaDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setAreaDao(AreaDao dao) {
		this.areaDao = dao;
	}
	
	/** 
	 * 创建Area
	 **/
	public Area save(Area area) {
	    Assert.notNull(area,"'area' must be not null");
	    this.areaDao.save(area);
	    return area;
	}
	
	/** 
	 * 更新Area
	 **/	
    public Area update(Area area) {
        Assert.notNull(area,"'area' must be not null");
        this.areaDao.update(area);
        return area;
    }	
    
	/** 
	 * 删除Area
	 **/
    public void deleteById(java.lang.String id) {
        this.areaDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Area
	 **/    
    public Area getById(java.lang.String id) {
        return this.areaDao.getById(id);
    }
    
	/** 
	 * 统计总数Area
	 **/ 
	public Long count(PageQuery query) {
		return areaDao.count(query);
	}
	
	/** 
	 * list Area
	 **/ 
	public List<Area> list(PageQuery query) {
		return areaDao.list(query);
	}
	
	/** 
	 * 分页查询: Area
	 **/      
	@Transactional(readOnly=true)
	public PageList<Area> findPage(AreaQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Area>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
