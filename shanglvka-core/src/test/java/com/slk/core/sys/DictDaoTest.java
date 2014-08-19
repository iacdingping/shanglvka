package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.sys.DictDao;
import com.slk.core.entity.sys.Dict;
import com.slk.core.query.sys.DictQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class DictDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private DictDao dictDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void dictCurl() throws Exception {
		DictQuery query = new DictQuery();
		long startRows = dictDao.count(query);
		List<Dict> lists = dictDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Dict dict = new Dict();
		/** 编号 */
		/** 标签名 */
		dict.setLabel("1");
		/** 数据值 */
		dict.setValue("1");
		/** 类型 */
		dict.setType("1");
		/** 描述 */
		dict.setDescription("1");
		/** 排序（升序） */
		dict.setSort(1);
		/** 创建者 */
		dict.setCreateBy("1");
		/** 创建时间 */
		dict.setCreateDate(new java.util.Date());
		/** 更新者 */
		dict.setUpdateBy("1");
		/** 更新时间 */
		dict.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		dict.setRemarks("1");
		/** 删除标记 */
		dict.setDelFlag("1");
		
		dictDao.save(dict);
		long saveRows = dictDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Dict dictQueried = dictDao.getById(dict.getId());
		assertNotNull("查询错误", dictQueried);
			assertEquals(dictQueried.getId(), dict.getId());
			assertEquals(dictQueried.getLabel(), dict.getLabel());
			assertEquals(dictQueried.getValue(), dict.getValue());
			assertEquals(dictQueried.getType(), dict.getType());
			assertEquals(dictQueried.getDescription(), dict.getDescription());
			assertEquals(dictQueried.getSort(), dict.getSort());
			assertEquals(dictQueried.getCreateBy(), dict.getCreateBy());
			assertEquals(dictQueried.getUpdateBy(), dict.getUpdateBy());
			assertEquals(dictQueried.getRemarks(), dict.getRemarks());
			assertEquals(dictQueried.getDelFlag(), dict.getDelFlag());
		
		/** 标签名 */
		dict.setLabel("2");
		/** 数据值 */
		dict.setValue("2");
		/** 类型 */
		dict.setType("2");
		/** 描述 */
		dict.setDescription("2");
		/** 排序（升序） */
		dict.setSort(2);
		/** 创建者 */
		dict.setCreateBy("2");
		/** 创建时间 */
		dict.setCreateDate(new java.util.Date());
		/** 更新者 */
		dict.setUpdateBy("2");
		/** 更新时间 */
		dict.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		dict.setRemarks("2");
		/** 删除标记 */
		dict.setDelFlag("2");
		
		dictDao.update(dict);
		Dict dictUpdated = dictDao.getById(dict.getId());
		assertEquals(dictUpdated.getLabel(), dict.getLabel());
		assertEquals(dictUpdated.getValue(), dict.getValue());
		assertEquals(dictUpdated.getType(), dict.getType());
		assertEquals(dictUpdated.getDescription(), dict.getDescription());
		assertEquals(dictUpdated.getSort(), dict.getSort());
		assertEquals(dictUpdated.getCreateBy(), dict.getCreateBy());
		assertEquals(dictUpdated.getUpdateBy(), dict.getUpdateBy());
		assertEquals(dictUpdated.getRemarks(), dict.getRemarks());
		assertEquals(dictUpdated.getDelFlag(), dict.getDelFlag());
		
		//delete
		dictDao.deleteById(dict.getId());
		long deleteRows = dictDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
