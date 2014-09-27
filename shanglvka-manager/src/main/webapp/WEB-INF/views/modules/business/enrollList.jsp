<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商旅活动管理</title>
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
		<li class="active"><a href="${ctx}/business/enroll/">商旅活动列表</a></li>
		<!-- 
		<shiro:hasPermission name="business:enroll:edit"><li><a href="${ctx}/business/enroll/form">商旅活动添加</a></li></shiro:hasPermission>
		 -->
	</ul>
	<form:form id="searchForm" modelAttribute="enroll" action="${ctx}/business/enroll/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
        <th>联系人</th>
        <th>联系电话</th>
        <th>联系时间</th>
        <th>提交时间</th>
        <th>备注</th>
		<shiro:hasPermission name="business:enroll:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="enroll">
			<tr>
                 <td>${enroll.contact}</td>
                 <td>${enroll.contactPhone}</td>
                 <td>${enroll.enrollDate} ${enroll.enrollTime}</td>
                 <td>${enroll.createDate}</td>
                 <td>${enroll.note}</td>
                 <!-- 
				<shiro:hasPermission name="business:enroll:edit"><td>
    				<a href="${ctx}/business/enroll/form?id=${enroll.id}">修改</a>
					<a href="${ctx}/business/enroll/delete?id=${enroll.id}" onclick="return confirmx('确认要删除该商旅活动吗？', this.href)">删除</a>
				</td></shiro:hasPermission> -->
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
