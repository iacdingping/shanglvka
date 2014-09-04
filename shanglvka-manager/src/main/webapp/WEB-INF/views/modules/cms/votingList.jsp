<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>投票管理</title>
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
		<li class="active"><a href="${ctx}/cms/voting/">投票列表</a></li>
		<shiro:hasPermission name="cms:voting:edit"><li><a href="${ctx}/cms/voting/form">投票添加</a></li></shiro:hasPermission>
	</ul>
	
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
        <th>名称</th>
        <th>投票数</th>
		<shiro:hasPermission name="cms:voting:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="voting">
			<tr>
                 <td>${voting.title}</td>
                 <td>${voting.voteCount}</td>
				<shiro:hasPermission name="cms:voting:edit"><td>
    				<a href="${ctx}/cms/votingLog/?voting=${voting.id}">投票情况查看</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
