package com.slk.core.platform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.platform.PlatformUserDao;
import com.slk.core.entity.platform.PlatformUser;
import com.slk.core.query.platform.PlatformUserQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class PlatformUserDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private PlatformUserDao platformUserDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void platformUserCurl() throws Exception {
		PlatformUserQuery query = new PlatformUserQuery();
		long startRows = platformUserDao.count(query);
		List<PlatformUser> lists = platformUserDao.list(query);
		assertEquals(lists.size(), startRows);
		
		PlatformUser platformUser = new PlatformUser();
		/** id */
		/** 身份标识 */
		platformUser.setIdentification("1");
		/** 平台号码 */
		platformUser.setPlatformCode("1");
		/** 类型 1 关注 2 取消关注 3 绑定 */
		platformUser.setType(1);
		/** createDate */
		platformUser.setCreateDate(new java.util.Date());
		/** updateDate */
		platformUser.setUpdateDate(new java.util.Date());
		/** delFlag */
		platformUser.setDelFlag(1);
		
		platformUserDao.save(platformUser);
		long saveRows = platformUserDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		PlatformUser platformUserQueried = platformUserDao.getById(platformUser.getId());
		assertNotNull("查询错误", platformUserQueried);
			assertEquals(platformUserQueried.getId(), platformUser.getId());
			assertEquals(platformUserQueried.getIdentification(), platformUser.getIdentification());
			assertEquals(platformUserQueried.getPlatformCode(), platformUser.getPlatformCode());
			assertEquals(platformUserQueried.getType(), platformUser.getType());
			assertEquals(platformUserQueried.getDelFlag(), platformUser.getDelFlag());
		
		/** 身份标识 */
		platformUser.setIdentification("2");
		/** 平台号码 */
		platformUser.setPlatformCode("2");
		/** 类型 1 关注 2 取消关注 3 绑定 */
		platformUser.setType(2);
		/** createDate */
		platformUser.setCreateDate(new java.util.Date());
		/** updateDate */
		platformUser.setUpdateDate(new java.util.Date());
		/** delFlag */
		platformUser.setDelFlag(2);
		
		platformUserDao.update(platformUser);
		PlatformUser platformUserUpdated = platformUserDao.getById(platformUser.getId());
		assertEquals(platformUserUpdated.getIdentification(), platformUser.getIdentification());
		assertEquals(platformUserUpdated.getPlatformCode(), platformUser.getPlatformCode());
		assertEquals(platformUserUpdated.getType(), platformUser.getType());
		assertEquals(platformUserUpdated.getDelFlag(), platformUser.getDelFlag());
		
		//delete
		platformUserDao.deleteById(platformUser.getId());
		long deleteRows = platformUserDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
