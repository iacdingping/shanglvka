package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.sys.RoleModuleDao;
import com.slk.core.entity.sys.RoleModule;
import com.slk.core.query.sys.RoleModuleQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class RoleModuleDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private RoleModuleDao roleModuleDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void roleModuleCurl() throws Exception {
		RoleModuleQuery query = new RoleModuleQuery();
		long startRows = roleModuleDao.count(query);
		List<RoleModule> lists = roleModuleDao.list(query);
		assertEquals(lists.size(), startRows);
		
		RoleModule roleModule = new RoleModule();
		/** id */
		/** 名称 */
		roleModule.setName("1");
		/** 图标 */
		roleModule.setIcon("1");
		/** 模块 */
		roleModule.setModule(1L);
		/** 角色 */
		roleModule.setRole(1L);
		/** 权限 */
		roleModule.setPermission("1");
		/** created */
		roleModule.setCreated(new java.util.Date());
		/** deleted */
		roleModule.setDeleted(1);
		/** lastOperateTime */
		roleModule.setLastOperateTime(new java.util.Date());
		
		roleModuleDao.save(roleModule);
		long saveRows = roleModuleDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		RoleModule roleModuleQueried = roleModuleDao.getById(roleModule.getId());
		assertNotNull("查询错误", roleModuleQueried);
			assertEquals(roleModuleQueried.getId(), roleModule.getId());
			assertEquals(roleModuleQueried.getName(), roleModule.getName());
			assertEquals(roleModuleQueried.getIcon(), roleModule.getIcon());
			assertEquals(roleModuleQueried.getModule(), roleModule.getModule());
			assertEquals(roleModuleQueried.getRole(), roleModule.getRole());
			assertEquals(roleModuleQueried.getPermission(), roleModule.getPermission());
			assertEquals(roleModuleQueried.getDeleted(), roleModule.getDeleted());
		
		/** 名称 */
		roleModule.setName("2");
		/** 图标 */
		roleModule.setIcon("2");
		/** 模块 */
		roleModule.setModule(2L);
		/** 角色 */
		roleModule.setRole(2L);
		/** 权限 */
		roleModule.setPermission("2");
		/** created */
		roleModule.setCreated(new java.util.Date());
		/** deleted */
		roleModule.setDeleted(2);
		/** lastOperateTime */
		roleModule.setLastOperateTime(new java.util.Date());
		
		roleModuleDao.update(roleModule);
		RoleModule roleModuleUpdated = roleModuleDao.getById(roleModule.getId());
		assertEquals(roleModuleUpdated.getName(), roleModule.getName());
		assertEquals(roleModuleUpdated.getIcon(), roleModule.getIcon());
		assertEquals(roleModuleUpdated.getModule(), roleModule.getModule());
		assertEquals(roleModuleUpdated.getRole(), roleModule.getRole());
		assertEquals(roleModuleUpdated.getPermission(), roleModule.getPermission());
		assertEquals(roleModuleUpdated.getDeleted(), roleModule.getDeleted());

		//delete
		roleModuleDao.deleteById(roleModule.getId());
		long deleteRows = roleModuleDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
