package com.slk.core;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Spring的支持数据库访问, 事务控制和依赖注入的JUnit4 集成测试基类.
 * 相比Spring原基类名字更短并保存了dataSource变量.
 * 
 * 子类需要定义applicationContext文件的位置, 如:
 * 
 * @ContextConfiguration(locations = { "/applicationContext-test.xml" })
 * 
 * @author calvin
 */
@ActiveProfiles(Profiles.UNIT_TEST)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public abstract class SpringTransactionalTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	protected DataSource dataSource;

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}
}
