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
<title>交易记录</title>
<style>
#item_list {
	width: 100%;
}

#item_list li {
	height: 60px;
	border-bottom: 1px solid #ccc;
	list-style: none;
	padding: 0px 10px;
}

#item_list li:nth-child(n+2) {
	margin-top: 10px;
}

#item_list li div:nth-child(1) div,#item_list li div:nth-child(1) img {
	width: 50px;
	height: 50PX;
}

#item_list li div.shanghu:nth-child(2) {
	width: 52%;
	height: 60px;
	overflow: hidden
}

#item_list li div.shanghu:nth-child(3) {
	width: 20%;
	height: 60px;
	overflow: hidden
}

.select_style {
	background:#fafdfe;  
    height:28px;  
    width:60px;  
    line-height:28px;  
    border:1px solid #9bc0dd;  
    border-radius:2px;  
    -webkit-appearance:none;
    appearance:none;
}
</style>
</head>
<body>
	<header class="h40 lh40 bg1 w_center">
		<span id="header_title">交易记录</span>
		<div class="clear"></div>
	</header>
	<div class="container">
		<div class="mg_b_10 font_c_white pd_l_10 w_center"
			style="background: #156bc3; height: 40px; line-height: 40px;">
			查询日期: <select class="select_style" name="year">
				<option value="2015">2015</option>
				<option value="2014">2014</option>
				<option value="2013">2013</option>
				<option value="2012">2012</option>
			</select> 年 <select class="select_style" name="year">
				<option value="01">01</option>
				<option value="02">02</option>
				<option value="03">03</option>
				<option value="04">04</option>
				<option value="05">05</option>
				<option value="06">06</option>
				<option value="07">07</option>
				<option value="08">08</option>
				<option value="09">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			 月 至今
		</div>
		<div id="item_list" class="mg_t_10">
			<li>
				<div class="f_l">
					<img src="${ctx}/static/img/index/icon05.png" />
				</div>
				<div class="f_l mg_l_10 shanghu">
					<div class="font_s_18 mg_t_05">外婆家</div>
					<div class="font_c_h1  mg_t_10">2015-01-01 12:12</div>
				</div>
				<div class="f_r mg_l_10">
					<div class="font_s_16 font_w_b mg_t_05 w_right">-234.00</div>
					<div class="font_c_h1 mg_t_10 w_right">在线交易</div>
				</div>
				<div class="clear"></div>
			</li>
			<li>
				<div class="f_l">
					<img src="${ctx}/static/img/index/icon01.png" />
				</div>
				<div class="f_l mg_l_10 shanghu">
					<div class="font_s_18 mg_t_05">京东商城</div>
					<div class="font_c_h1  mg_t_10">2015-01-01 12:12</div>
				</div>
				<div class="f_r mg_l_10">
					<div class="font_s_16 font_w_b mg_t_05 w_right h">-23224.00</div>
					<div class="font_c_h1 mg_t_10 w_right">消费撤销</div>
				</div>
				<div class="clear"></div>
			</li>
			<li>
				<div class="f_l">
					<img src="${ctx}/static/img/index/icon03.png" />
				</div>
				<div class="f_l mg_l_10 shanghu">
					<div class="font_s_18 mg_t_05">银泰城</div>
					<div class="font_c_h1  mg_t_10">2015-01-01 12:12</div>
				</div>
				<div class="f_r mg_l_10">
					<div class="font_s_16 font_w_b mg_t_05 w_right">-234.00</div>
					<div class="font_c_h1 mg_t_10 w_right">退货</div>
				</div>
				<div class="clear"></div>
			</li>
			<li>
				<div class="f_l">
					<img src="${ctx}/static/img/index/icon05.png" />
				</div>
				<div class="f_l mg_l_10 shanghu">
					<div class="font_s_18 mg_t_05">外婆家</div>
					<div class="font_c_h1  mg_t_10">2015-01-01 12:12</div>
				</div>
				<div class="f_r mg_l_10">
					<div class="font_s_16 font_w_b mg_t_05 w_right">-234.00</div>
					<div class="font_c_h1 mg_t_10 w_right">在线交易</div>
				</div>
				<div class="clear"></div>
			</li>
		</div>
		<div></div>
	</div>
	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>

	<script type="text/javascript">
		$().ready(function() {
			$("select").change(function(){
				var year = $("select:[name='year']");
				alert("a"+year);
			});
		});
	</script>
</body>
</html>

