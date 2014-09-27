<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商旅地图管理</title>
	<meta name="decorator" content="default"/>
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
		<li class="active"><a href="${ctx}/business/businessCard/">商旅名片列表</a></li>
		<shiro:hasPermission name="business:businessCard:edit"><li><a href="${ctx}/business/businessCard/form">商旅名片添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="businessCard" action="${ctx}/business/businessCard/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
        <th>名称</th>
        <th>电话</th>
        <th>邮箱</th>
		<shiro:hasPermission name="business:businessCard:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="businessCard">
			<tr>
                 <td>${businessCard.name}</td>
                 <td>${businessCard.phone}</td>
                 <td>${businessCard.mail}</td>
				<shiro:hasPermission name="business:businessCard:edit"><td>
    				<a href="${ctx}/business/businessCard/form?id=${businessCard.id}">修改</a>
					<a href="${ctx}/business/businessCard/delete?id=${businessCard.id}" onclick="return confirmx('确认要删除该商旅地图吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
