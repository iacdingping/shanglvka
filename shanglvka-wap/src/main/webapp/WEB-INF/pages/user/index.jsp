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
<title>个人中心</title>
<style>
.info_list li {
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
	border: 2px solid #6c6c6c;
	z-index: 101
}

.cycle_tu {
	position: absolute;
	width: 80px;
	height: 80px;
	border-radius: 50px;
	left: 2px;
	top: 7px;
	z-index: 100;
}
#item_list li,#item_list a{ height:70px;display: block;} 
#item_list li{width: 48%;float: left;font-size:20px; text-align: center;line-height: 70px;}
#item_list li:nth-child(2n){margin-left:10px;}
#item_list li:nth-child(n+3){margin-top:10px;}
</style>
<script type="text/javascript">
		$().ready(function() {
			$("#touxiang div").css("left" , ($(window).width()/2-45));
			$("#touxiang img").css("left" , ($(window).width()/2-45));
		});
</script>
</head>
<body>

	<header class="h40 lh40 bg1 w_center">
        <span id="header_title">个人中心</span>
        <div class="clear"></div>
    </header>
	<div style="height: 100px; position: relative; margin-bottom: 10px; margin: 0 auto; width: 100%;" id="touxiang">
		<div class="cycle_bk"></div>
		<img class="cycle_tu" style="margin: auto;" src="${businessCard.icoHeader}" alt="头像"/>
	</div>
	<div style="text-align: center; width: 100%; color: #7b7979">
		<font color="#000000" size="5"><b>叶文渠</b></font>
		<div  style="margin-top: 10px;margin-bottom: 20px;"><font  color="#000000">厉害的人</font></div>
	</div>
	<div class="line" style="background: #999999"></div>
	<div class="mg_t_10 mg_l_10">
		<div id="item_list" style="margin: auto;width:96%;">
			<li style="background:#01cf45"><a href="${ctx}/uc/yecx">余额查询</a></li>
			<li style="background:#6a74f8"><a href="${ctx}/uc/jyjl">交易记录</a></li>
			<li style="background:#0ec3ce"><a href="${ctx}/uc/jfcx">积分查询</a></li>
			<li style="background:#d2f339"><a href="${ctx}/uc/jfdh">积分兑换</a></li>
			<div class="clear"></div>
		</div>
	</div>
	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
</body>
</html>

