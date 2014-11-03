<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript"
	src="${ctx}/static/js/plugins/scrollAd.js"></script>
<link rel="stylesheet" href="${ctx}/static/css/common/common.css" />
<link rel="stylesheet" href="${ctx}/static/css/info/view.css" />
<title>文章列表</title>
</head>
<body>
	<div class="limit_wth">
		<div class=" positionR">
			<!--顶部轮播 -->
			<c:if test="${fn:length(topPage.list)>0 }">
				<div class="box">
					<ol></ol>
					<ul id="top_swipe_list">
						<c:forEach items="${topPage.list}" var="article"
							varStatus="status">
							<li class="active" style="left: 0; z-index: 11;"
								alt="${article.title}" title="${article.title}"><a
								href="${ctx}/info/view/detail/${article.id}"> <img
									src="${article.image}" align="middle"
									style="margin: auto; vertical-align: middle" width="100%" />
									<p class="positionA touming"
										style="bottom: 0px; height: 40px; width: 100%; background: #000; line-height: 40px; font-size: 16px">
										<span style="color: #fff; padding-left: 10px;">${fns:rabbr(article.title, 40)}</span>
									</p>
							</a></li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<div></div>
			<!-- /顶部轮播 -->
		</div>
		<div class="margin_T20">
			<ul>
				<c:forEach items="${notTopPage.list}" var="article">
					<li class=" padding-T10 border_bottom1 padding-B10"
						style="height: 70px; padding-left: 10px;" alt="${article.title}"
						title="${article.title}"><a
						href="${ctx}/info/view/detail/${article.id}"> <c:if
								test="${not empty article.image}">
								<img src="${article.image}" align="left"
									style="margin-right: 10px;" width="70" />
							</c:if>
							<p style="height: 30px;">
								<span class="font_size_17"
									style="color: #0b0c0e; font-weight: 700">${fns:rabbr(article.title, 24)}</span>
							</p>
							<p>
								<span class="font_size_15 font_color_h" style="color: #696969">${fns:rabbr(article.description, 60)}</span>
							</p>
					</a></li>
				</c:forEach>
			</ul>
			<br />
		</div>
	</div>
	<div class="textCenter displayN"
		style="height: 40px; line-height: 40px; background: #5f96c8; width: 94%; margin: auto;">
		<span style="color: #fff">查看更多</span>
	</div>
	<br />
	<footer class="footStyle" style="display: none">
		<div class="limit_wth"
			style="color: #fff; line-height: 60px; text-align: center;">
			<span style="font-size: 20px;">页脚</span>
		</div>
	</footer>
	<script type="text/javascript">
		$().ready(function() {
			var size = $("#top_swipe_list").find("li").size();
			$(".box ol a").css("width", (100 / size) + "%")
		});
	</script>
</body>
</html>