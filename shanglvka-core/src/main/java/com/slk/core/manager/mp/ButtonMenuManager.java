package com.slk.core.manager.mp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.slk.core.PageList;
import com.slk.core.PageQuery;
import com.slk.core.dao.mp.ButtonMenuDao;
import com.slk.core.entity.mp.ButtonMenu;
import com.slk.core.query.mp.ButtonMenuQuery;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class ButtonMenuManager {

	@Autowired
	private ButtonMenuDao buttonMenuDao;

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写 */
	public void setButtonMenuDao(ButtonMenuDao dao) {
		this.buttonMenuDao = dao;
	}

	/**
	 * 创建ButtonMenu
	 **/
	public ButtonMenu save(ButtonMenu buttonMenu) {
		Assert.notNull(buttonMenu, "'buttonMenu' must be not null");
		this.buttonMenuDao.save(buttonMenu);
		return buttonMenu;
	}

	/**
	 * 更新ButtonMenu
	 **/
	public ButtonMenu update(ButtonMenu buttonMenu) {
		Assert.notNull(buttonMenu, "'buttonMenu' must be not null");
		this.buttonMenuDao.update(buttonMenu);
		return buttonMenu;
	}

	public void saveOrUpdate(ButtonMenu buttonMenu) {
		buttonMenu.setUpdateDate(new Date());
		if (buttonMenu.getId() == null) {
			buttonMenu.setCreateDate(new Date());
			this.buttonMenuDao.save(buttonMenu);
		} else {
			this.buttonMenuDao.update(buttonMenu);
		}
	}

	/**
	 * 删除ButtonMenu
	 **/
	public void deleteById(java.lang.Long id) {
		this.buttonMenuDao.deleteById(id);
		this.buttonMenuDao.deleteByParentId(id);
	}

	/**
	 * 根据ID得到ButtonMenu
	 **/
	public ButtonMenu getById(java.lang.Long id) {
		return this.buttonMenuDao.getById(id);
	}

	/**
	 * 统计总数ButtonMenu
	 **/
	public Long count(PageQuery query) {
		return buttonMenuDao.count(query);
	}

	/**
	 * list ButtonMenu
	 **/
	public List<ButtonMenu> list(PageQuery query) {
		return buttonMenuDao.list(query);
	}

	/**
	 * 分页查询: ButtonMenu
	 **/
	@Transactional(readOnly = true)
	public PageList<ButtonMenu> findPage(ButtonMenuQuery query) {
		Assert.notNull(query, "'query' must be not null");
		query.setSortColumns(" parent");
		return new PageList<ButtonMenu>(buttonMenuDao.findPage(query),
				query.getPage(), query.getPageSize(), count(query));
	}

	@Transactional(readOnly = true)
	public Long countByParent(ButtonMenu buttonMenu) {
		ButtonMenuQuery buttonMenuQuery=new ButtonMenuQuery();
		buttonMenuQuery.setParent(buttonMenu.getParent());
		buttonMenuQuery.setId(buttonMenu.getId());
		if(buttonMenu.getParent().getId()==null){
			buttonMenuQuery.setParent(new ButtonMenu(0L));
		}
		if(buttonMenu.getId()==null){
			buttonMenuQuery.setId(0l);
		}
		return buttonMenuDao.countByParent(buttonMenuQuery);
	}

}
