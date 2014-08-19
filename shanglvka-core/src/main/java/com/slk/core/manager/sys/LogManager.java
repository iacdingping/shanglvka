package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.LogDao;
import com.slk.core.entity.sys.Log;
import com.slk.core.query.sys.LogQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class LogManager {

	@Autowired
	private LogDao logDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setLogDao(LogDao dao) {
		this.logDao = dao;
	}
	
	/** 
	 * 创建Log
	 **/
	public Log save(Log log) {
	    Assert.notNull(log,"'log' must be not null");
	    this.logDao.save(log);
	    return log;
	}
	
	/** 
	 * 更新Log
	 **/	
    public Log update(Log log) {
        Assert.notNull(log,"'log' must be not null");
        this.logDao.update(log);
        return log;
    }	
    
	/** 
	 * 删除Log
	 **/
    public void deleteById(java.lang.String id) {
        this.logDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Log
	 **/    
    public Log getById(java.lang.String id) {
        return this.logDao.getById(id);
    }
    
	/** 
	 * 统计总数Log
	 **/ 
	public Long count(PageQuery query) {
		return logDao.count(query);
	}
	
	/** 
	 * list Log
	 **/ 
	public List<Log> list(PageQuery query) {
		return logDao.list(query);
	}
	
	/** 
	 * 分页查询: Log
	 **/      
	@Transactional(readOnly=true)
	public PageList<Log> findPage(LogQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Log>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
}
