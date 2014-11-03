<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>商旅品牌管理</title>
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
		<li class="active"><a href="${ctx}/business/merchantBrand/">商旅品牌列表</a></li>
		<shiro:hasPermission name="business:merchantBrand:edit">
			<li><a href="${ctx}/business/merchantBrand/form">商旅品牌添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="merchantBrand"
		action="${ctx}/business/merchantBrand/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<!--添加查询条件-->
	</form:form>
	<tags:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>品牌名称</th>
				<th>品牌图片</th>
				<th>简要描述</th>
				<shiro:hasPermission name="business:merchantBrand:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="merchantBrand">
				<tr>
					<td>${merchantBrand.name}</td>
					<td><img src="${merchantBrand.pic}" width="30px"></td>
					<td>${merchantBrand.label}</td>
					<shiro:hasPermission name="business:merchantBrand:edit">
						<td><a
							href="${ctx}/business/merchantBrand/form?id=${merchantBrand.id}">修改</a>
							<a
							href="${ctx}/business/merchantBrand/delete?id=${merchantBrand.id}"
							onclick="return confirmx('确认要删除该商旅品牌吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
