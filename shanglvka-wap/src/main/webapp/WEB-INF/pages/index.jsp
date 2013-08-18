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
<link rel="stylesheet" href="${ctx}/static/css/index/index.css" />
<title>详情页</title>
</head>
<body>
	<header class="">
		<img src="${ctx}/static/img/index/guangao_01.jpg" width="100%" />
	</header>
	<div class="limit_wth" style="width: 90%;">
		<ul class="margin_T20">
			<li class="styleAuto border_right"><span
				class="icon_list icon_list_1 "></span><span class="words01">新闻</span></li>
			<li class="styleAuto border_right"><span
				class="icon_list icon_list_3 "></span></span><span class="words01">视频</span></li>
			<li class="styleAuto"><span class="icon_list icon_list_2 "></span></span><span
				class="words01">文学</span></li>

			<li class="clearboth"></li>
			<li
				style="background: #d5d5d5; height: 1px; width: 100%; margin: 30px 0px;"></li>

			<li class="styleAuto  border_right"><span
				class="icon_list icon_list_4 "></span></span><span class="words02">活动专区</span></li>
			<li class="styleAuto  border_right"><span
				class="icon_list icon_list_5 "></span></span><span class="words02">积分商城</span></li>
			<li class="styleAuto"><span class="icon_list icon_list_6"></span></span><span
				class="words02">敬请期待</span></li>
			<li class="clearboth"></li>
		</ul>
	</div>
	<div  class="margin_T20" style="background: #f5f5f5">
		<ul>
			<li class=" padding-T10 border_bottom1 padding-B10 positionR">
				<img
				src="${ctx}/static/img/test/test01.gif" align="left"
				style="margin: 0px 10px;" width="60" />
				<p style="height: 43px;line-height: 40px;">
					<span class="words03">热点新闻</span>
				</p>
				<p>
					<span class="words04">
						柯震东在京被抓 | 雷军挑战冰桶
					</span>
				</p>
				<p class="floatR positionA" style="right: 15px;top:30px;">
					<img src="${ctx}/static/img/index/jiantou01.png" />
				</p>
			</li>
			<li class=" padding-T10 border_bottom1 padding-B10 positionR">
				<img
				src="${ctx}/static/img/test/test02.gif" align="left"
				style="margin: 0px 10px;" width="60" />
				<p style="height: 43px;line-height: 40px;">
					<span class="words03">商旅推荐</span>
				</p>
				<p>
					<span class="words04">
						乌镇水乡| 哈哈哈哈
					</span>
				</p>
				<p class="floatR positionA" style="right: 15px;top:30px;">
					<img src="${ctx}/static/img/index/jiantou01.png" />
				</p>
			</li>
		</ul>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>