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
		<shiro:hasPermission name="mp:buttonMenu:view">
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
				<th>ID</th>
				<th>菜单名称</th>
				<th>关键字</th>
				<th>父ID</th>
				<th>类型</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>是否有效</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageList.items}" var="buttonMenu">
				<tr id="bl${buttonMenu.id}">
						<td>${buttonMenu.id}</td>
						<td>${buttonMenu.name}</td>
						<td>${buttonMenu.key}</td>
						<td><c:if test="${buttonMenu.parent==0}">顶级</c:if><c:if test="${buttonMenu.parent!=0}">${buttonMenu.parent}</c:if></td>
						<td><c:if test="${buttonMenu.type=='click'}">按钮</c:if><c:if test="${buttonMenu.type=='view'}">链接</c:if></td>
						<td><fmt:formatDate value="${buttonMenu.createDate}" type="both"/></td>
						<td><fmt:formatDate value="${buttonMenu.updateDate}" type="both"/></td>
						<td><c:if test="${!buttonMenu.delFlag}">有效</c:if><c:if test="${buttonMenu.delFlag}">无效</c:if></td>
					<td>
						<shiro:hasPermission name="mp:buttonMenu:edit">
							<a href="${ctx}/mp/buttonMenu/form?id=${buttonMenu.id}">修改</a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="pagination">${pageList}</div>
</body>
</html>

