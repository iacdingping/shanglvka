package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.sys.LogDao;
import com.slk.core.entity.sys.Log;
import com.slk.core.query.sys.LogQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class LogDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private LogDao logDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void logCurl() throws Exception {
		LogQuery query = new LogQuery();
		long startRows = logDao.count(query);
		List<Log> lists = logDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Log log = new Log();
		/** 编号 */
		/** 日志类型 */
		log.setType("1");
		/** 创建者 */
		log.setCreateBy("1");
		/** 创建时间 */
		log.setCreateDate(new java.util.Date());
		/** 操作IP地址 */
		log.setRemoteAddr("1");
		/** 用户代理 */
		log.setUserAgent("1");
		/** 请求URI */
		log.setRequestUri("1");
		/** 操作方式 */
		log.setMethod("1");
		/** 操作提交的数据 */
		log.setParams("1");
		/** 异常信息 */
		log.setException("1");
		
		logDao.save(log);
		long saveRows = logDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Log logQueried = logDao.getById(log.getId());
		assertNotNull("查询错误", logQueried);
			assertEquals(logQueried.getId(), log.getId());
			assertEquals(logQueried.getType(), log.getType());
			assertEquals(logQueried.getCreateBy(), log.getCreateBy());
			assertEquals(logQueried.getRemoteAddr(), log.getRemoteAddr());
			assertEquals(logQueried.getUserAgent(), log.getUserAgent());
			assertEquals(logQueried.getRequestUri(), log.getRequestUri());
			assertEquals(logQueried.getMethod(), log.getMethod());
			assertEquals(logQueried.getParams(), log.getParams());
			assertEquals(logQueried.getException(), log.getException());
		
		/** 日志类型 */
		log.setType("2");
		/** 创建者 */
		log.setCreateBy("2");
		/** 创建时间 */
		log.setCreateDate(new java.util.Date());
		/** 操作IP地址 */
		log.setRemoteAddr("2");
		/** 用户代理 */
		log.setUserAgent("2");
		/** 请求URI */
		log.setRequestUri("2");
		/** 操作方式 */
		log.setMethod("2");
		/** 操作提交的数据 */
		log.setParams("2");
		/** 异常信息 */
		log.setException("2");
		
		logDao.update(log);
		Log logUpdated = logDao.getById(log.getId());
		assertEquals(logUpdated.getType(), log.getType());
		assertEquals(logUpdated.getCreateBy(), log.getCreateBy());
		assertEquals(logUpdated.getRemoteAddr(), log.getRemoteAddr());
		assertEquals(logUpdated.getUserAgent(), log.getUserAgent());
		assertEquals(logUpdated.getRequestUri(), log.getRequestUri());
		assertEquals(logUpdated.getMethod(), log.getMethod());
		assertEquals(logUpdated.getParams(), log.getParams());
		assertEquals(logUpdated.getException(), log.getException());
		
		//delete
		logDao.deleteById(log.getId());
		long deleteRows = logDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
