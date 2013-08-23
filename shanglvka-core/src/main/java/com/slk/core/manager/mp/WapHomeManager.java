package com.slk.core.manager.mp;
import java.util.List;

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
	    initDefaultValuesForCreate(wapHome);
	    new WapHomeChecker().checkCreateWapHome(wapHome);
	    this.wapHomeDao.save(wapHome);
	    return wapHome;
	}
	
	/** 
	 * 更新WapHome
	 **/	
    public WapHome update(WapHome wapHome) {
        Assert.notNull(wapHome,"'wapHome' must be not null");
        new WapHomeChecker().checkUpdateWapHome(wapHome);
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
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(WapHome v) {
    }
    
    /**
     * WapHome的属性检查类,根据自己需要编写自定义检查
     **/
    public class WapHomeChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateWapHome(WapHome v) {
            checkWapHome(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateWapHome(WapHome v) {
            checkWapHome(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkWapHome(WapHome v) {
        	// Bean Validator检查,属性检查失败将抛异常
//            validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
