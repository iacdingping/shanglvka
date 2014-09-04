<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
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
<body>
	<jsp:include page="/WEB-INF/pages/include/common.jsp"></jsp:include>
	<div class=" margin_T20 ">
		<header class="border_bottom1 padding-B10 content_area">
			<div class="title">${viewData.title}</div>
			<div class="font_size_15 font_color_h2"><fmt:formatDate value="${viewData.createDate}" pattern="yyyy年MM月dd日  HH:mm:ss"/></div>
		</header>
		<article class="conetnt limit_wth content_area">
			<p class="sj2 margin_T10">
				${fns:unescapeHtml(viewData.articleData.content)}
			</p>
			<br />
		</article>
		<div class="font_color_l font_size_16 floatR displayN" style="line-height:20px;margin-right: 10px;">
			<img src="${ctx}/static/img/info/recommend.gif"  style="width:20px;height:20px; " align="left"/>
			&nbsp;<span id="commandBTN">评论</span>
			&nbsp;<span class="font_color_h2">(${commends.count})</span>
		</div>
		<div class="clearboth"></div>
	</div>
		<div class="border_bottom1 margin_B10 margin_T10 positionR displayN">
			<div class="positionA" style="right:70px;top:-11px;">
				<img src="${ctx}/static/img/info/icon05.gif" height="10"/>
			</div>		
		</div>
		<div class="content_area">
		
			<ul>
				<c:forEach items="${commends.list}" var="commend">
				
				<li class="border_bottom1 padding-B10 margin_B10"><img
					src="${ctx}/static/img/common/default_touxiang.jpg" align="left"
					style="margin: 0px 10px;" />
					<p class="margin_B5">
						<span class=" font_color_h font_size_16">${commend.name}</span>
						<span class=1"font_size_14 font_color_h floatR"><fmt:formatDate value="${commend.createDate}" pattern="yyyy-MM-dd HH:mm"/></span>
					</p>
					<p>
						<span class="font_size_15 font_color_hei">${commend.content}</span>
					</p>
					<div class="clearboth"></div></li>
				</c:forEach>
			</ul>
		</div>
	<br />
	<br />
	<br />
	<br />
	<div class="positionF black_layout touming displayN" id="touming_layout">
	</div>
	<div class="positionF textarea_layout displayN" id="textarea_layout">
		<div class="border_bottom1">
			<textarea rows="" cols="" placeholder="说点什么吧……"></textarea>
		</div>
		<p class="floatL displayN" id="biaoqing">
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