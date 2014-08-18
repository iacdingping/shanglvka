package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.slk.core.SpringTransactionalTestCase;
import com.slk.core.dao.sys.RoleDao;
import com.slk.core.entity.sys.Role;
import com.slk.core.query.sys.RoleQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class RoleDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private RoleDao roleDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void roleCurl() throws Exception {
		RoleQuery query = new RoleQuery();
		long startRows = roleDao.count(query);
		List<Role> lists = roleDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Role role = new Role();
		/** id */
		/** 父角色 */
		role.setParent("1");
		/** 名称 */
		role.setName("1");
		/** 图标 */
		role.setIcon("1");
		/** created */
		role.setCreated(new java.util.Date());
		/** deleted */
		role.setDeleted(1);
		/** lastOperateTime */
		role.setLastOperateTime(new java.util.Date());
		
		roleDao.save(role);
		long saveRows = roleDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Role roleQueried = roleDao.getById(role.getId());
		assertNotNull("查询错误", roleQueried);
			assertEquals(roleQueried.getId(), role.getId());
			assertEquals(roleQueried.getParent(), role.getParent());
			assertEquals(roleQueried.getName(), role.getName());
			assertEquals(roleQueried.getIcon(), role.getIcon());
//			assertEquals(DateUtil.format(roleQueried.getCreated(), "yyyy-mm-dd HH:MM"), 
//				DateUtil.format(role.getCreated(), "yyyy-mm-dd HH:MM"));
			assertEquals(roleQueried.getDeleted(), role.getDeleted());
//			assertEquals(DateUtil.format(roleQueried.getLastOperateTime(), "yyyy-mm-dd HH:MM"), 
//				DateUtil.format(role.getLastOperateTime(), "yyyy-mm-dd HH:MM"));
		
		/** 父角色 */
		role.setParent("2");
		/** 名称 */
		role.setName("2");
		/** 图标 */
		role.setIcon("2");
		/** created */
		role.setCreated(new java.util.Date());
		/** deleted */
		role.setDeleted(2);
		/** lastOperateTime */
		role.setLastOperateTime(new java.util.Date());
		
		roleDao.update(role);
		Role roleUpdated = roleDao.getById(role.getId());
		assertEquals(roleUpdated.getParent(), role.getParent());
		assertEquals(roleUpdated.getName(), role.getName());
		assertEquals(roleUpdated.getIcon(), role.getIcon());
//		assertEquals(DateUtil.format(roleUpdated.getCreated(), "yyyy-mm-dd HH:MM"), 
//			DateUtil.format(roleUpdated.getCreated(), "yyyy-mm-dd HH:MM"));
		assertEquals(roleUpdated.getDeleted(), role.getDeleted());
//		assertEquals(DateUtil.format(roleUpdated.getLastOperateTime(), "yyyy-mm-dd HH:MM"), 
//			DateUtil.format(roleUpdated.getLastOperateTime(), "yyyy-mm-dd HH:MM"));
		
		//delete
		roleDao.deleteById(role.getId());
		long deleteRows = roleDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
