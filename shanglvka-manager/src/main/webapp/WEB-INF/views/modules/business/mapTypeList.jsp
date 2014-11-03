<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>地图类别管理</title>
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
		<li class="active"><a href="${ctx}/business/mapType/">地图类别列表</a></li>
		<shiro:hasPermission name="business:mapType:edit"><li><a href="${ctx}/business/mapType/form">地图类别添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="mapType" action="${ctx}/business/mapType/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<!--添加查询条件-->
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
        <th>map_id</th>
		<shiro:hasPermission name="business:mapType:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="mapType">
			<tr>
                 <td>${mapType.mapId}</td>
				<shiro:hasPermission name="business:mapType:edit"><td>
    				<a href="${ctx}/business/mapType/form?id=${mapType.id}">修改</a>
					<a href="${ctx}/business/mapType/delete?id=${mapType.id}" onclick="return confirmx('确认要删除该地图类别吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
