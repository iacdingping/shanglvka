package com.slk.core.manager.platform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.platform.PlatformKeywordDao;
import com.slk.core.entity.platform.PlatformKeyword;
import com.slk.core.query.platform.PlatformKeywordQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class PlatformKeywordManager {

	@Autowired
	private PlatformKeywordDao platformKeywordDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setPlatformKeywordDao(PlatformKeywordDao dao) {
		this.platformKeywordDao = dao;
	}
	
	/** 
	 * 创建PlatformKeyword
	 **/
	public PlatformKeyword save(PlatformKeyword platformKeyword) {
	    Assert.notNull(platformKeyword,"'platformKeyword' must be not null");
	    this.platformKeywordDao.save(platformKeyword);
	    return platformKeyword;
	}
	
	/** 
	 * 更新PlatformKeyword
	 **/	
    public PlatformKeyword update(PlatformKeyword platformKeyword) {
        Assert.notNull(platformKeyword,"'platformKeyword' must be not null");
        this.platformKeywordDao.update(platformKeyword);
        return platformKeyword;
    }	
    
	/** 
	 * 删除PlatformKeyword
	 **/
    public void deleteById(java.lang.Long id) {
        this.platformKeywordDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到PlatformKeyword
	 **/    
    public PlatformKeyword getById(java.lang.Long id) {
        return this.platformKeywordDao.getById(id);
    }
    
	/** 
	 * 统计总数PlatformKeyword
	 **/ 
	public Long count(PageQuery query) {
		return platformKeywordDao.count(query);
	}
	
	/** 
	 * list PlatformKeyword
	 **/ 
	public List<PlatformKeyword> list(PageQuery query) {
		return platformKeywordDao.list(query);
	}
	
	/** 
	 * 分页查询: PlatformKeyword
	 **/      
	@Transactional(readOnly=true)
	public PageList<PlatformKeyword> findPage(PlatformKeywordQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<PlatformKeyword>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}

	public PlatformKeyword findByKey(String content) {
		return platformKeywordDao.findByKey(content);
	}
}
