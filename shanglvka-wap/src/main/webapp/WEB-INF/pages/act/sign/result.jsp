<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib-activity.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="${ctx}/static/js/common/jquery.min.js"></script>
<!-- Loading Bootstrap -->
<link href="${ctx}/static/css/common/flat-ui/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI -->
<link href="${ctx}/static/css/common/flat-ui/flat-ui.css" rel="stylesheet">
<link href="${ctx}/static/css/common/flat-ui/demo.css" rel="stylesheet">
<title>签到</title>
</head>
<body>
<div style="min-width:320px;">
	<div style="width:220px;margin: auto;margin-top: 20px;">
		<span id="message">${message}</span>
	</div>
</div>
<br/>
<footer>
	<div style="width:100%;text-align: center;padding:10px 0px;font-size:14px;">
		杭州市商贸旅游集团版权所有<br /> 浙B2-20100257
	</div>
</footer>
</body>
</html>