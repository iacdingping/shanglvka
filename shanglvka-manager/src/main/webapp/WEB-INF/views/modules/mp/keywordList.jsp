<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>关键字管理</title>
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
		<li class="active"><a href="${ctx}/mp/keyword/">关键字列表</a></li>
		<shiro:hasPermission name="mp:keyword:edit"><li><a href="${ctx}/mp/keyword/form">关键字添加</a></li></shiro:hasPermission>
	</ul>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>ID</th>
				<th>关键字</th>
				<th>回复内容</th>
				<!--
				<th>图文标题</th>
				<th>图片</th>
				<th>链接地址</th>
				 -->
				<shiro:hasPermission name="mp:keyword:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.items}" var="keyword">
			<tr>
				<td>
					${keyword.id}
				</td>
				<td>
					${keyword.key}
				</td>
				<td>${keyword.unbindContent}</td>
				<!-- 
				<td>${keyword.title}</td>
				<td>${keyword.picture}</td>
				<td>${keyword.url}</td>
				 -->
				<shiro:hasPermission name="mp:keyword:edit"><th>
					<a href="${ctx}/mp/keyword/form?id=${keyword.id}">修改</a>
					&nbsp;
					<a href="${ctx}/mp/keyword/delete?id=${keyword.id}">删除</a>
				</th></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
