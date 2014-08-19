package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

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
		/** 编号 */
		/** 归属公司 */
		user.setCompanyId("1");
		/** 归属部门 */
		user.setOfficeId("1");
		/** 登录名 */
		user.setLoginName("1");
		/** 密码 */
		user.setPassword("1");
		/** 工号 */
		user.setNo("1");
		/** 姓名 */
		user.setName("1");
		/** 邮箱 */
		user.setEmail("1");
		/** 电话 */
		user.setPhone("1");
		/** 手机 */
		user.setMobile("1");
		/** 用户类型 */
		user.setUserType("1");
		/** 最后登陆IP */
		user.setLoginIp("1");
		/** 最后登陆时间 */
		user.setLoginDate(new java.util.Date());
		/** 创建者 */
		user.setCreateBy("1");
		/** 创建时间 */
		user.setCreateDate(new java.util.Date());
		/** 更新者 */
		user.setUpdateBy("1");
		/** 更新时间 */
		user.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		user.setRemarks("1");
		/** 删除标记 */
		user.setDelFlag("1");
		
		userDao.save(user);
		long saveRows = userDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		User userQueried = userDao.getById(user.getId());
		assertNotNull("查询错误", userQueried);
			assertEquals(userQueried.getId(), user.getId());
			assertEquals(userQueried.getCompanyId(), user.getCompanyId());
			assertEquals(userQueried.getOfficeId(), user.getOfficeId());
			assertEquals(userQueried.getLoginName(), user.getLoginName());
			assertEquals(userQueried.getPassword(), user.getPassword());
			assertEquals(userQueried.getNo(), user.getNo());
			assertEquals(userQueried.getName(), user.getName());
			assertEquals(userQueried.getEmail(), user.getEmail());
			assertEquals(userQueried.getPhone(), user.getPhone());
			assertEquals(userQueried.getMobile(), user.getMobile());
			assertEquals(userQueried.getUserType(), user.getUserType());
			assertEquals(userQueried.getLoginIp(), user.getLoginIp());
			assertEquals(userQueried.getCreateBy(), user.getCreateBy());
			assertEquals(userQueried.getUpdateBy(), user.getUpdateBy());
			assertEquals(userQueried.getRemarks(), user.getRemarks());
			assertEquals(userQueried.getDelFlag(), user.getDelFlag());
		
		/** 归属公司 */
		user.setCompanyId("2");
		/** 归属部门 */
		user.setOfficeId("2");
		/** 登录名 */
		user.setLoginName("2");
		/** 密码 */
		user.setPassword("2");
		/** 工号 */
		user.setNo("2");
		/** 姓名 */
		user.setName("2");
		/** 邮箱 */
		user.setEmail("2");
		/** 电话 */
		user.setPhone("2");
		/** 手机 */
		user.setMobile("2");
		/** 用户类型 */
		user.setUserType("2");
		/** 最后登陆IP */
		user.setLoginIp("2");
		/** 最后登陆时间 */
		user.setLoginDate(new java.util.Date());
		/** 创建者 */
		user.setCreateBy("2");
		/** 创建时间 */
		user.setCreateDate(new java.util.Date());
		/** 更新者 */
		user.setUpdateBy("2");
		/** 更新时间 */
		user.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		user.setRemarks("2");
		/** 删除标记 */
		user.setDelFlag("2");
		
		userDao.update(user);
		User userUpdated = userDao.getById(user.getId());
		assertEquals(userUpdated.getCompanyId(), user.getCompanyId());
		assertEquals(userUpdated.getOfficeId(), user.getOfficeId());
		assertEquals(userUpdated.getLoginName(), user.getLoginName());
		assertEquals(userUpdated.getPassword(), user.getPassword());
		assertEquals(userUpdated.getNo(), user.getNo());
		assertEquals(userUpdated.getName(), user.getName());
		assertEquals(userUpdated.getEmail(), user.getEmail());
		assertEquals(userUpdated.getPhone(), user.getPhone());
		assertEquals(userUpdated.getMobile(), user.getMobile());
		assertEquals(userUpdated.getUserType(), user.getUserType());
		assertEquals(userUpdated.getLoginIp(), user.getLoginIp());
		assertEquals(userUpdated.getCreateBy(), user.getCreateBy());
		assertEquals(userUpdated.getUpdateBy(), user.getUpdateBy());
		assertEquals(userUpdated.getRemarks(), user.getRemarks());
		assertEquals(userUpdated.getDelFlag(), user.getDelFlag());
		
		//delete
		userDao.deleteById(user.getId());
		long deleteRows = userDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
