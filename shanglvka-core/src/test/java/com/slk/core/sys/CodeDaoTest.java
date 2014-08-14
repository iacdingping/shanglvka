package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.slk.core.SpringTransactionalTestCase;
import com.slk.core.dao.sys.CodeDao;
import com.slk.core.entity.sys.Code;
import com.slk.core.query.sys.CodeQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class CodeDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private CodeDao codeDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void codeCurl() throws Exception {
		CodeQuery query = new CodeQuery();
		long startRows = codeDao.count(query);
		List<Code> lists = codeDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Code code = new Code();
		/** id */
		/** 类型码 */
		code.setType("1");
		/** 编码 */
		code.setCode("1");
		/** 字典码 */
		code.setDictionaryCode("1");
		/** 字典值 */
		code.setDictionaryValue("1");
		/** 备用值 */
		code.setReserveValue("1");
		/** 备注 */
		code.setComment("1");
		/** created */
		code.setCreated(new java.util.Date());
		/** deleted */
		code.setDeleted(1);
		/** lastOperateTime */
		code.setLastOperateTime(new java.util.Date());
		
		codeDao.save(code);
		long saveRows = codeDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Code codeQueried = codeDao.getById(code.getId());
		assertNotNull("查询错误", codeQueried);
			assertEquals(codeQueried.getId(), code.getId());
			assertEquals(codeQueried.getType(), code.getType());
			assertEquals(codeQueried.getCode(), code.getCode());
			assertEquals(codeQueried.getDictionaryCode(), code.getDictionaryCode());
			assertEquals(codeQueried.getDictionaryValue(), code.getDictionaryValue());
			assertEquals(codeQueried.getReserveValue(), code.getReserveValue());
			assertEquals(codeQueried.getComment(), code.getComment());
//			assertEquals(DateUtil.format(codeQueried.getCreated(), "yyyy-mm-dd HH:MM"), 
//				DateUtil.format(code.getCreated(), "yyyy-mm-dd HH:MM"));
//			assertEquals(codeQueried.getDeleted(), code.getDeleted());
//			assertEquals(DateUtil.format(codeQueried.getLastOperateTime(), "yyyy-mm-dd HH:MM"), 
//				DateUtil.format(code.getLastOperateTime(), "yyyy-mm-dd HH:MM"));
		
		/** 类型码 */
		code.setType("2");
		/** 编码 */
		code.setCode("2");
		/** 字典码 */
		code.setDictionaryCode("2");
		/** 字典值 */
		code.setDictionaryValue("2");
		/** 备用值 */
		code.setReserveValue("2");
		/** 备注 */
		code.setComment("2");
		/** created */
		code.setCreated(new java.util.Date());
		/** deleted */
		code.setDeleted(2);
		/** lastOperateTime */
		code.setLastOperateTime(new java.util.Date());
		
		codeDao.update(code);
		Code codeUpdated = codeDao.getById(code.getId());
		assertEquals(codeUpdated.getType(), code.getType());
		assertEquals(codeUpdated.getCode(), code.getCode());
		assertEquals(codeUpdated.getDictionaryCode(), code.getDictionaryCode());
		assertEquals(codeUpdated.getDictionaryValue(), code.getDictionaryValue());
		assertEquals(codeUpdated.getReserveValue(), code.getReserveValue());
		assertEquals(codeUpdated.getComment(), code.getComment());
//		assertEquals(DateUtil.format(codeUpdated.getCreated(), "yyyy-mm-dd HH:MM"), 
//			DateUtil.format(codeUpdated.getCreated(), "yyyy-mm-dd HH:MM"));
//		assertEquals(codeUpdated.getDeleted(), code.getDeleted());
//		assertEquals(DateUtil.format(codeUpdated.getLastOperateTime(), "yyyy-mm-dd HH:MM"), 
//			DateUtil.format(codeUpdated.getLastOperateTime(), "yyyy-mm-dd HH:MM"));
		
		//delete
		codeDao.deleteById(code.getId());
		long deleteRows = codeDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
