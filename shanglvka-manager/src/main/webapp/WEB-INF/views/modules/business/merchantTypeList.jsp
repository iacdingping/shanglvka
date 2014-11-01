<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>商旅类别管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#treeTable").treeTable({
			expandLevel : 5
		});
	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/business/merchantType/">商旅类别列表</a></li>
		<shiro:hasPermission name="business:merchantType:edit">
			<li><a href="${ctx}/business/merchantType/form">商旅类别添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="merchantType"
		action="${ctx}/business/merchantType/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<!--添加查询条件-->
	</form:form>
	<tags:message content="${message}" />
	<table id="treeTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>商旅类别名称</th>
				<shiro:hasPermission name="business:merchantType:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="merchantType">
				<tr id="${merchantType.id}"
					pId="${merchantType.parent.id ne requestScope.merchantType.id?merchantType.parent.id:'0'}">
					<td><a href="${ctx}/business/merchantType/form?id=${merchantType.id}">${merchantType.name}</a></td>
					<shiro:hasPermission name="business:merchantType:edit">
						<td><a
							href="${ctx}/business/merchantType/form?id=${merchantType.id}">修改</a>
							<a
							href="${ctx}/business/merchantType/delete?id=${merchantType.id}"
							onclick="return confirmx('确认要删除该商旅类别吗？', this.href)">删除</a> <a
							href="${ctx}/business/merchantType/form?parent.id=${merchantType.id}">添加下级类别</a>
						</td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
