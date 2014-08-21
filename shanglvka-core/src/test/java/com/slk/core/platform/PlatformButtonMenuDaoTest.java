package com.slk.core.platform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.platform.PlatformButtonMenuDao;
import com.slk.core.entity.platform.PlatformButtonMenu;
import com.slk.core.query.platform.PlatformButtonMenuQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class PlatformButtonMenuDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private PlatformButtonMenuDao platformButtonMenuDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void platformButtonMenuCurl() throws Exception {
		PlatformButtonMenuQuery query = new PlatformButtonMenuQuery();
		long startRows = platformButtonMenuDao.count(query);
		List<PlatformButtonMenu> lists = platformButtonMenuDao.list(query);
		assertEquals(lists.size(), startRows);
		
		PlatformButtonMenu platformButtonMenu = new PlatformButtonMenu();
		/** id */
		/** 菜单名称 */
		platformButtonMenu.setName("1");
		/** 响应键标识(mp_platform_keyword关键字对应) */
		platformButtonMenu.setKey("1");
		/** 父ID */
		platformButtonMenu.setParent(1L);
		/** 类型 BUTTON,LINK */
		platformButtonMenu.setType("1");
		/** createDate */
		platformButtonMenu.setCreateDate(new java.util.Date());
		/** updateDate */
		platformButtonMenu.setUpdateDate(new java.util.Date());
		/** delFlag */
		
		platformButtonMenuDao.save(platformButtonMenu);
		long saveRows = platformButtonMenuDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		PlatformButtonMenu platformButtonMenuQueried = platformButtonMenuDao.getById(platformButtonMenu.getId());
		assertNotNull("查询错误", platformButtonMenuQueried);
			assertEquals(platformButtonMenuQueried.getId(), platformButtonMenu.getId());
			assertEquals(platformButtonMenuQueried.getName(), platformButtonMenu.getName());
			assertEquals(platformButtonMenuQueried.getKey(), platformButtonMenu.getKey());
			assertEquals(platformButtonMenuQueried.getParent(), platformButtonMenu.getParent());
			assertEquals(platformButtonMenuQueried.getType(), platformButtonMenu.getType());
			assertEquals(platformButtonMenuQueried.getDelFlag(), platformButtonMenu.getDelFlag());
		
		/** 菜单名称 */
		platformButtonMenu.setName("2");
		/** 响应键标识(mp_platform_keyword关键字对应) */
		platformButtonMenu.setKey("2");
		/** 父ID */
		platformButtonMenu.setParent(2L);
		/** 类型 BUTTON,LINK */
		platformButtonMenu.setType("2");
		/** createDate */
		platformButtonMenu.setCreateDate(new java.util.Date());
		/** updateDate */
		platformButtonMenu.setUpdateDate(new java.util.Date());
		/** delFlag */
		
		platformButtonMenuDao.update(platformButtonMenu);
		PlatformButtonMenu platformButtonMenuUpdated = platformButtonMenuDao.getById(platformButtonMenu.getId());
		assertEquals(platformButtonMenuUpdated.getName(), platformButtonMenu.getName());
		assertEquals(platformButtonMenuUpdated.getKey(), platformButtonMenu.getKey());
		assertEquals(platformButtonMenuUpdated.getParent(), platformButtonMenu.getParent());
		assertEquals(platformButtonMenuUpdated.getType(), platformButtonMenu.getType());
		assertEquals(platformButtonMenuUpdated.getDelFlag(), platformButtonMenu.getDelFlag());
		
		//delete
		platformButtonMenuDao.deleteById(platformButtonMenu.getId());
		long deleteRows = platformButtonMenuDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
