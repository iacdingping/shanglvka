<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${ctx}/static/js/common/jquery.min.js"></script>
<link rel="stylesheet" href="${ctx}/static/css/common/common.css" />
<link rel="stylesheet" href="${ctx}/static/css/info/sl.css" />
<title>商旅列表</title>
</head>
<body>
	<div class="content_style">
		<ul>
			<c:forEach var="item" items="${merchantMaps}" varStatus="merchantMap">
				<li class="list_element"><a href="${ctx}/sl/detail/${item.id}"><img
					src="${item.smallPic}" />
					<div class="margin_T20">
						<span class="words05">${item.title}</span><br /> <span
							class="words06">${item.label}</span>
					</div>
					<div class="clearboth"></div></a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>