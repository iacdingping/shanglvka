<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>网站首页管理</title>
<meta name="decorator" content="default" />
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
		<li class="active"><a href="${ctx}/mp/wapHome/">网站首页列表</a></li>
		<shiro:hasPermission name="mp:wapHome:edit">
			<li><a href="${ctx}/mp/wapHome/form">网站首页添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form id="searchForm" modelAttribute="wapHome"
		action="${ctx}/mp/wapHome/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="page" type="hidden" value="${pageQuery.page}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${pageQuery.pageSize}"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form>
	<tags:message content="${message}" />
		<form id="listForm" method="post">
		<table id="treeTable" class="table table-striped table-bordered table-condensed">
			<tr><th>首页模块位置</th><th>标题</th><th>超链接</th><th>图片</th><th>排序</th><th>操作</th></tr>
			<c:forEach items="${pageList.items}" var="wapHome">
				<tr id="${wapHome.id}">
					<td>${fns:getDictLabel(wapHome.location, 'index_module', '未知')}</td>
					<td>${wapHome.title}</td>
					<td>${wapHome.link}</td>
					<td><img src="${wapHome.pic}" width="30px"> </td>
					<td>${wapHome.sort}</td>
					<td>
						<a href="${pageContext.request.contextPath}${fns:getFrontPath()}/list-${tpl.id}${fns:getUrlSuffix()}" target="_blank">访问</a>
						<shiro:hasPermission name="mp:wapHome:edit">
							<a href="${ctx}/mp/wapHome/form?id=${wapHome.id}">修改</a>
								<a href="${ctx}/mp/wapHome/delete?id=${wapHome.id}"
								onclick="return confirmx('确认要删除该网站首页吗？', this.href)">删除</a>
						</shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="pagination">${pageList}</div>
</body>
</html>
