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
<script type="text/javascript"
	src="${ctx}/static/js/plugins/scrollAd.js"></script>
<link rel="stylesheet" href="${ctx}/static/css/common/common.css" />
<link rel="stylesheet" href="${ctx}/static/css/index/index.css" />
<title>商旅卡</title>
</head>
<body>
	<!--<header class="">
		<c:forEach items="${wapHomes1}" var="wapHome">
			<img src="${wapHome.pic}" width="100%" />
		</c:forEach>	
	</header> -->
	<!-- 轮播图片 -->
	<div class="box">
		<ol></ol>
		<ul>
			<c:forEach items="${wapHomes1}" var="wapHome">
				<li class="active" style="left: 0; z-index: 11;"><a
					href="${wapHome.link}"><img src="${wapHome.pic}" width="100%" /></a></li>
			</c:forEach>
		</ul>
	</div>
	<div class="limit_wth" style="width: 90%;">
		<ul class="margin_T20">
			<c:forEach items="${wapHomes2}" var="wapHome">
				<li class="styleAuto border_right"><a href="${wapHome.link}"><span
						class="icon_list "><img src="${wapHome.pic}" width="50"
							height="50" /></span> <br /> <span class="words01">${wapHome.title}</span></a></li>
			</c:forEach>
			<li class="clearboth"></li>
		</ul>
	</div>
	<div class="margin_T20" style="background: #f5f5f5">
		<ul>
			<c:forEach items="${wapHomes3}" var="wapHome">
				<li class=" padding-T10 border_bottom1 padding-B10 positionR"><a
					href="${wapHome.link}"><img src="${wapHome.pic}" align="left"
						style="margin: 0px 10px;" width="60" />
						<p style="height: 43px; line-height: 40px;">
							<span class="words03">${wapHome.title}</span>
						</p>
						<p>
							<span class="words04"> ${wapHome.desc} </span>
						</p>
						<p class="floatR positionA" style="right: 15px; top: 30px;">
							<img src="${ctx}/static/img/index/jiantou01.png" />
						</p></a></li>
			</c:forEach>
		</ul>
	</div>

	<script type="text/javascript">
		
	</script>
</body>
</html>