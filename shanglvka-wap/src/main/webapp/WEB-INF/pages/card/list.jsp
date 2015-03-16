<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib-activity.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<script type="text/javascript"
	src="${ctx}/static/js/common/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/page-frame.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/common1/common.css" />
<link href="common.css" rel="stylesheet" type="text/css" />
<title>购卡助手</title>
<style>
.line {
	border-bottom: 1px solid #ccc;
	background: none;
	margin-left: 20px;
}

.cycle_bk {
	position: absolute;
	width: 80px;
	height: 80px;
	border-radius: 50px;
	top: 5px;
	border: 2px solid #000;
	z-index: 101
}

.cycle_tu {
	position: absolute;
	width: 80px;
	height: 80px;
	border-radius: 50px;
	left: 2px;
	top: 7px;
	z-index: 100
}

.title_style {
	float: left;
	margin-left: 110px;
	margin-top: 25px;
}

.arror_style {
	font-size: 25px;
	color: #999;
	float: right;
	line-height: 100px;
	padding-right: 20px;
}
</style>
</head>

<body>

	<div>
		<!--循环元素-->
		<c:forEach var="item" items="${list}" varStatus="businessCard">
			<a href="${ctx}/card/index?id=${item.id}">
				<div class="line" style="position: relative; height: 100px;"
					id="touxiang">
					<div class="cycle_bk"></div>
					<img class="cycle_tu" src="${item.icoHeader}" />
					<div class="title_style">
						<span style="color: #000; font-size: 24px;"><b>${item.name}</b><br />
							<span style="color: #ccc; font-size: 16px;">${item.job}</span>
					</div>
					<div class="arror_style">&gt;</div>
					<div class="clear"></div>
				</div>
			</a>
		</c:forEach>
	</div>

	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
	<script>
		$().ready(function() {

		});
	</script>
</body>
</html>

