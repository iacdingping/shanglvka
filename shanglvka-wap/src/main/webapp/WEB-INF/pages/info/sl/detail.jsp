<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${ctx}/static/js/common/jquery.min.js"></script>
<link rel="stylesheet" href="${ctx}/static/css/common/common.css" />
<link rel="stylesheet" href="${ctx}/static/css/info/sl.css" />
<title>详情页</title>
</head>
<body>
	<div>
		<article class="content_detail">
			
			<div style="margin: auto; vertical-align: middle;z-index:1" class="positionR">
				<img src="${merchantMap.bgPic} " width="100%"/>
				<div style="left: 10%;z-index:2;top:30%" class="positionA">
					<span class="font_size_25 font_color_b">${merchantMap.title}</span>
					<hr style="border:1px solid #fff;"/>
					<span class="font_size_16 font_color_b">${merchantMap.address}</span>
				</div>
			</div>
			<div class="list border_bottom1">
				<span class="words07 margin_L20">预约电话：</span> <span class="words06">${merchantMap.phone}</span>
				<span class="floatR BTN01"><img
					src="${ctx}/static/img/info/icon04.png" height="20" align="left" /><a
					href="tel:${merchantMap.phone}">拨打电话</a></span>
			</div>
			<div class="list border_bottom1">
				<span class="words07 margin_L20">所在地区：</span> <span class="words06">${merchantMap.area.name}</span>
				<span class="floatR BTN02"><img
					src="${ctx}/static/img/info/icon06.png" height="20" align="left" /><a
					href="http://map.baidu.com/mobile/webapp/place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=${merchantMap.address}/?fromhash=1#place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=${merchantMap.address}&vt=map">查看地图</a></span>
			</div>
			<div class="list border_bottom1">
				<span class="words07 margin_L20">折扣优惠：</span><span class="words06">${merchantMap.offer}</span>
			</div>
			<div class="list">
				<span class="words07 margin_L20">商户介绍：</span>
				<p class="sj2 words06 margin_L20 margin_R20">${merchantMap.detail}
					<br /> <br /> <br />
				</p>
			</div>
		</article>
		<div class="font_color_l font_size_16 floatR"
			style="line-height: 20px;"></div>
		<div class="clearboth"></div>
	</div>
</body>
</html>