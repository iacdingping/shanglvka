package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.slk.core.SpringTransactionalTestCase;
import com.slk.core.dao.sys.UserRoleDao;
import com.slk.core.entity.sys.UserRole;
import com.slk.core.query.sys.UserRoleQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class UserRoleDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private UserRoleDao userRoleDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void userRoleCurl() throws Exception {
		UserRoleQuery query = new UserRoleQuery();
		long startRows = userRoleDao.count(query);
		List<UserRole> lists = userRoleDao.list(query);
		assertEquals(lists.size(), startRows);
		
		UserRole userRole = new UserRole();
		/** id */
		/** 用户 */
		userRole.setUser(1L);
		/** 角色 */
		userRole.setRole(1L);
		/** created */
		userRole.setCreated(new java.util.Date());
		/** deleted */
		userRole.setDeleted(1);
		/** lastOperateTime */
		userRole.setLastOperateTime(new java.util.Date());
		
		userRoleDao.save(userRole);
		long saveRows = userRoleDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		UserRole userRoleQueried = userRoleDao.getById(userRole.getId());
		assertNotNull("查询错误", userRoleQueried);
			assertEquals(userRoleQueried.getId(), userRole.getId());
			assertEquals(userRoleQueried.getUser(), userRole.getUser());
			assertEquals(userRoleQueried.getRole(), userRole.getRole());
//			assertEquals(DateUtil.format(userRoleQueried.getCreated(), "yyyy-mm-dd HH:MM"), 
//				DateUtil.format(userRole.getCreated(), "yyyy-mm-dd HH:MM"));
			assertEquals(userRoleQueried.getDeleted(), userRole.getDeleted());
//			assertEquals(DateUtil.format(userRoleQueried.getLastOperateTime(), "yyyy-mm-dd HH:MM"), 
//				DateUtil.format(userRole.getLastOperateTime(), "yyyy-mm-dd HH:MM"));
		
		/** 用户 */
		userRole.setUser(2L);
		/** 角色 */
		userRole.setRole(2L);
		/** created */
		userRole.setCreated(new java.util.Date());
		/** deleted */
		userRole.setDeleted(2);
		/** lastOperateTime */
		userRole.setLastOperateTime(new java.util.Date());
		
		userRoleDao.update(userRole);
		UserRole userRoleUpdated = userRoleDao.getById(userRole.getId());
		assertEquals(userRoleUpdated.getUser(), userRole.getUser());
		assertEquals(userRoleUpdated.getRole(), userRole.getRole());
//		assertEquals(DateUtil.format(userRoleUpdated.getCreated(), "yyyy-mm-dd HH:MM"), 
//			DateUtil.format(userRoleUpdated.getCreated(), "yyyy-mm-dd HH:MM"));
		assertEquals(userRoleUpdated.getDeleted(), userRole.getDeleted());
//		assertEquals(DateUtil.format(userRoleUpdated.getLastOperateTime(), "yyyy-mm-dd HH:MM"), 
//			DateUtil.format(userRoleUpdated.getLastOperateTime(), "yyyy-mm-dd HH:MM"));
		
		//delete
		userRoleDao.deleteById(userRole.getId());
		long deleteRows = userRoleDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
