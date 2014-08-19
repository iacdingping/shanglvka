package com.slk.core.sys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.slk.core.dao.sys.MenuDao;
import com.slk.core.entity.sys.Menu;
import com.slk.core.query.sys.MenuQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class MenuDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private MenuDao menuDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void menuCurl() throws Exception {
		MenuQuery query = new MenuQuery();
		long startRows = menuDao.count(query);
		List<Menu> lists = menuDao.list(query);
		assertEquals(lists.size(), startRows);
		
		Menu menu = new Menu();
		/** 编号 */
		/** 父级编号 */
		menu.setParentId("1");
		/** 所有父级编号 */
		menu.setParentIds("1");
		/** 菜单名称 */
		menu.setName("1");
		/** 链接 */
		menu.setHref("1");
		/** 目标 */
		menu.setTarget("1");
		/** 图标 */
		menu.setIcon("1");
		/** 排序（升序） */
		menu.setSort(1);
		/** 是否在菜单中显示 */
		menu.setIsShow("1");
		/** 是否同步工作流 */
		menu.setIsActiviti("1");
		/** 权限标识 */
		menu.setPermission("1");
		/** 创建者 */
		menu.setCreateBy("1");
		/** 创建时间 */
		menu.setCreateDate(new java.util.Date());
		/** 更新者 */
		menu.setUpdateBy("1");
		/** 更新时间 */
		menu.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		menu.setRemarks("1");
		/** 删除标记 */
		menu.setDelFlag("1");
		
		menuDao.save(menu);
		long saveRows = menuDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		Menu menuQueried = menuDao.getById(menu.getId());
		assertNotNull("查询错误", menuQueried);
			assertEquals(menuQueried.getId(), menu.getId());
			assertEquals(menuQueried.getParentId(), menu.getParentId());
			assertEquals(menuQueried.getParentIds(), menu.getParentIds());
			assertEquals(menuQueried.getName(), menu.getName());
			assertEquals(menuQueried.getHref(), menu.getHref());
			assertEquals(menuQueried.getTarget(), menu.getTarget());
			assertEquals(menuQueried.getIcon(), menu.getIcon());
			assertEquals(menuQueried.getSort(), menu.getSort());
			assertEquals(menuQueried.getIsShow(), menu.getIsShow());
			assertEquals(menuQueried.getIsActiviti(), menu.getIsActiviti());
			assertEquals(menuQueried.getPermission(), menu.getPermission());
			assertEquals(menuQueried.getCreateBy(), menu.getCreateBy());
			assertEquals(menuQueried.getUpdateBy(), menu.getUpdateBy());
			assertEquals(menuQueried.getRemarks(), menu.getRemarks());
			assertEquals(menuQueried.getDelFlag(), menu.getDelFlag());
		
		/** 父级编号 */
		menu.setParentId("2");
		/** 所有父级编号 */
		menu.setParentIds("2");
		/** 菜单名称 */
		menu.setName("2");
		/** 链接 */
		menu.setHref("2");
		/** 目标 */
		menu.setTarget("2");
		/** 图标 */
		menu.setIcon("2");
		/** 排序（升序） */
		menu.setSort(2);
		/** 是否在菜单中显示 */
		menu.setIsShow("2");
		/** 是否同步工作流 */
		menu.setIsActiviti("2");
		/** 权限标识 */
		menu.setPermission("2");
		/** 创建者 */
		menu.setCreateBy("2");
		/** 创建时间 */
		menu.setCreateDate(new java.util.Date());
		/** 更新者 */
		menu.setUpdateBy("2");
		/** 更新时间 */
		menu.setUpdateDate(new java.util.Date());
		/** 备注信息 */
		menu.setRemarks("2");
		/** 删除标记 */
		menu.setDelFlag("2");
		
		menuDao.update(menu);
		Menu menuUpdated = menuDao.getById(menu.getId());
		assertEquals(menuUpdated.getParentId(), menu.getParentId());
		assertEquals(menuUpdated.getParentIds(), menu.getParentIds());
		assertEquals(menuUpdated.getName(), menu.getName());
		assertEquals(menuUpdated.getHref(), menu.getHref());
		assertEquals(menuUpdated.getTarget(), menu.getTarget());
		assertEquals(menuUpdated.getIcon(), menu.getIcon());
		assertEquals(menuUpdated.getSort(), menu.getSort());
		assertEquals(menuUpdated.getIsShow(), menu.getIsShow());
		assertEquals(menuUpdated.getIsActiviti(), menu.getIsActiviti());
		assertEquals(menuUpdated.getPermission(), menu.getPermission());
		assertEquals(menuUpdated.getCreateBy(), menu.getCreateBy());
		assertEquals(menuUpdated.getUpdateBy(), menu.getUpdateBy());
		assertEquals(menuUpdated.getRemarks(), menu.getRemarks());
		assertEquals(menuUpdated.getDelFlag(), menu.getDelFlag());
		
		//delete
		menuDao.deleteById(menu.getId());
		long deleteRows = menuDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
