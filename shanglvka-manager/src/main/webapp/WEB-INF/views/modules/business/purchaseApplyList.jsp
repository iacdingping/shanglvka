<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>申购单管理</title>
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
		<li class="active"><a href="${ctx}/business/purchaseApply/">申购单列表</a></li>
		<shiro:hasPermission name="business:purchaseApply:edit">
			<li><a href="${ctx}/business/purchaseApply/form">申购单添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="purchaseApply"
		action="${ctx}/business/purchaseApply/" method="post"
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
				<th>购卡金额</th>
				<th>购卡联系人</th>
				<th>购卡人电话</th>
				<th>购卡单位</th>
				<th>是否处理</th>
				<th>创建时间</th>
				<shiro:hasPermission name="business:purchaseApply:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="purchaseApply">
				<tr>
					<td>${purchaseApply.buyMoney}</td>
					<td>${purchaseApply.buyName}</td>
					<td>${purchaseApply.buyPhone}</td>
					<td>${purchaseApply.buyUnit}</td>
					<td>${purchaseApply.isTreat eq '1'?'已处理':'<font color="red">未处理</font>'}</td>
					<td><fmt:formatDate value="${purchaseApply.createTime}"
							type="both" /></td>
					<shiro:hasPermission name="business:purchaseApply:edit">
						<td><c:if test="${purchaseApply.isTreat eq '0'}">
								<a
									href="${ctx}/business/purchaseApply/form?id=${purchaseApply.id}">修改</a>
								<a
									href="${ctx}/business/purchaseApply/delete?id=${purchaseApply.id}"
									onclick="return confirmx('确认已处理该申购单吗？', this.href)">处理</a>
							</c:if></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
