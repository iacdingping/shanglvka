package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.sys.MdictDao;
import com.slk.core.entity.sys.Mdict;
import com.slk.core.query.sys.MdictQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class MdictDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private MdictDao mdictDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void mdictCurl() throws Exception {
		MdictQuery query = new MdictQuery();
		long startRows = mdictDao.count(query);
		List<Mdict> lists = mdictDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Mdict mdict = new Mdict();
		/** 编号 */
		/** 父级编号 */
		mdict.setParentId("1");
		/** 所有父级编号 */
		mdict.setParentIds("1");
		/** 角色名称 */
		mdict.setName("1");
		/** 描述 */
		mdict.setDescription("1");
		/** 排序（升序） */
		mdict.setSort(1);
		/** 创建者 */
		mdict.setCreateBy("1");
		/** 创建时间 */
		mdict.setCreateDate(new java.util.Date());
		/** 更新者 */
		mdict.setUpdateBy("1");
		/** 更新时间 */
		mdict.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		mdict.setRemarks("1");
		/** 删除标记 */
		mdict.setDelFlag("1");
		
		mdictDao.save(mdict);
		long saveRows = mdictDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Mdict mdictQueried = mdictDao.getById(mdict.getId());
		assertNotNull("查询错误", mdictQueried);
			assertEquals(mdictQueried.getId(), mdict.getId());
			assertEquals(mdictQueried.getParentId(), mdict.getParentId());
			assertEquals(mdictQueried.getParentIds(), mdict.getParentIds());
			assertEquals(mdictQueried.getName(), mdict.getName());
			assertEquals(mdictQueried.getDescription(), mdict.getDescription());
			assertEquals(mdictQueried.getSort(), mdict.getSort());
			assertEquals(mdictQueried.getCreateBy(), mdict.getCreateBy());
			assertEquals(mdictQueried.getUpdateBy(), mdict.getUpdateBy());
			assertEquals(mdictQueried.getRemarks(), mdict.getRemarks());
			assertEquals(mdictQueried.getDelFlag(), mdict.getDelFlag());
		
		/** 父级编号 */
		mdict.setParentId("2");
		/** 所有父级编号 */
		mdict.setParentIds("2");
		/** 角色名称 */
		mdict.setName("2");
		/** 描述 */
		mdict.setDescription("2");
		/** 排序（升序） */
		mdict.setSort(2);
		/** 创建者 */
		mdict.setCreateBy("2");
		/** 创建时间 */
		mdict.setCreateDate(new java.util.Date());
		/** 更新者 */
		mdict.setUpdateBy("2");
		/** 更新时间 */
		mdict.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		mdict.setRemarks("2");
		/** 删除标记 */
		mdict.setDelFlag("2");
		
		mdictDao.update(mdict);
		Mdict mdictUpdated = mdictDao.getById(mdict.getId());
		assertEquals(mdictUpdated.getParentId(), mdict.getParentId());
		assertEquals(mdictUpdated.getParentIds(), mdict.getParentIds());
		assertEquals(mdictUpdated.getName(), mdict.getName());
		assertEquals(mdictUpdated.getDescription(), mdict.getDescription());
		assertEquals(mdictUpdated.getSort(), mdict.getSort());
		assertEquals(mdictUpdated.getCreateBy(), mdict.getCreateBy());
		assertEquals(mdictUpdated.getUpdateBy(), mdict.getUpdateBy());
		assertEquals(mdictUpdated.getRemarks(), mdict.getRemarks());
		assertEquals(mdictUpdated.getDelFlag(), mdict.getDelFlag());
		
		//delete
		mdictDao.deleteById(mdict.getId());
		long deleteRows = mdictDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
