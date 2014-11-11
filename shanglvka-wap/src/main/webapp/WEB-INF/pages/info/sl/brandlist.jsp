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
.search_bar {
	height: 40px;
	width: 100%;
	background: #3698bc;
	color: #fff;
}

.search_bar span {
	display: block;
	float: left;
}

.search_bar span input {
	width: 200px;
	padding-top: 5px;
	color: #000;
	height: 25px;
	font-size: 15px;
	background: #3698bc;
	color: #fff;
	font-family: '黑体';
	margin: 2px 10px 0px 10px;
}

.search_bar span img {
	margin-top: 8px;
	height: 25px;
}

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
	top: 2px;
	right: -18px;
}

.arrow_selected {
	background-position: 0px -10px;
	width: 15px;
	height: 9px;
	display: block;
	position: absolute;
	right: -18px;
}

.class_unselected {
	background-position: -15px 0px;
	width: 16px;
	height: 14px;
	display: block;
	position: absolute;
	top: 1px;
	left: -18px;
}

.city_unselected {
	background-position: -30px 0px;
	width: 16px;
	height: 14px;
	display: block;
	position: absolute;
	top: 1px;
	left: -18px;
}

.tag_selector {
	width: 100%;
	height: 40px;
	line-height: 40px;
	background: #fdfdff;
}

.tag_selector li {
	float: left;
	display: block;
	text-align: center;
	border-bottom: 1px solid #e9e8e6;
	font-size: 14px;
	color: #a9aaa1;
}

.tag_selector li.selected {
	font-weight: bold;
	color: #0f63ae;
	height: 40px;
}

/**店铺列表*/
.query_list li {
	width: 100%;
	margin: auto;
	border-bottom: 1px solid #e6e8e8;
	padding-bottom: 10px;
	padding-top: 10px;
}

.query_list li p {
	float: left;
	margin-left: 10px;
}

.query_list li p img {
	border-radius:5px;
	width: 95px;
	height: 85px;
	padding: 2px;
	margin-right: 10px;
}

.query_list li span {
	margin-top: 5px;
	display: block;
}

.query_list li span .title {
	font-size: 17px;
	color: #171819;
	font-family: "黑体";
	height:60px;
	overflow:hidden;
	line-height:20px;
}

.query_list li span .introduce {
	color: #999898;
	font-size: 13px;
}
/**--店铺列表*/

/**下拉内容*/
.dropdown_content {
	position: fixed;
	z-index: 11;
	top: 80px;
	background: #f5f5f5;
	width: 100%;
	min-height: 300px;
	border-top: 1px solid #e9e8e6;
}

.dropdown_content li {
	height: 40px;
	line-height: 40px;
	padding-left: 20px;
	border-bottom: 1px solid #e6e8e8;
	
}

.dropdown_content li.selected {
	background: #FFF;
	color: #0f63ae;
}

#city_list .region_list {
	width: 50%;
	float: left;
}

#city_list .region_list li {
}

#city_list .region_list li span {
	color: #ccc;
	padding-right:10px;
	float: right;
}

#city_list .region_detail_list {
	width: 50%;
	background: #eeeeee;
	float: left;
}

#city_list .region_detail_list li span {
	
}

#class_list .type_list {
	width: 50%;
	float: left;
	background: #f7f7f7;
}

#class_list .type_list li {
}

#class_list .type_list li span {
	color: #8d8d8f;
	padding-right:10px;
	float: right;
}

#class_list .type_detail_list {
	width: 50%;
	background: #eeeeee;
	float: left;
}
</style>
</head>
<body>
	<!-- 搜索条 -->
	<div id="search" class="search_bar">
		<span style="margin-left: 20px;"><img
			src="${ctx}/static/img/info/search_icon.jpg" /></span> <span><input
			id="keyword" class="keyword_input" placeholder="" value="全部商家" /></span> <span
			style="float: right; margin-right: 20px;"><img
			src="${ctx}/static/img/info/search_btn.jpg" /></span>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="tag_selector">
		<li id="class" class="list_right_border" style="width: 35%">
				<span style="position: relative"> 
					<span class="icons class_unselected"></span>
					<span id="class_txt">全部分类</span>
					<span class="icons arrow_unselected"></span>
				</span>
		</li>
		<li id="city" class="list_right_border" style="width: 65%"><span
			style="position: relative"><span id="city_txt">全城</span><span
				class="icons arrow_unselected"></span></span></li>
		<li id="order" class="selected" style="display: none;"><span
			style="position: relative">默认排序<span
				class="icons arrow_selected"></span></span></li>
		<div class="clear"></div>
	</div>
	<!--黑色透明层层-->
	<div id="black_layout"
		style="position: fixed; z-index: 10; background: #000; width: 100%; height: 100%; top: 80px; display: none;"
		class="tm80"></div>
	<!--下拉内容-->
	<div id="dropdown_area">
		<!--全部分类-->
		<div id="class_list" class="dropdown_content hide">
			<div class="type_list">
				<li id="type01">全部分类 <span>&gt;</span></li>
				<c:forEach var="item" items="${typeList}" varStatus="type">
					<li id="type${item.id}">${item.name}<span>&gt;</span></li>
				</c:forEach>
			</div>
			<div class="type_detail_list">
				<c:forEach var="item" items="${typeList}" varStatus="type">
					<div id="detail_type${item.id}" class="region_detail_list_items">
						<c:forEach var="child" items="${item.childList}">
							<li onclick="readType('${child.id}','${child.name}');">${child.name}</li>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
			<div class="clear"></div>
		</div>
		<!--城市选择-->
		<div id="city_list" class="dropdown_content hide">
			<div class="region_list">
				<li id="region01" class="selected">全城区域 <span>&gt;</span></li>
				<c:forEach var="item" items="${areaList}" varStatus="area">
					<li id="region${item.id}">${item.name}<span>&gt;</span></li>
				</c:forEach>
			</div>
			<div class="region_detail_list">
				<c:forEach var="item" items="${areaList}" varStatus="area">
					<div id="detail_region${item.id}" class="region_detail_list_items">
						<c:forEach var="child" items="${item.childList}">
							<li onclick="readRegion('${child.id}','${child.name}');">${child.name}</li>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
			<div class="clear"></div>
		</div>
		<!--排序选择
		<div id="order_list" class="dropdown_content" style="display: none;">
			<li class="selected">默认排序</li>
			<li>离我最近</li>
			<li>评价最高</li>
			<li>价格最低</li>
		</div>
		-->
	</div>

	<div class="query_list">
		<c:forEach var="item" items="${merchantBrands}">
			<a href="${ctx}/sl/addressList?brandId=${item.id}">
				<li>
					<p>
						<img src="${item.pic}" />
					</p> <span><span class="title">${item.name} </span> 
					<span
						class="introduce">${item.label} </span> </span>
					<div class="clear"></div>
			</li>
			</a>
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
								$(this).toggleClass("selected").siblings()
										.removeClass("selected");
								$(this).find(".icons").removeClass(
										"arrow_selected").addClass(
										"arrow_unselected");
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
									hideLayout(thisID);
								}
							});

					//选择内容
					$("#dropdown_area").click(
							function(e) {
								$(e.target).addClass("selected").siblings()
										.removeClass("selected");
							});
					//类别选择
					$("#class_list .type_list li").click(
							function() {
								var thisID = $(this).attr("id");
								if (thisID == 'type01') {
									hideLayout("class");
									readType('', '全部类别');
								} else if ($("#detail_" + thisID)
										.children("li").size() == 0) {
									hideLayout("class");
									readType(thisID.replace('type', ''),
											$(this).text().replace('>', ''));
								} else {
									$("#detail_" + thisID).show().siblings()
											.hide();
								}
							});
					//类别选择
					$("#class_list .type_detail_list div").click(function() {
						var thisID = $(this).attr("id");
						hideLayout("class");
					});

					//地区选择
					$("#city_list .region_list li").click(
							function() {
								var thisID = $(this).attr("id");
								if (thisID == 'region01') {
									hideLayout("city");
									readRegion('', '全城区域');
								} else if ($("#detail_" + thisID)
										.children("li").size() == 0) {
									hideLayout("city");
									readRegion(thisID.replace('region', ''), $(
											this).text().replace('>', ''));
								} else {
									$("#detail_" + thisID).show().siblings()
											.hide();
								}
							});

					//类别选择
					$("#city_list .region_detail_list div").click(function() {
						var thisID = $(this).attr("id");
						hideLayout("city");
					});

				});
		function hideLayout(thisID) {
			$(this).find(".icons").removeClass("arrow_selected").addClass(
					"arrow_unselected");
			$("#" + thisID + "_list").hide().siblings().hide();
			$("#black_layout").hide();
		}
		var classId = '';
		function readType(id, name) {
			this.classId = id;
			readList();
			$("#class_txt").text("");
			$("#class_txt").append(name);
		}
		var cityId = '';
		function readRegion(id, name) {
			this.cityId = id;
			readList();
			$("#city_txt").text("");
			$("#city_txt").append(name);
		}
		function readList() {
			$
					.ajax({
						type : "get", //请求方式
						url : "${ctx}/sl/getBrands", //请求路径
						cache : false, //(默认: true,dataType为script和jsonp时默认为false) jQuery 1.2 新功能，设置为 false 将不缓存此页面。
						data : {
							areaId : cityId,
							typeId : classId
						}, //传参
						//dataType : "html", //返回值类型       使用json的话也可以，但是需要在JS中编写迭代的html代码，如果格式样式
						success : function(data) {
							var divshow = $(".query_list");
							divshow.text("");// 清空数据
							var html = '';
							for ( var i = 0; i < data.length; i++) {
								html += '<a href="${ctx}/sl/addressList?brandId='
										+ data[i].id
										+ '"><li><p><img src="'+data[i].pic+'" /></p> <span> <span class="title">'
										+ data[i].name + '</span> <br />'
								html += '<span class="introduce">'
										+ data[i].label
										+ '</span></span><div class="clear"></div></li></a>'
							}
							if (data.length == 0) {
								html += '<div style="text-align: center; width: 100%; color: #7b7979;margin-bottom: 16px;margin-top: 20px;">暂无商旅</div>'
							}
							divshow.append(html);
						}
					});
		}
	</script>
</body>
</html>