<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%request.setAttribute("kongge", "\n");
%>
<html>
<head>
<title>常见问题解答管理</title>
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
		<li class="active"><a href="${ctx}/business/questions/">常见问题解答列表</a></li>
		<shiro:hasPermission name="business:questions:edit">
			<li><a href="${ctx}/business/questions/form">常见问题解答添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="questions"
		action="${ctx}/business/questions/" method="post"
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
				<th>#</th>
				<th>问</th>
				<th>答</th>
				<shiro:hasPermission name="business:questions:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="questions"  varStatus="qu">
				<tr>
					<td>${qu.index+1}</td>
					<td>${questions.question}</td>
					<td>${fn:replace(questions.context,kongge,"<br>")}</td>
					<shiro:hasPermission name="business:questions:edit">
						<td><a
							href="${ctx}/business/questions/form?id=${questions.id}">修改</a> <a
							href="${ctx}/business/questions/delete?id=${questions.id}"
							onclick="return confirmx('确认要删除该常见问题解答吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
