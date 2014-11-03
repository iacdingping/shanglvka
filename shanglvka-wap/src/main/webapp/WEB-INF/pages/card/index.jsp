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
<title>${businessCard.name}</title>
<style>
.info_list li {
	width: 100%;
	color: #777777;
	line-height: 30px;
	margin-left: 28%;
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
</style>
</head>
<body>
	<div class="palette palette-peter-river"
		style="height: 100px; position: relative; margin-bottom: 10px; margin: 0 auto; width: 100%;">
		<div class="cycle_bk"></div>
		<img class="cycle_tu" style="margin: auto;"
			src="${businessCard.icoHeader}" />
	</div>
	<div style="text-align: center; width: 100%; color: #7b7979">
		<font color="#000000" size="6">${businessCard.name}</font>
		<div  style="margin-top: 10px;margin-bottom: 20px;"><font  color="#000000">${businessCard.job}</font></div>
	</div>
	<div class="line" style="background: #999999"></div>
	<div
		style="background: #e4e4e4; height: 200px; width: 100%; padding-top: 30px;"
		class="info_list">
		<li>手机：<a href="tel:${businessCard.phone}" style="color:#777777;">${businessCard.phone}</a></li>
		<br>
		<li>邮箱：${businessCard.mail}</li>
		<br>
		<li>地址： <a  style="color:#777777;"
			href="http://map.baidu.com/mobile/webapp/place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=${businessCard.address}/?fromhash=1#place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=${businessCard.address}&vt=map">
				${businessCard.address}</a></li>
	</div>


	<br />
	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
	<script type="text/javascript">
		$().ready(function() {
		});
	</script>
</body>
</html>

