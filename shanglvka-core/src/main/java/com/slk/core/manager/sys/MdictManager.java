package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.MdictDao;
import com.slk.core.entity.sys.Mdict;
import com.slk.core.query.sys.MdictQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class MdictManager {

	@Autowired
	private MdictDao mdictDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setMdictDao(MdictDao dao) {
		this.mdictDao = dao;
	}
	
	/** 
	 * 创建Mdict
	 **/
	public Mdict save(Mdict mdict) {
	    Assert.notNull(mdict,"'mdict' must be not null");
	    this.mdictDao.save(mdict);
	    return mdict;
	}
	
	/** 
	 * 更新Mdict
	 **/	
    public Mdict update(Mdict mdict) {
        Assert.notNull(mdict,"'mdict' must be not null");
        this.mdictDao.update(mdict);
        return mdict;
    }	
    
	/** 
	 * 删除Mdict
	 **/
    public void deleteById(java.lang.String id) {
        this.mdictDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Mdict
	 **/    
    public Mdict getById(java.lang.String id) {
        return this.mdictDao.getById(id);
    }
    
	/** 
	 * 统计总数Mdict
	 **/ 
	public Long count(PageQuery query) {
		return mdictDao.count(query);
	}
	
	/** 
	 * list Mdict
	 **/ 
	public List<Mdict> list(PageQuery query) {
		return mdictDao.list(query);
	}
	
	/** 
	 * 分页查询: Mdict
	 **/      
	@Transactional(readOnly=true)
	public PageList<Mdict> findPage(MdictQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Mdict>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
}
