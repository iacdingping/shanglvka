package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.sys.AreaDao;
import com.slk.core.entity.sys.Area;
import com.slk.core.query.sys.AreaQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class AreaDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private AreaDao areaDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void areaCurl() throws Exception {
		AreaQuery query = new AreaQuery();
		long startRows = areaDao.count(query);
		List<Area> lists = areaDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Area area = new Area();
		/** 编号 */
		/** 父级编号 */
		area.setParentId("1");
		/** 所有父级编号 */
		area.setParentIds("1");
		/** 区域编码 */
		area.setCode("1");
		/** 区域名称 */
		area.setName("1");
		/** 区域类型 */
		area.setType("1");
		/** 创建者 */
		area.setCreateBy("1");
		/** 创建时间 */
		area.setCreateDate(new java.util.Date());
		/** 更新者 */
		area.setUpdateBy("1");
		/** 更新时间 */
		area.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		area.setRemarks("1");
		/** 删除标记 */
		area.setDelFlag("1");
		
		areaDao.save(area);
		long saveRows = areaDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Area areaQueried = areaDao.getById(area.getId());
		assertNotNull("查询错误", areaQueried);
			assertEquals(areaQueried.getId(), area.getId());
			assertEquals(areaQueried.getParentId(), area.getParentId());
			assertEquals(areaQueried.getParentIds(), area.getParentIds());
			assertEquals(areaQueried.getCode(), area.getCode());
			assertEquals(areaQueried.getName(), area.getName());
			assertEquals(areaQueried.getType(), area.getType());
			assertEquals(areaQueried.getCreateBy(), area.getCreateBy());
			assertEquals(areaQueried.getUpdateBy(), area.getUpdateBy());
			assertEquals(areaQueried.getRemarks(), area.getRemarks());
			assertEquals(areaQueried.getDelFlag(), area.getDelFlag());
		
		/** 父级编号 */
		area.setParentId("2");
		/** 所有父级编号 */
		area.setParentIds("2");
		/** 区域编码 */
		area.setCode("2");
		/** 区域名称 */
		area.setName("2");
		/** 区域类型 */
		area.setType("2");
		/** 创建者 */
		area.setCreateBy("2");
		/** 创建时间 */
		area.setCreateDate(new java.util.Date());
		/** 更新者 */
		area.setUpdateBy("2");
		/** 更新时间 */
		area.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		area.setRemarks("2");
		/** 删除标记 */
		area.setDelFlag("2");
		
		areaDao.update(area);
		Area areaUpdated = areaDao.getById(area.getId());
		assertEquals(areaUpdated.getParentId(), area.getParentId());
		assertEquals(areaUpdated.getParentIds(), area.getParentIds());
		assertEquals(areaUpdated.getCode(), area.getCode());
		assertEquals(areaUpdated.getName(), area.getName());
		assertEquals(areaUpdated.getType(), area.getType());
		assertEquals(areaUpdated.getCreateBy(), area.getCreateBy());
		assertEquals(areaUpdated.getUpdateBy(), area.getUpdateBy());
		assertEquals(areaUpdated.getRemarks(), area.getRemarks());
		assertEquals(areaUpdated.getDelFlag(), area.getDelFlag());
		
		//delete
		areaDao.deleteById(area.getId());
		long deleteRows = areaDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
