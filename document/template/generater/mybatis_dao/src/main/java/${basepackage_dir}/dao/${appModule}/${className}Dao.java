<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.${appModule};

<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
@MyBatisRepository
public interface ${className}Dao extends BaseMyBatisRepository<${className},${table.idColumn.javaType}>{

	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} v);
	</#if>
	</#list>

}
