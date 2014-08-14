package com.slk.core.manager.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.sys.CodeDao;
import com.slk.core.entity.sys.Code;
import com.slk.core.query.sys.CodeQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class CodeManager {

	@Autowired
	private CodeDao codeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCodeDao(CodeDao dao) {
		this.codeDao = dao;
	}
	
	/** 
	 * 创建Code
	 **/
	public Code save(Code code) {
	    Assert.notNull(code,"'code' must be not null");
	    this.codeDao.save(code);
	    return code;
	}
	
	/** 
	 * 更新Code
	 **/	
    public Code update(Code code) {
        Assert.notNull(code,"'code' must be not null");
        this.codeDao.update(code);
        return code;
    }	
    
	/** 
	 * 删除Code
	 **/
    public void deleteById(java.lang.Long id) {
        this.codeDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Code
	 **/    
    public Code getById(java.lang.Long id) {
        return this.codeDao.getById(id);
    }
    
	/** 
	 * 统计总数Code
	 **/ 
	public Long count(PageQuery query) {
		return codeDao.count(query);
	}
	
	/** 
	 * list Code
	 **/ 
	public List<Code> list(PageQuery query) {
		return codeDao.list(query);
	}
	
	/** 
	 * 分页查询: Code
	 **/      
	@Transactional(readOnly=true)
	public PageList<Code> findPage(CodeQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Code>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
    
}
