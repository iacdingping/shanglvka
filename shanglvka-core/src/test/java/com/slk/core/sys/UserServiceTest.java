package com.slk.core.sys;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.slk.core.SpringTransactionalTestCase;
import com.slk.core.entity.sys.User;
import com.slk.core.service.sys.UserService;

@DirtiesContext
public class UserServiceTest extends SpringTransactionalTestCase {

	@Autowired
	private UserService userService;
	
	@Test
	public void createUserTest() {
		User user = new User();
		user.setLoginEnable(true);
		user.setLoginName("admin");
		user.setName("系统帐号");
		user.setPassword("123456");
		user.setSalt("123");
		userService.createUser(user);
	}
}
