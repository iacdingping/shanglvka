package com.slk.wap.controller.weixin.menu;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.slk.core.manager.mp.ButtonMenuManager;
import com.slk.wap.controller.user.WelcomeController;

@ActiveProfiles(value="production")
@ContextConfiguration(locations="classpath:spring-context.xml")
public class MenuControllerTest extends AbstractTransactionalJUnit4SpringContextTests{

	
	@Autowired(required=true)
	private MenuController mc;
	
	@Test
	public void testOrganizMenu(){
//		System.out.println(mc.);
	}
	
	public void test() {
		fail("Not yet implemented");
	}

	
}
