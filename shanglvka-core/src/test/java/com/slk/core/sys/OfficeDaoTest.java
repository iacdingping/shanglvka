package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.sys.OfficeDao;
import com.slk.core.entity.sys.Office;
import com.slk.core.query.sys.OfficeQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class OfficeDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private OfficeDao officeDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void officeCurl() throws Exception {
		OfficeQuery query = new OfficeQuery();
		long startRows = officeDao.count(query);
		List<Office> lists = officeDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Office office = new Office();
		/** 编号 */
		/** 父级编号 */
		office.setParentId("1");
		/** 所有父级编号 */
		office.setParentIds("1");
		/** 归属区域 */
		office.setAreaId("1");
		/** 区域编码 */
		office.setCode("1");
		/** 机构名称 */
		office.setName("1");
		/** 机构类型 */
		office.setType("1");
		/** 机构等级 */
		office.setGrade("1");
		/** 联系地址 */
		office.setAddress("1");
		/** 邮政编码 */
		office.setZipCode("1");
		/** 负责人 */
		office.setMaster("1");
		/** 电话 */
		office.setPhone("1");
		/** 传真 */
		office.setFax("1");
		/** 邮箱 */
		office.setEmail("1");
		/** 创建者 */
		office.setCreateBy("1");
		/** 创建时间 */
		office.setCreateDate(new java.util.Date());
		/** 更新者 */
		office.setUpdateBy("1");
		/** 更新时间 */
		office.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		office.setRemarks("1");
		/** 删除标记 */
		office.setDelFlag("1");
		
		officeDao.save(office);
		long saveRows = officeDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Office officeQueried = officeDao.getById(office.getId());
		assertNotNull("查询错误", officeQueried);
			assertEquals(officeQueried.getId(), office.getId());
			assertEquals(officeQueried.getParentId(), office.getParentId());
			assertEquals(officeQueried.getParentIds(), office.getParentIds());
			assertEquals(officeQueried.getAreaId(), office.getAreaId());
			assertEquals(officeQueried.getCode(), office.getCode());
			assertEquals(officeQueried.getName(), office.getName());
			assertEquals(officeQueried.getType(), office.getType());
			assertEquals(officeQueried.getGrade(), office.getGrade());
			assertEquals(officeQueried.getAddress(), office.getAddress());
			assertEquals(officeQueried.getZipCode(), office.getZipCode());
			assertEquals(officeQueried.getMaster(), office.getMaster());
			assertEquals(officeQueried.getPhone(), office.getPhone());
			assertEquals(officeQueried.getFax(), office.getFax());
			assertEquals(officeQueried.getEmail(), office.getEmail());
			assertEquals(officeQueried.getCreateBy(), office.getCreateBy());
			assertEquals(officeQueried.getUpdateBy(), office.getUpdateBy());
			assertEquals(officeQueried.getRemarks(), office.getRemarks());
			assertEquals(officeQueried.getDelFlag(), office.getDelFlag());
		
		/** 父级编号 */
		office.setParentId("2");
		/** 所有父级编号 */
		office.setParentIds("2");
		/** 归属区域 */
		office.setAreaId("2");
		/** 区域编码 */
		office.setCode("2");
		/** 机构名称 */
		office.setName("2");
		/** 机构类型 */
		office.setType("2");
		/** 机构等级 */
		office.setGrade("2");
		/** 联系地址 */
		office.setAddress("2");
		/** 邮政编码 */
		office.setZipCode("2");
		/** 负责人 */
		office.setMaster("2");
		/** 电话 */
		office.setPhone("2");
		/** 传真 */
		office.setFax("2");
		/** 邮箱 */
		office.setEmail("2");
		/** 创建者 */
		office.setCreateBy("2");
		/** 创建时间 */
		office.setCreateDate(new java.util.Date());
		/** 更新者 */
		office.setUpdateBy("2");
		/** 更新时间 */
		office.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		office.setRemarks("2");
		/** 删除标记 */
		office.setDelFlag("2");
		
		officeDao.update(office);
		Office officeUpdated = officeDao.getById(office.getId());
		assertEquals(officeUpdated.getParentId(), office.getParentId());
		assertEquals(officeUpdated.getParentIds(), office.getParentIds());
		assertEquals(officeUpdated.getAreaId(), office.getAreaId());
		assertEquals(officeUpdated.getCode(), office.getCode());
		assertEquals(officeUpdated.getName(), office.getName());
		assertEquals(officeUpdated.getType(), office.getType());
		assertEquals(officeUpdated.getGrade(), office.getGrade());
		assertEquals(officeUpdated.getAddress(), office.getAddress());
		assertEquals(officeUpdated.getZipCode(), office.getZipCode());
		assertEquals(officeUpdated.getMaster(), office.getMaster());
		assertEquals(officeUpdated.getPhone(), office.getPhone());
		assertEquals(officeUpdated.getFax(), office.getFax());
		assertEquals(officeUpdated.getEmail(), office.getEmail());
		assertEquals(officeUpdated.getCreateBy(), office.getCreateBy());
		assertEquals(officeUpdated.getUpdateBy(), office.getUpdateBy());
		assertEquals(officeUpdated.getRemarks(), office.getRemarks());
		assertEquals(officeUpdated.getDelFlag(), office.getDelFlag());
		
		//delete
		officeDao.deleteById(office.getId());
		long deleteRows = officeDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
