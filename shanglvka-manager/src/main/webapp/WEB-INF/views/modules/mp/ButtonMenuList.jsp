<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>
<title>微信平台自定义菜单</title>
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
		<li class="active"><a href="${ctx}/mp/buttonMenu/">微信平台自定义菜单列表</a></li>
		<shiro:hasPermission name="mp:buttonMenu:view">
			<li><a href="${ctx}/mp/buttonMenu/form">微信平台自定义菜单添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form id="searchForm" modelAttribute="buttonMenu"
		action="${ctx}/mp/buttonMenu/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="page" type="hidden" value="${pageQuery.page}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${pageQuery.pageSize}" />
	</form>
	<div class="breadcrumb form-search">
		<div
			style="border-radius: 5px; background: blue; padding: 5px; width: 80px; text-align: center">
			<a
				href="http://${pageContext.request.serverName}/set-menu?appid=wxccded0129bb687f5&secret=1b9e58d0e7359db0f5187b9381f89932"
				target="_blank" style="color: #fff">菜单生成</a>
		</div>
	</div>

	<tags:message content="${message}" />
	<form id="listForm" method="post">
		<table id="treeTable"
			class="table table-striped table-bordered table-condensed">
			<tr>
				<th>父菜单</th>
				<th>菜单名称</th>
				<th>菜单属性</th>
				<th>属性值</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageList.items}" var="buttonMenu">
				<tr id="bl${buttonMenu.id}">
					<td><c:if test="${buttonMenu.parent==null}">顶级</c:if> <c:if
							test="${buttonMenu.parent!=null}">${buttonMenu.parent.name}</c:if></td>
					<th>${buttonMenu.name}</th>
					<td><c:if test="${buttonMenu.type=='click'}">关键字</c:if> <c:if
							test="${buttonMenu.type=='view'}">链接</c:if></td>
					<td>${buttonMenu.key}</td>

					<td><shiro:hasPermission name="mp:buttonMenu:edit">
							<a href="${ctx}/mp/buttonMenu/form?id=${buttonMenu.id}">修改</a>
							<a href="${ctx}/mp/buttonMenu/delete?id=${buttonMenu.id}"
								onclick="return confirmx('确认要删除该菜单及它的子类吗？', this.href)"> 删除</a>
						</shiro:hasPermission></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="pagination">${pageList}</div>
</body>
</html>

