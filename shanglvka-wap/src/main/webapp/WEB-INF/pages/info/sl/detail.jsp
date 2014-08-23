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
<body >
	<div>
		<article class="content_detail">
			<img src="${merchantMap.bgPic}" align="middle"
				style="margin: auto; vertical-align: middle" width="100%" />
			<div class="list border_bottom1">
				<span class="words07 margin_L20">预约电话：</span>
				<span class="words06">${merchantMap.phone}</span>
				<span class="floatR BTN01"><img src="${ctx}/static/img/info/icon04.png" height="20" align="left"/><a href="sms:057151231231">拨打电话</a></span>
			</div>
			<div class="list border_bottom1">
				<span class="words07 margin_L20">所在地区：</span>
				<span class="words06">${merchantMap.address}</span>
				<span class="floatR BTN02"><img src="${ctx}/static/img/info/icon06.png" height="20" align="left"/><a href="#">查看地图</a></span>
			</div>
			<div class="list border_bottom1"><span class="words07 margin_L20">折扣优惠：</span><span class="words06">${merchantMap.address}</span></div>
			<div class="list">
				<span class="words07 margin_L20">商户介绍：</span>
				<p class="sj2 words06 margin_L20 margin_R20">杭州宋城是中国人气最旺的主题公园，年游客逾600万人次，秉承“建筑为形，文化为魂”的经营理念。2014年，园区内的宋河东街、土豪家族、胭脂巷、非来巷、美食街、市井街六大主题街区华丽升级，热闹非凡；大宋博文化体验馆、七十二行老作坊等崭新亮相；高科技体验区失落古城、仙山佛窟区惊喜不断。
《宋城千古情》是杭州宋城的灵魂，同时园区内有《惊天烈焰》、《王员外家抛绣球》、《穿越快闪秀》、《大咖秀之南美争霸》、《岳飞点兵》、《风月美人》等十大演艺秀，给游客带来独特的游览体验。
				<br/>
				<br/>
				<br/>
				</p>
			</div>
		</article>
		<div class="font_color_l font_size_16 floatR" style="line-height:20px;">
		</div>
		<div class="clearboth"></div>
	</div>
</body>
</html>