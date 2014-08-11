package com.slk.tempService;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@SuppressWarnings("unused")
@ActiveProfiles("test")
@ContextConfiguration(locations={"classpath:spring-dao.xml"})
public class TempServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private TempService ts;
	@Test
	public void testTemp() {
		//fail("Not yet implemented");
		System.out.println(ts.temp());
	}

}
