package com.slk.core.manager.mp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.mp.WapHomeDao;
import com.slk.core.entity.mp.WapHome;
import com.slk.core.query.mp.WapHomeQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class WapHomeManager {

	@Autowired
	private WapHomeDao wapHomeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setWapHomeDao(WapHomeDao dao) {
		this.wapHomeDao = dao;
	}
	
	/** 
	 * 创建WapHome
	 **/
	public WapHome save(WapHome wapHome) {
	    Assert.notNull(wapHome,"'wapHome' must be not null");
	    this.wapHomeDao.save(wapHome);
	    return wapHome;
	}
	
	/** 
	 * 保存WapHome
	 **/
	public WapHome saveOrUpdate(WapHome wapHome) {
	    Assert.notNull(wapHome,"'wapHome' must be not null");
	    if(wapHome.getId() == null) 
	    	this.wapHomeDao.save(wapHome);
	    else
	    	this.wapHomeDao.update(wapHome);
	    return wapHome;
	}
	
	/** 
	 * 更新WapHome
	 **/	
    public WapHome update(WapHome wapHome) {
        Assert.notNull(wapHome,"'wapHome' must be not null");
        this.wapHomeDao.update(wapHome);
        return wapHome;
    }	
    
	/** 
	 * 删除WapHome
	 **/
    public void deleteById(java.lang.Long id) {
        this.wapHomeDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到WapHome
	 **/    
    public WapHome getById(java.lang.Long id) {
        return this.wapHomeDao.getById(id);
    }
    
	/** 
	 * 统计总数WapHome
	 **/ 
	public Long count(PageQuery query) {
		return wapHomeDao.count(query);
	}
	
	/** 
	 * list WapHome
	 **/ 
	public List<WapHome> list(PageQuery query) {
		return wapHomeDao.list(query);
	}
	
	/** 
	 * 分页查询: WapHome
	 **/      
	@Transactional(readOnly=true)
	public PageList<WapHome> findPage(WapHomeQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return new PageList<WapHome>(list(query), 
				query.getPage(), query.getPageSize(), count(query));
	}
	
    
	public Map<Integer, List<WapHome>> listSortedIndexShow() {
		WapHomeQuery query = new WapHomeQuery();
		query.setSortColumns("`location`, `sort`");
		List<WapHome> list = list(query);
		Map<Integer, List<WapHome>> result = new HashMap<Integer, List<WapHome>>();
		for(WapHome wh : list) {
			List<WapHome> tmp = result.get(wh.getLocation());
			if(tmp == null) {
				tmp = new ArrayList<WapHome>();
			}
			tmp.add(wh);
		}
		return result;
	}
}
