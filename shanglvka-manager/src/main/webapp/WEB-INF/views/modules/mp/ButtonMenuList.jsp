<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>
<title>微信平台自定义菜单</title>
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
		<li class="active"><a href="${ctx}/mp/buttonMenu/">微信平台自定义菜单列表</a></li>
		<shiro:hasPermission name="mp:buttonMenu:edit">
			<li><a href="${ctx}/mp/buttonMenu/form">微信平台自定义菜单添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form id="searchForm" modelAttribute="buttonMenu"
		action="${ctx}/mp/buttonMenu" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="page" type="hidden" value="${pageQuery.page}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${pageQuery.pageSize}"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form>
	<tags:message content="${message}" />
		<form id="listForm" method="post">
		<table id="treeTable" class="table table-striped table-bordered table-condensed">
			<tr>
				<th>id</th>
				<th>菜单名称</th>
				<th>响应键标识(mp_platform_keyword关键字对应)</th>
				<th>父ID</th>
				<th>类型 BUTTON,LINK</th>
				<th>createDate</th>
				<th>updateDate</th>
				<th>delFlag</th>
			</tr>
			<c:forEach items="${pageList.items}" var="buttonMenu">
				<tr id="bl${buttonMenu.id}">
						<td>${buttonMenu.id}</td>
						<td>${buttonMenu.name}</td>
						<td>${buttonMenu.key}</td>
						<td>${buttonMenu.parent}</td>
						<td>${buttonMenu.type}</td>
						<td>${buttonMenu.createDate}</td>
						<td>${buttonMenu.updateDate}</td>
						<td>${buttonMenu.delFlag}</td>
						<td>操作</td>
					<td>
						<shiro:hasPermission name="mp:buttonMenu:edit">
							<a href="${ctx}/mp/buttonMenu/form?id=${buttonMenu.id}">修改</a>
								<a href="${ctx}/mp/buttonMenu/delete?id=${buttonMenu.id}"
								onclick="return confirmx('确认要删除该网站首页吗？', this.href)">删除</a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="pagination">${pageList}</div>
</body>
</html>
