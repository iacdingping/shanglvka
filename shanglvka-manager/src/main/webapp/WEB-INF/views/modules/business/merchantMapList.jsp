<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>商旅地图管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {

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
		<li class="active"><a href="${ctx}/business/merchantMap/">商旅地图列表</a></li>
		<shiro:hasPermission name="business:merchantMap:edit">
			<li><a href="${ctx}/business/merchantMap/form">商旅地图添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="merchantMap"
		action="${ctx}/business/merchantMap/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<label>名称：</label>
		<input id="title" name="title" type="text" maxlength="50"
			class="input-small" value="${title}" />
		<!--添加查询条件-->
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit"
			value="查询" />
		<label></label>
		<a href="http://${pageContext.request.remoteHost}/sl/list/"  target="_blank">访问该模块地址</a>
	</form:form>
	<tags:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>简要说明</th>
				<th>地址</th>
				<th>联系电话</th>
				<th>优惠简介</th>
				<shiro:hasPermission name="business:merchantMap:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="merchantMap">
				<tr>
					<td>${merchantMap.title}</td>
					<td>${merchantMap.label}</td>
					<td>${merchantMap.address}</td>
					<td>${merchantMap.phone}</td>
					<td>${merchantMap.offer}</td>
					<shiro:hasPermission name="business:merchantMap:edit">
						<td><a
							href="http://${pageContext.request.remoteHost}/sl/detail/${merchantMap.id}"
							target="_blank">访问</a> <a
							href="${ctx}/business/merchantMap/form?id=${merchantMap.id}">修改</a>
							<a href="${ctx}/business/merchantMap/delete?id=${merchantMap.id}"
							onclick="return confirmx('确认要删除该商旅地图吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
