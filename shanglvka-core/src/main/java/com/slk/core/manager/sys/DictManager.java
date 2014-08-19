package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.DictDao;
import com.slk.core.entity.sys.Dict;
import com.slk.core.query.sys.DictQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class DictManager {

	@Autowired
	private DictDao dictDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setDictDao(DictDao dao) {
		this.dictDao = dao;
	}
	
	/** 
	 * 创建Dict
	 **/
	public Dict save(Dict dict) {
	    Assert.notNull(dict,"'dict' must be not null");
	    this.dictDao.save(dict);
	    return dict;
	}
	
	/** 
	 * 更新Dict
	 **/	
    public Dict update(Dict dict) {
        Assert.notNull(dict,"'dict' must be not null");
        this.dictDao.update(dict);
        return dict;
    }	
    
	/** 
	 * 删除Dict
	 **/
    public void deleteById(java.lang.String id) {
        this.dictDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Dict
	 **/    
    public Dict getById(java.lang.String id) {
        return this.dictDao.getById(id);
    }
    
	/** 
	 * 统计总数Dict
	 **/ 
	public Long count(PageQuery query) {
		return dictDao.count(query);
	}
	
	/** 
	 * list Dict
	 **/ 
	public List<Dict> list(PageQuery query) {
		return dictDao.list(query);
	}
	
	/** 
	 * 分页查询: Dict
	 **/      
	@Transactional(readOnly=true)
	public PageList<Dict> findPage(DictQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Dict>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
