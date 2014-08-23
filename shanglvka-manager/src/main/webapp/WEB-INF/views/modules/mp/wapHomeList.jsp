<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>网站首页管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
		$(document).ready(function() {
			
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/mp/wapHome/">网站首页列表</a></li>
		<shiro:hasPermission name="mp:wapHome:edit">
			<li><a href="${ctx}/mp/wapHome/form">网站首页添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="wapHome"
		action="${ctx}/mp/wapHome/" method="post"
		class="breadcrumb form-search">
		<!--添加查询条件-->
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit"
			value="查询" />
	</form:form>
	<tags:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>location</th>
				<th>title</th>
				<th>link</th>
				<th>pic</th>
				<th>sort</th>
				<th>create_by</th>
				<th>create_date</th>
				<th>update_by</th>
				<th>update_date</th>
				<shiro:hasPermission name="mp:wapHome:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page}" var="wapHome">
				<tr>
					<td>${wapHome.location}</td>
					<td>${wapHome.title}</td>
					<td>${wapHome.link}</td>
					<td>${wapHome.pic}</td>
					<td>${wapHome.sort}</td>
					<td>${wapHome.createBy}</td>
					<td>${wapHome.createDate}</td>
					<td>${wapHome.updateBy}</td>
					<td>${wapHome.updateDate}</td>
					<shiro:hasPermission name="mp:wapHome:edit">
						<td><a href="${ctx}/mp/wapHome/form?id=${wapHome.id}">修改</a>
							<a href="${ctx}/mp/wapHome/delete?id=${wapHome.id}"
							onclick="return confirmx('确认要删除该网站首页吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
