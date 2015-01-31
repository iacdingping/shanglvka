package com.slk.core.mp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.slk.core.SpringTransactionalTestCase;
import com.slk.core.dao.mp.UserBindCardDao;
import com.slk.core.entity.mp.UserBindCard;
import com.slk.core.query.mp.UserBindCardQuery;
import com.thinkgem.jeesite.common.utils.DateUtils;

/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@DirtiesContext
public class UserBindCardDaoTest extends SpringTransactionalTestCase{
	@Autowired
	private UserBindCardDao userBindCardDao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void userBindCardCurl() throws Exception {
		UserBindCardQuery query = new UserBindCardQuery();
		long startRows = userBindCardDao.count(query);
		List<UserBindCard> lists = userBindCardDao.list(query);
		assertEquals(lists.size(), startRows);
		
		UserBindCard userBindCard = new UserBindCard();
		/** id */
		/** 平台openid */
		userBindCard.setPlatformCode("1");
		/** 绑定卡号 */
		userBindCard.setCardNo("1");
		/** 状态，0 删除绑定 1 绑定成功 2 绑定失败 */
		userBindCard.setStatus(1);
		/** 绑定时间 */
		userBindCard.setUpdateTime(new java.util.Date());
		/** createDate */
		userBindCard.setCreateDate(new java.util.Date());
		
		userBindCardDao.save(userBindCard);
		long saveRows = userBindCardDao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		UserBindCard userBindCardQueried = userBindCardDao.getById(userBindCard.getId());
		assertNotNull("查询错误", userBindCardQueried);
			assertEquals(userBindCardQueried.getId(), userBindCard.getId());
			assertEquals(userBindCardQueried.getPlatformCode(), userBindCard.getPlatformCode());
			assertEquals(userBindCardQueried.getCardNo(), userBindCard.getCardNo());
			assertEquals(userBindCardQueried.getStatus(), userBindCard.getStatus());
			assertEquals(DateUtils.formatDate(userBindCardQueried.getUpdateTime(), "yyyy-mm-dd HH:MM"), 
					DateUtils.formatDate(userBindCard.getUpdateTime(), "yyyy-mm-dd HH:MM"));
			assertEquals(DateUtils.formatDate(userBindCardQueried.getCreateDate(), "yyyy-mm-dd HH:MM"), 
					DateUtils.formatDate(userBindCard.getCreateDate(), "yyyy-mm-dd HH:MM"));
		
		/** 平台openid */
		userBindCard.setPlatformCode("2");
		/** 绑定卡号 */
		userBindCard.setCardNo("2");
		/** 状态，0 删除绑定 1 绑定成功 2 绑定失败 */
		userBindCard.setStatus(2);
		/** 绑定时间 */
		userBindCard.setUpdateTime(new java.util.Date());
		/** createDate */
		userBindCard.setCreateDate(new java.util.Date());
		
		userBindCardDao.update(userBindCard);
		UserBindCard userBindCardUpdated = userBindCardDao.getById(userBindCard.getId());
		assertEquals(userBindCardUpdated.getPlatformCode(), userBindCard.getPlatformCode());
		assertEquals(userBindCardUpdated.getCardNo(), userBindCard.getCardNo());
		assertEquals(userBindCardUpdated.getStatus(), userBindCard.getStatus());
		assertEquals(DateUtils.formatDate(userBindCardUpdated.getUpdateTime(), "yyyy-mm-dd HH:MM"), 
				DateUtils.formatDate(userBindCardUpdated.getUpdateTime(), "yyyy-mm-dd HH:MM"));
		assertEquals(DateUtils.formatDate(userBindCardUpdated.getCreateDate(), "yyyy-mm-dd HH:MM"), 
				DateUtils.formatDate(userBindCardUpdated.getCreateDate(), "yyyy-mm-dd HH:MM"));
		
		//delete
		userBindCardDao.deleteById(userBindCard.getId());
		long deleteRows = userBindCardDao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
