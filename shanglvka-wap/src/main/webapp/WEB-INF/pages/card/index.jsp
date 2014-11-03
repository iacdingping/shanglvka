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
	text-align: center;
	line-height: 30px;
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
		style="height: 100px; position: relative; margin-bottom: 10px;margin:0 auto; width:100%;">
		<div class="cycle_bk"></div>
		<img class="cycle_tu" style="margin: auto;" src="${businessCard.icoHeader}" />
	</div>
	<div style="text-align: center; width: 100%; color: #7b7979">
		<font>${businessCard.name}</font><br/><br/>
		<font>${businessCard.job}</font>
	</div>
	<div class="line" style="background: #999999"></div>
	<div
		style="background: #e4e4e4; height: 150px; width: 100%; padding-top: 30px;"
		class="info_list">
		<li>手机：<a href="tel:${businessCard.phone}">${businessCard.phone}</a></li>
		<li>邮箱：${businessCard.mail}</li>
		<li>地址： <a
			href="http://map.baidu.com/mobile/webapp/place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=${businessCard.address}/?fromhash=1#place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=${businessCard.address}&vt=map">
				${businessCard.address}</a></li>
	</div>


	<br />
	<footer style="margin-top: 40px;">
		<div style="text-align: center; width: 100%; color: #7b7979">杭州市商贸旅游集团商旅卡销售分公司</div>
	</footer>
	<script type="text/javascript">
		$().ready(function() {
		});
	</script>
</body>
</html>

