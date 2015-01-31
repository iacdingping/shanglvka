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
<script type="text/javascript" src="${ctx}/static/js/user/yls-common.js" ></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/common1/common.css" />
<title>积分兑换</title>
<style>
#items_list li{display:block;color:#000; width:30%; height:80px; border:1px solid #000; float:left; margin-left:10px; margin-top: 10px;}
#items_list li{ text-align:center; line-height:80px}
#items_list li:nth-child(3n+1){margin-left:0px;}

.detail{position:fixed; z-index:10; top:75px;width:200px;background:#39C; height:220px; overflow:hidden;}
.detail_anima{-webkit-animation:1.0s detailSildeD forwards;animation:1.0s detailSildeD forwards;}
@-webkit-keyframes detailSildeD{from{height:0px;}	to{height:220px;}}
@keyframes detailSildeD{from{height:0px;}	to{height:220px;}}
</style>
</head>
<body>
	<header class="h40 lh40 bg1 w_center">
            <span id="header_title">积分兑换</span>
            <div class="clear"></div>
        </header> 
        <div class="container">
        	<div id="items_list" class=" pd_a_10">
            	<li>商品1</li>
                <li>商品2</li>
                <li>商品3</li>
                <li>商品4</li>
                <li>商品5</li>
                <li>商品6</li>
                <li>商品7</li>
                <div class="clear"></div>
            </div>
        </div>
    <div id="b_tk" class="b_tk toum"></div>
    <div id="detail" class="detail" style=" display:none; padding:10px;">
        <div  id="detail_content" style="height:190px;"></div>
        <div style="">
             <div class="w_center f_l" style="width:45%; height:30px; line-height:30px;border:1px solid #FFF;" onClick="closeTK()">再看看</div>
             <div class=" w_center f_l mg_l_10" style="width:45%; height:30px; line-height:30px;border:1px solid #FFF;">立即兑换</div>
         <div class="clear"></div>
        </div>
    </div>
	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
	  <script>
  $().ready(function(){
	var b_tk = $("#b_tk");
	var detail = $("#detail");
	var detail_left = ($(document).width()/2) - (detail.width()/2);
	detail.css("left",detail_left)
	$("#items_list li").click(function(){
		var currentIndex = $(this).index()+1;
		//b_tk.show();
		detail.show();
		b_tk.removeClass("_tk_show_slide_down");
		b_tk.addClass("tk_show_slide_down");
		detail.addClass("detail_anima");
		//加载内容
		$("#detail_content").html("我是商品"+currentIndex+"的详情");
		
	});  
  });
  </script>
</body>
</html>

