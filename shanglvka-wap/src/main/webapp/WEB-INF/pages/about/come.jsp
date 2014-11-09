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
<title>商旅客服</title>
<link href="common.css" rel="stylesheet" type="text/css" />
<style>
.tag_selector {
	width: 100%;
	height: 40px;
	line-height: 40px;
	background: #f5f5f5
}

.tag_selector li {
	float: left;
	display: block;
	width: 50%;
	text-align: center;
	border-bottom: 1px solid #cccccc
}

.tag_selector li.selected {
	font-weight: bold;
	color: #0f63ae;
	border-bottom: 3px solid #0f63ae;
	height: 38px;
}
#faq_content{
	margin-top: 20px;
}
#faq_content div {
	padding: 10px 0px;
	width: 90%;
	margin: auto;
}

#faq_content div li {
	padding: 10px;
}

#faq_content div li p {
	font-size: 14px;
}

#faq_content li {
	color: #3e3e3e;
	font-size: 14px;
	height:40px;
	line-height: 40px;
}

#faq_content li p.a {
	color: #666666;
	line-height: 20px;
	font-size: 14px;
}

.contact_bg {
	background: url(${ctx}/static/img/contact_icon02.png) no-repeat;
	background-size:100%;
	display: block;
	width:25px;
	height:25px;
	float:left;
	margin-right:10px;
	margin-bottom:10px;
	
}
.bg01 {background-position: 0px 5px;}
.bg02 {background-position: 0px -40px;}
.bg03 {background-position: 0px -83px;}
.bg04 {background-position: 0px -119px;}
.bg05 {background-position: 0px -161px;}
.bg06 {background-position: 0px -203px;}
#contact_content li {
	line-height: 30px;
}
</style>
</head>

<body>
	<div class="tag_selector">
		<li id="faq" style=" background:url(${ctx}/static/img/cccbg.jpg) repeat-y right">常见问答</li>
		<li id="contact" class="selected">联系我们</li>
		<div class="clear"></div>
	</div>
	<div>
		<!--FAQ 内容-->
		<div id="faq_content" style="display: none">
			<br />
			<!--我的问题-->
			<c:forEach var="item" items="${myQuestions}" varStatus="questions">
				<div style="border-bottom: 1px dashed #ccc;">
					<li>
						<p class="q">
							<font color="red">我</font>:${item.question}
						</p> <c:if test="${empty item.context}">
							<p class="a">
								<font color="red">请稍等，客服正在解答……</font>
							</p>
						</c:if> <c:if test="${not empty item.context}">
							<p class="a">${item.context}</p>
						</c:if>
					</li>
				</div>
			</c:forEach>
			<!--常见问题-->
			<c:forEach var="item" items="${commonQuestions}"
				varStatus="questions">
				<div style="border-bottom: 1px dashed #ccc;">
					<li>
						<p class="q">Q:${item.question}</p>
						<p class="a">${item.context}</p>
					</li>
				</div>
			</c:forEach>
			<br />
			<div style="padding: 10px 0px; width: 90%; margin: auto;">
				<form id="question_form" action="${ctx}/about/questionSave"
					method="post" modelAttribute="question" name="question">
					<h3 style="margin: 10px;">商旅提问</h3>
					<textarea name="question" rows="5" cols="5"
						style="margin: 10px; width: 90%; border: 1px solid #ccc;" placeholder="提交您的问题" maxlength=""></textarea>
					<br />
					<button type="submit" class="button"
						style="margin: 0px 10px; margin: auto; width: 80%;">提交</button>
				</form>
			</div>
			<br />
		</div>
		<!--联系我们 内容-->
		<div id="contact_content" style="background: #f5f5f5;">
			<br /> <br />
			<div style="width: 100%;">
				<div style="width: 100%; margin: auto; text-align: center">
					<img src="${ctx}/static/img/logo.png" width="50%" />
				</div>
				<div style="margin-left: 20%; font-size: 16px;" id="faq_content">
					<li><span class="contact_bg bg01"></span><a
						href="tel:0571-28196999" style="color: #333333" target="_blank">客服电话：0571-28196999</a>
						<div class="clear"></div></li>
					<li><span class="contact_bg bg02"></span><a
						href="tel:0571-28206308" style="color: #333333" target="_blank">加盟热线：0571-28206308</a>
						<div class="clear"></div></li>
					<li><span class="contact_bg bg03"></span><a
						href="weixin://contacts/profile/MjM5MTE5MTE5Mg==" target="_blank" style="color: #333333">微&nbsp;&nbsp;信&nbsp;&nbsp;号：ctcard51</a>
						<div class="clear"></div></li>
					<li><span class="contact_bg bg04"></span><a
						href="http://www.51ctcard.com" style="color: #333333" target="_blank">官方网址：www.51ctcard.com</a>
						<div class="clear"></div></li>
					<li><span class="contact_bg bg05"></span><a
						href="http://weibo.com/u/3472602042/home?wvr=5&upfrom=v5"
						style="color: #333333" target="_blank">新浪微博：商旅卡CTCARD</a>
						<div class="clear"></div></li>
					<li><span class="contact_bg bg06"></span><a
						href="http://t.qq.com/HZshanglvka/profile?pgv_ref=im.aio.t&ptlang=2052"
						style="color: #333333" target="_blank">腾讯微博：商旅卡CTCARD</a>
						<div class="clear"></div></li>
				</div>
			</div>

		</div>

	</div>

	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
	<script>
		$().ready(function() {
			$(".tag_selector li").click(function() {
				$(this).addClass("selected");
				$(this).siblings().removeClass("selected");
				var thisID = $(this).attr("id");
				$("#" + thisID + "_content").show();
				$("#" + thisID + "_content").siblings().hide();
			});
			if ('${message}' != '') {
				alert('${message}');
			}
			$("#purchaseApply_form").validate();
		});
	</script>
</body>
</html>