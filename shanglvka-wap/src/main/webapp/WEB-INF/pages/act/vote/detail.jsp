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
<link rel="stylesheet" href="${ctx}/static/css/info/view.css" />
<title>详情页</title>
</head>
<body >
	<div class=" margin_T20 ">
		<header class="border_bottom1 padding-B10 content_area">
			<div class="title">房祖名有网友爆料演员柯震东吸毒</div>
			<div class="font_size_15 font_color_h2">2014-08-08 10:10</div>
		</header>
		<article class="conetnt limit_wth content_area">
			<img src="${ctx}/static/img/test/test10.gif" align="middle"
				style="margin: auto; vertical-align: middle" width="100%" class="margin_T10"/>
			<p class="sj2 margin_T10">8月18日晚，平安北京公布了房祖名涉毒一事的详情，据知，房祖名因涉嫌容留他人吸毒罪被刑拘，柯震东因吸毒被行拘，房祖名住所缴获大麻百余克。
平安北京称：“近日演员陈某某、柯某某等人因涉毒被拘留处理。”其中，“陈某”其实就是指房祖名（他别名为“陈祖名”）。在公布抓获细节上，平安北京透露：“8月初，北京市公安局禁毒总队通过群众举报获悉，一孙姓男子在京有涉毒嫌疑。经工作，禁毒总队会同东城分局于8月14日，在东城区将孙某(男，36岁，北京人，助理)，陈某某(男，32岁，香港人，演员，尿检呈大麻类阳性)、柯某某(男，23岁，台湾人，演员，尿检呈大麻类阳性)等多名步毒人员查获。
			</p>
			<p class="sj2">不过，事情峰回路转，昨天下午，有消息指柯震东吸毒情况属实，而房祖名也牵涉其中，并被爆不光涉毒，还牵涉刑事犯罪，再度引起舆论哗然。对此，有网友调侃道：“网络时代，人人都是爆料者。”而近日因为与新男友甜蜜互动的照片被曝光的萧亚轩也感叹现在的艺人没有隐私：“现在根本就是全民狗仔的时代！”本报记者
				黄岸</p>
			<br />
		</article>
		<div class="font_color_l font_size_16 line-height">
			<div class="border_bottom1" style="height:36px;">
				<div class="margin_L10 floatL"><img src="${ctx}/static/img/info/vote.gif"  style="width:20px;"/></div>
				<div class="margin_L10 floatL font_color_hei bold" style="line-height:35px;">投票</div>
			<div class="clearboth "></div>
			</div>
			<div class="margin_T20 ">
				<p class="font_color_hei margin_L20">柯震东吸毒被抓，您的第一反应是?</p>
				<p style="width:80%;margin: auto;margin-top: 10px;">
					<input type="radio" value="" name="vote_select"/>【震惊】希望好好改造<br/>
					<input type="radio" value="" name="vote_select" />【恍然】果真如此<br/>
					<input type="radio" value="" name="vote_select" />【质疑】房祖名呢？<br/>
					<input type="radio" value="" name="vote_select" />【吐槽】明天就出道三周年了<br/>
					<input type="radio" value="" name="vote_select" />【路过】不关心<br/>
				</p>
				<div class="BTN00 BTN08">投票</div>
			</div>
		</div>
	</div>
	<br />
	
	<div class="positionF black_layout touming displayN" id="touming_layout">
	</div>
	<div class="positionF textarea_layout displayN" id="textarea_layout">
		<div class="border_bottom1">
			<textarea rows="" cols="" placeholder="说点什么吧……"></textarea>
		</div>
		<p class="floatL" id="biaoqing">
			<img src="${ctx}/static/img/info/icon07.gif" width="30" class="BTN00" style="border:0px;"/>
		</p>
		<p class="floatR">
			<span class="BTN00 floatL BTN05">140</span>
			<span class="BTN00 floatL BTN04" id="cancel_command">取消</span> 
			<span class="BTN00 floatR BTN03">发表</span>
		</p>
		<div class="clearboth"></div>
		<div class="biaoqing_select displayN" id="biaoqing_select">
			<表情列表>
		</div>
	</div>

	<script type="text/javascript">
		$().ready(function(){
			$("#commandBTN").click(function(){
				$("#touming_layout").show();
				$("#textarea_layout").show();
			});
			$("#cancel_command").click(function(){
				$("#touming_layout").hide();
				$("#textarea_layout").hide();
			});
			$("#biaoqing").click(function(){
				$("#biaoqing_select").toggle();
				$("#textarea_layout").attr("top" , "")
			});
		});
	</script>
</body>
</html>