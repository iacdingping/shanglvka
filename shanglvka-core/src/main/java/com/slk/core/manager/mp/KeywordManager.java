package com.slk.core.manager.mp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.mp.KeywordDao;
import com.slk.core.entity.mp.Keyword;
import com.slk.core.query.mp.KeywordQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class KeywordManager {

	@Autowired
	private KeywordDao keywordDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setKeywordDao(KeywordDao dao) {
		this.keywordDao = dao;
	}
	
	/** 
	 * 创建Keyword
	 **/
	public Keyword save(Keyword keyword) {
	    Assert.notNull(keyword,"'keyword' must be not null");
	    this.keywordDao.save(keyword);
	    return keyword;
	}
	
	/** 
	 * 更新Keyword
	 **/	
    public Keyword update(Keyword keyword) {
        Assert.notNull(keyword,"'keyword' must be not null");
        this.keywordDao.update(keyword);
        return keyword;
    }	
    
	/** 
	 * 删除Keyword
	 **/
    public void deleteById(java.lang.Long id) {
        this.keywordDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到Keyword
	 **/    
    public Keyword getById(java.lang.Long id) {
        return this.keywordDao.getById(id);
    }
    
	/** 
	 * 统计总数Keyword
	 **/ 
	public Long count(PageQuery query) {
		return keywordDao.count(query);
	}
	
	/** 
	 * list Keyword
	 **/ 
	public List<Keyword> list(PageQuery query) {
		return keywordDao.list(query);
	}
	
	/** 
	 * 分页查询: Keyword
	 **/      
	@Transactional(readOnly=true)
	public PageList<Keyword> findPage(KeywordQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<Keyword>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}

	public Keyword findByKey(String content) {
		return keywordDao.findByKey(content);
	}
	
}
