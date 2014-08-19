package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

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
		/** 编号 */
		/** 归属机构 */
		role.setOfficeId("1");
		/** 角色名称 */
		role.setName("1");
		/** 数据范围 */
		role.setDataScope("1");
		/** 创建者 */
		role.setCreateBy("1");
		/** 创建时间 */
		role.setCreateDate(new java.util.Date());
		/** 更新者 */
		role.setUpdateBy("1");
		/** 更新时间 */
		role.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		role.setRemarks("1");
		/** 删除标记 */
		role.setDelFlag("1");
		
		roleDao.save(role);
		long saveRows = roleDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Role roleQueried = roleDao.getById(role.getId());
		assertNotNull("查询错误", roleQueried);
			assertEquals(roleQueried.getId(), role.getId());
			assertEquals(roleQueried.getOfficeId(), role.getOfficeId());
			assertEquals(roleQueried.getName(), role.getName());
			assertEquals(roleQueried.getDataScope(), role.getDataScope());
			assertEquals(roleQueried.getCreateBy(), role.getCreateBy());
			assertEquals(roleQueried.getUpdateBy(), role.getUpdateBy());
			assertEquals(roleQueried.getRemarks(), role.getRemarks());
			assertEquals(roleQueried.getDelFlag(), role.getDelFlag());
		
		/** 归属机构 */
		role.setOfficeId("2");
		/** 角色名称 */
		role.setName("2");
		/** 数据范围 */
		role.setDataScope("2");
		/** 创建者 */
		role.setCreateBy("2");
		/** 创建时间 */
		role.setCreateDate(new java.util.Date());
		/** 更新者 */
		role.setUpdateBy("2");
		/** 更新时间 */
		role.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		role.setRemarks("2");
		/** 删除标记 */
		role.setDelFlag("2");
		
		roleDao.update(role);
		Role roleUpdated = roleDao.getById(role.getId());
		assertEquals(roleUpdated.getOfficeId(), role.getOfficeId());
		assertEquals(roleUpdated.getName(), role.getName());
		assertEquals(roleUpdated.getDataScope(), role.getDataScope());
		assertEquals(roleUpdated.getCreateBy(), role.getCreateBy());
		assertEquals(roleUpdated.getUpdateBy(), role.getUpdateBy());
		assertEquals(roleUpdated.getRemarks(), role.getRemarks());
		assertEquals(roleUpdated.getDelFlag(), role.getDelFlag());
		
		//delete
		roleDao.deleteById(role.getId());
		long deleteRows = roleDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
