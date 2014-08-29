<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameFirstLower = table.classNameFirstLower>
<#assign classNameLower = className?uncap_first> 
<#macro mapperEl value>${r"${"}${value}}</#macro>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>
<title>${table.tableAlias}</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
		$(document).ready(function() {
			
		});
		
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="<@mapperEl 'ctx'/>/${appModule}/${classNameLower}/">${table.tableAlias}列表</a></li>
		<shiro:hasPermission name="${appModule}:${classNameLower}:edit">
			<li><a href="<@mapperEl 'ctx'/>/${appModule}/${classNameLower}/form">${table.tableAlias}添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form id="searchForm" modelAttribute="${classNameLower}"
		action="<@mapperEl 'ctx'/>/${appModule}/${classNameLower}" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="page" type="hidden" value="<@mapperEl 'pageQuery.page'/>"/>
		<input id="pageSize" name="pageSize" type="hidden" value="<@mapperEl 'pageQuery.pageSize'/>"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form>
	<tags:message content="<@mapperEl 'message'/>" />
		<form id="listForm" method="post">
		<table id="treeTable" class="table table-striped table-bordered table-condensed">
			<tr>
			<#list table.columns as column>
				<th>${column.columnAlias}</th>
			</#list>
				<th>操作</th>
			</tr>
			<c:forEach items="<@mapperEl 'pageList.items'/>" var="${classNameLower}">
				<tr id="bl<@mapperEl classNameLower + '.id'/>">
					<#list table.columns as column>
						<td><@mapperEl classNameLower + '.' + column.columnNameFirstLower/></td>
					</#list>
					<td>
						<shiro:hasPermission name="${appModule}:${classNameLower}:edit">
							<a href="<@mapperEl 'ctx'/>/${appModule}/${classNameLower}/form?id=<@mapperEl classNameLower + '.id'/>">修改</a>
								<a href="<@mapperEl 'ctx'/>/${appModule}/${classNameLower}/delete?id=<@mapperEl classNameLower + '.id'/>"
								onclick="return confirmx('确认要删除该网站首页吗？', this.href)">删除</a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="pagination"><@mapperEl 'pageList'/></div>
</body>
</html>
