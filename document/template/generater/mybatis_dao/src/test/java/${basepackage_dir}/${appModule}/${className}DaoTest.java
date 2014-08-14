<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${appModule};

<#include "/java_imports.include">

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

/**
<#include "/java_description.include">
 */
@DirtiesContext
public class ${className}DaoTest extends SpringTransactionalTestCase{
	@Autowired
	private ${className}Dao ${classNameLower}Dao;
	
	/**
	 * 注意只能单个库测试
	 * 因为对删除使用到count方法计数进行对比
	 * @throws Exception
	 */
	@Test
	public void ${classNameLower}Curl() throws Exception {
		${className}Query query = new ${className}Query();
		long startRows = ${classNameLower}Dao.count(query);
		List<${className}> lists = ${classNameLower}Dao.list(query);
		assertEquals(lists.size(), startRows);
		
		${className} ${classNameLower} = new ${className}();
		<#list table.columns as column>
		/** ${column.columnAlias} */
		<#if !column.pk>
		<#if !column.fk>
		<#if column.isDateTimeColumn>
		${classNameLower}.set${column.columnName}(new java.util.Date());
		<#elseif column.isStringColumn>
		${classNameLower}.set${column.columnName}("1");
		<#elseif column.isNumberColumn>
		${classNameLower}.set${column.columnName}(1<#if (column.javaType="java.lang.Long")>L</#if>);
		</#if>
		</#if>
		</#if>
		</#list>
		
		${classNameLower}Dao.save(${classNameLower});
		long saveRows = ${classNameLower}Dao.count(query);
		assertEquals(startRows + 1, saveRows);
		
		${className} ${classNameLower}Queried = ${classNameLower}Dao.getById(${classNameLower}.getId());
		assertNotNull("查询错误", ${classNameLower}Queried);
		<#list table.columns as column>
			<#if column.isDateTimeColumn>
			assertEquals(DateUtil.format(${classNameLower}Queried.get${column.columnName}(), "yyyy-mm-dd HH:MM"), 
				DateUtil.format(${classNameLower}.get${column.columnName}(), "yyyy-mm-dd HH:MM"));
			<#else>
			assertEquals(${classNameLower}Queried.get${column.columnName}(), ${classNameLower}.get${column.columnName}());
			</#if>
		</#list>
		
		<#list table.columns as column>
		<#if !column.pk>
		<#if !column.fk>
		/** ${column.columnAlias} */
		<#if column.isDateTimeColumn>
		${classNameLower}.set${column.columnName}(new java.util.Date());
		<#elseif column.isStringColumn>
		${classNameLower}.set${column.columnName}("2");
		<#elseif column.isNumberColumn>
		${classNameLower}.set${column.columnName}(2<#if (column.javaType="java.lang.Long")>L</#if>);
		</#if>
		</#if>
		</#if>
		</#list>
		
		${classNameLower}Dao.update(${classNameLower});
		${className} ${classNameLower}Updated = ${classNameLower}Dao.getById(${classNameLower}.getId());
		<#list table.columns as column>
		<#if !column.pk>
		<#if !column.fk>
		<#if column.isDateTimeColumn>
		assertEquals(DateUtil.format(${classNameLower}Updated.get${column.columnName}(), "yyyy-mm-dd HH:MM"), 
			DateUtil.format(${classNameLower}Updated.get${column.columnName}(), "yyyy-mm-dd HH:MM"));
		<#else>
		assertEquals(${classNameLower}Updated.get${column.columnName}(), ${classNameLower}.get${column.columnName}());
		</#if>
		</#if>
		</#if>
		</#list>
		
		//delete
		${classNameLower}Dao.deleteById(${classNameLower}.getId());
		long deleteRows = ${classNameLower}Dao.count(query);
		assertEquals(startRows, deleteRows);
	}
}
