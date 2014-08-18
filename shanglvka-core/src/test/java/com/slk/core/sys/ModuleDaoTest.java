package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.sys.ModuleDao;
import com.slk.core.entity.sys.Module;
import com.slk.core.query.sys.ModuleQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class ModuleDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private ModuleDao moduleDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void moduleCurl() throws Exception {
		ModuleQuery query = new ModuleQuery();
		long startRows = moduleDao.count(query);
		List<Module> lists = moduleDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Module module = new Module();
		/** id */
		/** 父模块 */
		module.setParent("1");
		/** 名称 */
		module.setName("1");
		/** 图标 */
		module.setIcon("1");
		/** 是否展开 */
		module.setExpanded("1");
		/** 类型 1菜单 2功能 */
		module.setType(1);
		/** 权限query edit delete */
		module.setPermission("1");
		/** 排序 */
		module.setOrder(1);
		/** created */
		module.setCreated(new java.util.Date());
		/** deleted */
		module.setDeleted(1);
		/** lastOperateTime */
		module.setLastOperateTime(new java.util.Date());
		
		moduleDao.save(module);
		long saveRows = moduleDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Module moduleQueried = moduleDao.getById(module.getId());
		assertNotNull("查询错误", moduleQueried);
			assertEquals(moduleQueried.getId(), module.getId());
			assertEquals(moduleQueried.getParent(), module.getParent());
			assertEquals(moduleQueried.getName(), module.getName());
			assertEquals(moduleQueried.getIcon(), module.getIcon());
			assertEquals(moduleQueried.getExpanded(), module.getExpanded());
			assertEquals(moduleQueried.getType(), module.getType());
			assertEquals(moduleQueried.getPermission(), module.getPermission());
			assertEquals(moduleQueried.getOrder(), module.getOrder());
			assertEquals(moduleQueried.getDeleted(), module.getDeleted());
		
		/** 父模块 */
		module.setParent("2");
		/** 名称 */
		module.setName("2");
		/** 图标 */
		module.setIcon("2");
		/** 是否展开 */
		module.setExpanded("2");
		/** 类型 1菜单 2功能 */
		module.setType(2);
		/** 权限query edit delete */
		module.setPermission("2");
		/** 排序 */
		module.setOrder(2);
		/** created */
		module.setCreated(new java.util.Date());
		/** deleted */
		module.setDeleted(2);
		/** lastOperateTime */
		module.setLastOperateTime(new java.util.Date());
		
		moduleDao.update(module);
		Module moduleUpdated = moduleDao.getById(module.getId());
		assertEquals(moduleUpdated.getParent(), module.getParent());
		assertEquals(moduleUpdated.getName(), module.getName());
		assertEquals(moduleUpdated.getIcon(), module.getIcon());
		assertEquals(moduleUpdated.getExpanded(), module.getExpanded());
		assertEquals(moduleUpdated.getType(), module.getType());
		assertEquals(moduleUpdated.getPermission(), module.getPermission());
		assertEquals(moduleUpdated.getOrder(), module.getOrder());
		assertEquals(moduleUpdated.getDeleted(), module.getDeleted());
		
		//delete
		moduleDao.deleteById(module.getId());
		long deleteRows = moduleDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
