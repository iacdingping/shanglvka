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
<title>积分查询</title>
</head>
<body>
	<header class="h40 lh40 bg1 w_center">
		<span id="header_title">积分查询</span>
		<div class="clear"></div>
	</header>
	<div class="container">
		<div class="pd_a_10 mg_a_10 f_l"
			style="background: #3C9; height: 100px; width: 50%">
			<div class="font_c_b1" style="font-size: 18px;">您的当前积分</div>
			<div class="wfull w_center "
				style="font-size: 45px; margin-top: 10px">12345</div>
		</div>
		<div class="f_l mg_t_10" style="width: 35%">
			<a href="">
				<div class="w_center"
					style="background: #0CF; height: 55px; width: 100%; line-height: 55px;">
					积分消费</div>
			</a>
		</div>
		<div class="f_l mg_t_10" style="width: 35%">
			<a href="">
				<div class="w_center"
					style="background: #399; height: 55px; width: 100%; line-height: 55px;">
					积分说明</div>
			</a>
		</div>
		<div class="clear"></div>
	</div>
	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
</body>
</html>

