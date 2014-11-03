<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>微信用户管理</title>
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
		<li class="active"><a href="${ctx}/mp/weixinUser/">微信用户列表</a></li>
	</ul>
	<form id="searchForm" modelAttribute="weixinUser"
		action="${ctx}/mp/weixinUser/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="page" type="hidden" value="${pageQuery.page}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${pageQuery.pageSize}" />
	</form>
	<tags:message content="${message}" />
	<form id="listForm" method="post">
		<table id="treeTable"
			class="table table-striped table-bordered table-condensed">
			<tr>
				<th>昵称</th>
				<th>状态</th>
				<th>电话</th>
				<th>省份</th>
				<th>城市</th>
				<th>用户属性</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageList.items}" var="weixinUser">
				<tr id="${weixinUser.id}">
					<td>${weixinUser.nickname}</td>
					<td>${weixinUser.type eq '1'?'关注用户':'取消关注'}</td>
					<td>${weixinUser.phone}</td>
					<td>${weixinUser.province}</td>
					<td>${weixinUser.city}</td>
					<td>${weixinUser.isStaff eq '1'?'内部员工':'普通用户'}</td>
					<td><a
						href="${ctx}/mp/weixinUser/setStaff?id=${weixinUser.id}"
						onclick="return confirmx('确认要${weixinUser.isStaff eq '1'?'取消':'设置'}该用户为内部员工吗？', this.href)">${weixinUser.isStaff eq '1'?'取消':'设置'}内部员工</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="pagination">${pageList}</div>
</body>
</html>
