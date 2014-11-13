<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib-activity.jsp"%>
<%
	request.setAttribute("kongge", "\n");
%>
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
<title>商户详情</title>
<style type="text/css">
.header_icon {
	background: url("${ctx}/static/img/info/icon07.png") no-repeat;
}

.icon01 {
	background-position: 10px -1px;
	width: 30px;
	height: 40px;
	background-size: 400%;
}

.icon02 {
	background-position: -35px -2px;
	width: 40px;
	height: 40px;
	background-size: 300%;
}

.icon03 {
	background-position: -75px -2px;
	width: 40px;
	height: 40px;
	background-size: 300%;
}

header span {
	display: block;
}

.contact_bg {
	background: url(${ctx}/static/img/contact_icon02.png) no-repeat;
	background-size: 100%;
	width: 25px;
	height: 35px;
}

.bg01 {
	background-position: 0px 13px;
}
</style>
</head>
<body>
	<header style="background: #f9fcfd; height: 40px;">
		<a href="javascript:history.go(-1);"><span
			class="header_icon icon01" style="float: left; margin-left: 10px;"></span></a>
		<a href="#"><span class="header_icon icon03"
			style="float: right; margin-right: 10px;"></span></a> <a href="#"><span
			class="header_icon icon02" style="float: right;"></span></a>
	</header>
	<div>
		<article class="content_detail">
			<!-- 顶部图片 -->
			<div style="margin: auto; vertical-align: middle; z-index: 1"
				class="positionR">
				<img src="${merchantMap.bgPic} " width="100%" height="195"
					style="border-bottom: 1px solid #dadbdc; border-top: 1px solid #dadbdc;" />
			</div>
			<!-- 优惠信息 和 电话 -->
			<div class="list border_bottom1 margin_T10"
				style="position: relative;">
				<span class="margin_L20"
					style="font-size: 35px; line-height: 45px; color: #ff6632; font-weight: bold; font-family: fantasy, '黑体'; width: 150px; display: block; float: left">
					${merchantMap.offer}</span>

				<c:if test="${not empty merchantMap.phone}">
					<span class="floatR BTN02"
						style="background: #0056a2; border-radius: 7px; right: 10px; bottom: 23%; position: absolute;">

						<a href="tel:${merchantMap.phone}">${merchantMap.phone}</a>
					</span>
					<span class="floatR contact_bg bg01"
						style="right: 145px; bottom: 23%; position: absolute;"></span>
				</c:if>
				<div class="cl"></div>
			</div>
			<!-- 店名 -->
			<div class="list border_bottom1">
				<span class="margin_L20 font_size_19 bold" style="color: #343434">${merchantMap.title}</span>
				<br /> <span class="margin_L20 font_size_15"
					style="color: #878787;"> <a
					href="http://map.baidu.com/mobile/webapp/search/search/qt=s&wd=${merchantMap.address}&c=179&searchFlag=bigBox&version=5&exptype=dep/vt=/?pagelets[]=pager&pagelets[]=page_data&t=697386">
					${fn:replace(merchantMap.address,kongge,"<br>")}
					</a>
				</span>
			</div>
			<!-- 优惠介绍 -->
			<div class="list border_bottom1" style="background: #f0f0f0">
				<p class="margin_L20 margin_R20 font_size_15"
					style="color: #5e5e5e; line-height: 20px;">${fn:replace(merchantMap.offerBrief,kongge,"<br>")}
				</p>
			</div>
			<!-- show more -->
			<div class="list border_bottom1">
				<c:if test="${brandCount>1}">
					<a
						href="${ctx}/sl/addressList?brandId=${merchantMap.merchantBrand.id}">
						<span class="margin_L20 font_size_15"
						style="color: #4c4c4c; font-family: '黑体'">查看全部${brandCount}家商户</span>
						<span class="floatR margin_R20 font_size_19"
						style="color: #b2b2b2">&gt;</span>
					</a>
				</c:if>

			</div>
			<!--  没用的就删掉吧
			<c:if test="${not empty item.phone}">
				<div class="list border_bottom1">
					<span class="words07 margin_L20">预约电话：</span> <span class="words06">${merchantMap.phone}</span>
					<span class="floatR BTN01"><img
						src="${ctx}/static/img/info/icon04.png" height="20" align="left" /><a
						href="tel:${merchantMap.phone}">拨打电话</a></span>
				</div>
			</c:if>
			 
			<div class="list border_bottom1">
				<span class="words07 margin_L20">所在地区：</span> <span class="words06">${merchantMap.area.name}</span>
				<span class="floatR BTN02"><img
					src="${ctx}/static/img/info/icon06.png" height="20" align="left" />
					<a
						href="http://map.baidu.com/mobile/webapp/index/index#search/search/qt=s&wd=${merchantMap.address}&c=179&searchFlag=bigBox&version=5&exptype=dep/vt=">${merchantMap.address}</a>
					</span>
			</div>
			<div class="list border_bottom1" style="padding:10px 0px;">
				<p class="words07 margin_L20" style="line-height: 25px;">折扣优惠：<span class="words06">${merchantMap.offer}</span></p>
			</div>
			-->
			<div class="list border_bottom1" style="background: #f0f0f0">
				<c:if test="${not empty merchantMap.detail}">
					<span class="words07 margin_L20" style="color: #5e5e5e;">商户介绍</span>
					<p class="words06 margin_R20 font_size_15"
						style="color: #5e5e5e; line-height: 20px; margin-left: 40px;">${fn:replace(merchantMap.detail,kongge,"<br>")}
						<br /> <br /> <br />
					</p>
					
				</c:if>
			</div>
		</article>
		<div class="font_color_l font_size_16 floatR"
			style="line-height: 20px;"></div>
		<div class="clearboth"></div>
	</div>
	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
</body>
</html>
