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
<title>商旅查询</title>
<style>
.list_right_border {
	background: url(${ctx}/static/img/cccbg.jpg) repeat-y right
}

.icons {
	background: url(${ctx}/static/img/icons.png)
}

.arrow_unselected {
	background-position: 0px 0px;
	width: 15px;
	height: 9px;
	display: block;
	position: absolute;
	top: 5px;
	right: -18px;
}

.arrow_selected {
	background-position: 0px -10px;
	width: 15px;
	height: 9px;
	display: block;
	position: absolute;
	top: 5px;
	right: -18px;
}

.class_unselected {
	background-position: -15px 0px;
	width: 16px;
	height: 14px;
	display: block;
	position: absolute;
	top: 5px;
	left: -18px;
}

.city_unselected {
	background-position: -30px 0px;
	width: 16px;
	height: 14px;
	display: block;
	position: absolute;
	top: 5px;
	left: -18px;
}

.tag_selector {
	width: 100%;
	height: 40px;
	line-height: 40px;
	background: #f5f5f5;
}

.tag_selector li {
	float: left;
	display: block;
	width: 50%;
	text-align: center;
	border-bottom: 1px solid #cccccc;
	font-size: 14px;
}

.tag_selector li.selected {
	font-weight: bold;
	color: #0f63ae;
	height: 40px;
}

.query_list {
	
}

.query_list li {
	width: 100%;
	margin: auto;
	border-bottom: 1px solid #e6e8e8;
	padding-bottom: 20px;
	padding-top: 20px;
}

.query_list li p {
	float: left;
	margin-left: 10px;
}

.query_list li p img {
	width: 80px;
	height: 80px;
	border: 1px solid #c7c7c7;
	padding: 2px;
	margin-right: 10px;
}

.query_list li span {
	
}

.query_list li span .title {
	font-size: 25px;
}

.query_list li span .introduce {
	color: #999898;
	font-size: 16px
}

.dropdown_content {
	position: fixed;
	z-index: 11;
	top: 42px;
	background: #f5f5f5;
	width: 100%;
	min-height: 300px;
}

.dropdown_content li {
	height: 40px;
	line-height: 40px;
	padding-left: 20px;
	border-bottom: 1px solid #e6e8e8;
}

.dropdown_content li.selected {
	background: #FFF;
	color: #0f63ae
}

#city_list .region_list {
	width: 35%;
	float: left;
}

#city_list .region_list li {
	width: 100%;
}

#city_list .region_list li span {
	color: #ccc;
	margin-left: 20px;
}

#city_list .region_detail_list {
	width: 65%;
	background: #FFF;
	float: left;
}

#city_list .region_detail_list li span {
	
}

#class_list .type_list {
	width: 35%;
	float: left;
}

#class_list .type_list li {
	width: 100%;
}

#class_list .type_list li span {
	color: #ccc;
	margin-left: 20px;
}

#class_list .type_detail_list {
	width: 65%;
	background: #FFF;
	float: left;
}

#class_list .type_detail_list li span {
	
}
</style>
</head>
<body>
	<div class="tag_selector">
		<li id="class" class="list_right_border"><span
			style="position: relative"> <span
				class="icons class_unselected"></span> 全部分类 <span
				class="icons arrow_unselected"></span>
		</span></li>
		<li id="city" class="list_right_border"><span
			style="position: relative">全城区域<span
				class="icons arrow_unselected"></span></span></li>
		<li id="order" class="selected" style="display: none;"><span
			style="position: relative">默认排序<span
				class="icons arrow_selected"></span></span></li>
		<div class="clear"></div>
	</div>
	<!--黑色透明层层-->
	<div id="black_layout"
		style="position: fixed; z-index: 10; background: #000; width: 100%; height: 100%; top: 42px; display: none;"
		class="tm80"></div>
	<!--下拉内容-->
	<div id="dropdown_area">
		<!--全部分类-->
		<div id="class_list" class="dropdown_content hide">
			<div class="type_list">
				<li id="type01" class="selected">类&nbsp;&nbsp;&nbsp;别 <span>&gt;</span></li>
				<li id="type02">西湖区 --<span>&gt;</span></li>
				<li id="type03">拱墅区-- <span>&gt;</span></li>
				<li id="type04">萧山区 --<span>&gt;</span></li>
			</div>
			<div class="type_detail_list">
				<div id="detail_type01" class="region_detail_list_items">
					<li class="selected">全部</li>
					<li>城厢</li>
					<li>北干</li>
					<li>市心北路</li>
					<li>市心北路</li>
					<li>市心北路</li>
					<li>市心北路</li>
					<li>市心北路</li>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<!--城市选择-->
		<div id="city_list" class="dropdown_content hide">
			<div class="region_list">
				<li id="region01" class="selected">全&nbsp;&nbsp;&nbsp;城 <span>&gt;</span></li>
				<c:forEach var="item" items="${areaList}" varStatus="area">
					<li id="region${item.id}">${item.name} <span>&gt;</span></li>
				</c:forEach>
			</div>
			<div class="region_detail_list">
				<div id="detail_region01" class="region_detail_list_items">
					<li class="selected">全部</li>
					<li>城厢</li>
					<li>北干</li>
					<li>市心北路</li>
					<li>市心北路</li>
					<li>市心北路</li>
					<li>市心北路</li>
					<li>市心北路</li>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<!--排序选择-->
		<div id="order_list" class="dropdown_content" style="display: none;">
			<li class="selected">默认排序</li>
			<li>离我最近</li>
			<li>评价最高</li>
			<li>价格最低</li>
		</div>
	</div>

	<div class="query_list">
		<c:forEach var="item" items="${merchantMaps}" varStatus="businessCard">
			<li>
				<p>
					<img src="${item.pic}" />
				</p> <span> <span class="title">${item.name}</span> <br /> <span
					class="introduce">${item.label}</span>
			</span>
				<div class="clear"></div>
			</li>
		</c:forEach>
	</div>

	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
	<script>
		$().ready(
				function() {
					//选择操作
					$(".tag_selector li").click(
							function() {
								$(this).addClass("selected").siblings()
										.removeClass("selected");
								$(this).siblings().find(".icons").removeClass(
										"arrow_selected").addClass(
										"arrow_unselected");
								var thisID = $(this).attr("id");
								//如果点击"全部分类"，就隐藏了，直接拉取所有店铺
								if ((thisID == "city" || thisID == "class")
										&& $("#" + thisID + "_list").is(
												":hidden")) {
									$(this).find(".icons").addClass(
											"arrow_selected");
									$("#" + thisID + "_list").show().siblings()
											.hide();
									$("#black_layout").show();
								} else {
									$(this).find(".icons").removeClass(
											"arrow_selected").addClass(
											"arrow_unselected");
									$("#" + thisID + "_list").hide().siblings()
											.hide();
									$("#black_layout").hide();
								}
							});

					//选择内容
					$("#dropdown_area").click(
							function(e) {
								$(e.target).addClass("selected").siblings()
										.removeClass("selected");
							});
					//类别选择
					$("#class_list .type_list li").click(function() {
						var thisID = $(this).attr("id");
						alert(thisID);
						$("#detail_" + thisID).show().siblings().hide();
					});

					//地区选择
					$("#city_list .region_list li").click(function() {
						var thisID = $(this).attr("id");
						$("#detail_" + thisID).show().siblings().hide();
					});
				});
	</script>
</body>
</html>