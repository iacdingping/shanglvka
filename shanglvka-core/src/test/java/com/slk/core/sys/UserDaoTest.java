package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.slk.core.SpringTransactionalTestCase;
import com.slk.core.dao.sys.UserDao;
import com.slk.core.entity.sys.User;
import com.slk.core.query.sys.UserQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class UserDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private UserDao userDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void userCurl() throws Exception {
		UserQuery query = new UserQuery();
		long startRows = userDao.count(query);
		List<User> lists = userDao.list(query);
		assertEquals(lists.size(), startRows);
		
		User user = new User();
		/** id */
		/** 用户名 */
		user.setName("1");
		/** loginName */
		user.setLoginName("1");
		/** 密码 */
		user.setPassword("1");
		/** salt */
		user.setSalt("1");
		/** email */
		user.setEmail("1");
		/** 是否能登陆 */
		/** 允许登陆IP */
		user.setIpEnable("1");
		/** created */
		user.setCreated(new java.util.Date());
		/** deleted */
		user.setDeleted(1);
		/** lastOperateTime */
		user.setLastOperateTime(new java.util.Date());
		
		userDao.save(user);
		long saveRows = userDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		User userQueried = userDao.getById(user.getId());
		assertNotNull("查询错误", userQueried);
			assertEquals(userQueried.getId(), user.getId());
			assertEquals(userQueried.getName(), user.getName());
			assertEquals(userQueried.getLoginName(), user.getLoginName());
			assertEquals(userQueried.getPassword(), user.getPassword());
			assertEquals(userQueried.getSalt(), user.getSalt());
			assertEquals(userQueried.getEmail(), user.getEmail());
			assertEquals(userQueried.getLoginEnable(), user.getLoginEnable());
			assertEquals(userQueried.getIpEnable(), user.getIpEnable());
//			assertEquals(DateUtil.format(userQueried.getCreated(), "yyyy-mm-dd HH:MM"), 
//				DateUtil.format(user.getCreated(), "yyyy-mm-dd HH:MM"));
			assertEquals(userQueried.getDeleted(), user.getDeleted());
//			assertEquals(DateUtil.format(userQueried.getLastOperateTime(), "yyyy-mm-dd HH:MM"), 
//				DateUtil.format(user.getLastOperateTime(), "yyyy-mm-dd HH:MM"));
		
		/** 用户名 */
		user.setName("2");
		/** loginName */
		user.setLoginName("2");
		/** 密码 */
		user.setPassword("2");
		/** salt */
		user.setSalt("2");
		/** email */
		user.setEmail("2");
		/** 是否能登陆 */
		/** 允许登陆IP */
		user.setIpEnable("2");
		/** created */
		user.setCreated(new java.util.Date());
		/** deleted */
		user.setDeleted(2);
		/** lastOperateTime */
		user.setLastOperateTime(new java.util.Date());
		
		userDao.update(user);
		User userUpdated = userDao.getById(user.getId());
		assertEquals(userUpdated.getName(), user.getName());
		assertEquals(userUpdated.getLoginName(), user.getLoginName());
		assertEquals(userUpdated.getPassword(), user.getPassword());
		assertEquals(userUpdated.getSalt(), user.getSalt());
		assertEquals(userUpdated.getEmail(), user.getEmail());
		assertEquals(userUpdated.getLoginEnable(), user.getLoginEnable());
		assertEquals(userUpdated.getIpEnable(), user.getIpEnable());
//		assertEquals(DateUtil.format(userUpdated.getCreated(), "yyyy-mm-dd HH:MM"), 
//			DateUtil.format(userUpdated.getCreated(), "yyyy-mm-dd HH:MM"));
		assertEquals(userUpdated.getDeleted(), user.getDeleted());
//		assertEquals(DateUtil.format(userUpdated.getLastOperateTime(), "yyyy-mm-dd HH:MM"), 
//			DateUtil.format(userUpdated.getLastOperateTime(), "yyyy-mm-dd HH:MM"));
		
		//delete
		userDao.deleteById(user.getId());
		long deleteRows = userDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
