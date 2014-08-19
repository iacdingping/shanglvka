package com.slk.core.platform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.platform.PlatformKeywordDao;
import com.slk.core.entity.platform.PlatformKeyword;
import com.slk.core.query.platform.PlatformKeywordQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class PlatformKeywordDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private PlatformKeywordDao platformKeywordDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void platformKeywordCurl() throws Exception {
		PlatformKeywordQuery query = new PlatformKeywordQuery();
		long startRows = platformKeywordDao.count(query);
		List<PlatformKeyword> lists = platformKeywordDao.list(query);
		assertEquals(lists.size(), startRows);
		
		PlatformKeyword platformKeyword = new PlatformKeyword();
		/** id */
		/** 关键字 */
		platformKeyword.setKey("1");
		/** 回复类型 */
		platformKeyword.setResponseType("1");
		/** 内容 */
		platformKeyword.setContent("1");
		/** 标题 */
		platformKeyword.setTitle("1");
		/** 图片地址 */
		platformKeyword.setPicture("1");
		/** 链接 */
		platformKeyword.setUrl("1");
		/** 匹配优先级 越大优先级越高 */
		platformKeyword.setPriority(1);
		/** 是否需要绑定 */
		platformKeyword.setNeedBind(true);
		/** 未绑定内容 */
		platformKeyword.setUnbindContent("1");
		/** createDate */
		platformKeyword.setCreateDate(new java.util.Date());
		/** updateDate */
		platformKeyword.setUpdateDate(new java.util.Date());
		/** delFlag */
		platformKeyword.setDelFlag(1);
		
		platformKeywordDao.save(platformKeyword);
		long saveRows = platformKeywordDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		PlatformKeyword platformKeywordQueried = platformKeywordDao.getById(platformKeyword.getId());
		assertNotNull("查询错误", platformKeywordQueried);
			assertEquals(platformKeywordQueried.getId(), platformKeyword.getId());
			assertEquals(platformKeywordQueried.getKey(), platformKeyword.getKey());
			assertEquals(platformKeywordQueried.getResponseType(), platformKeyword.getResponseType());
			assertEquals(platformKeywordQueried.getContent(), platformKeyword.getContent());
			assertEquals(platformKeywordQueried.getTitle(), platformKeyword.getTitle());
			assertEquals(platformKeywordQueried.getPicture(), platformKeyword.getPicture());
			assertEquals(platformKeywordQueried.getUrl(), platformKeyword.getUrl());
			assertEquals(platformKeywordQueried.getPriority(), platformKeyword.getPriority());
			assertEquals(platformKeywordQueried.getNeedBind(), platformKeyword.getNeedBind());
			assertEquals(platformKeywordQueried.getUnbindContent(), platformKeyword.getUnbindContent());
			assertEquals(platformKeywordQueried.getDelFlag(), platformKeyword.getDelFlag());
		
		/** 关键字 */
		platformKeyword.setKey("2");
		/** 回复类型 */
		platformKeyword.setResponseType("2");
		/** 内容 */
		platformKeyword.setContent("2");
		/** 标题 */
		platformKeyword.setTitle("2");
		/** 图片地址 */
		platformKeyword.setPicture("2");
		/** 链接 */
		platformKeyword.setUrl("2");
		/** 匹配优先级 越大优先级越高 */
		platformKeyword.setPriority(2);
		/** 是否需要绑定 */
		platformKeyword.setNeedBind(false);
		/** 未绑定内容 */
		platformKeyword.setUnbindContent("2");
		/** createDate */
		platformKeyword.setCreateDate(new java.util.Date());
		/** updateDate */
		platformKeyword.setUpdateDate(new java.util.Date());
		/** delFlag */
		platformKeyword.setDelFlag(2);
		
		platformKeywordDao.update(platformKeyword);
		PlatformKeyword platformKeywordUpdated = platformKeywordDao.getById(platformKeyword.getId());
		assertEquals(platformKeywordUpdated.getKey(), platformKeyword.getKey());
		assertEquals(platformKeywordUpdated.getResponseType(), platformKeyword.getResponseType());
		assertEquals(platformKeywordUpdated.getContent(), platformKeyword.getContent());
		assertEquals(platformKeywordUpdated.getTitle(), platformKeyword.getTitle());
		assertEquals(platformKeywordUpdated.getPicture(), platformKeyword.getPicture());
		assertEquals(platformKeywordUpdated.getUrl(), platformKeyword.getUrl());
		assertEquals(platformKeywordUpdated.getPriority(), platformKeyword.getPriority());
		assertEquals(platformKeywordUpdated.getNeedBind(), platformKeyword.getNeedBind());
		assertEquals(platformKeywordUpdated.getUnbindContent(), platformKeyword.getUnbindContent());
		assertEquals(platformKeywordUpdated.getDelFlag(), platformKeyword.getDelFlag());
		
		//delete
		platformKeywordDao.deleteById(platformKeyword.getId());
		long deleteRows = platformKeywordDao.count(query);
		assertEquals(startRows, deleteRows);
	}
	
	@Test
	public void findByKeyTest() {
		String containStr = "abctestdef";
		String containedStr = "es";
		String outContain = "abc123";
		PlatformKeyword platformKeyword = new PlatformKeyword();
		platformKeyword.setKey("test");
		platformKeywordDao.save(platformKeyword);
		PlatformKeyword platformKeyword2 = platformKeywordDao.findByKey(containStr);
		assertEquals(platformKeyword.getId(), platformKeyword2.getId());
		
		PlatformKeyword platformKeyword3 = platformKeywordDao.findByKey(containedStr);
		assertEquals(platformKeyword.getId(), platformKeyword3.getId());
		PlatformKeyword platformKeyword4 = platformKeywordDao.findByKey(outContain);
		assertEquals(platformKeyword4, null);
	}
}
