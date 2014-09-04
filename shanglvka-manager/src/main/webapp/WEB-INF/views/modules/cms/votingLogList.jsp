<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>投票记录管理</title>
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
		<li class="active"><a href="${ctx}/cms/votingLog/">投票记录列表</a></li>
		<shiro:hasPermission name="cms:votingLog:edit">
			<li><a href="${ctx}/cms/votingLog/form">投票记录添加</a></li>
		</shiro:hasPermission>
	</ul>
	<tags:message content="${message}" />
	<h4>投票项：【${voting.title}】--<a href="javascript:void(0);" onclick="history.go(-1)">返回</a></h4>
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>预留电话</th>
				<th>投票时间</th>
		<tbody>
			<c:forEach items="${page.list}" var="votingLog">
				<tr>
					<td>${votingLog.phone}</td>
					<td>${votingLog.createTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
