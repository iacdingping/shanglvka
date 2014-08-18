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
<link rel="stylesheet"
	href="${ctx}/static/js/common/jquery.mobile-1.4.3.min.css" />
<script type="text/javascript"
	src="${ctx}/static/js/common/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/js/common/jquery.mobile-1.4.3.min.js"></script>
<title>详情页</title>
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h1>Page Title</h1>
			<a href="#"
				class="ui-btn-right ui-btn ui-btn-inline ui-mini ui-corner-all ui-btn-icon-right ui-icon-gear">Options</a>
		</div>
		<div data-role="content">
			在此，我只分享两个问题，为什么会有这样一份新协议的诞生？阿里和小微集团看似界限分明的背后又会有哪些隐患？ 马云与各大股东的博弈结果 <img
				src="http://f.hiphotos.baidu.com/news/w%3D638/sign=11d081f8f31f3a295ac8d6cda124bce3/a9d3fd1f4134970aadca300996cad1c8a7865d5e.jpg" />
			如果把即将上市的阿里巴巴集团理解为是马云一人独大的话，未免犯了“极端主义”的大错。
			事实上，大公司大企业的关系网络错综复杂，绝非局外人所能想象。毫无疑问的是，股东与股东、高层与高层之前的博弈无处不在。
			不过从目前阿里巴巴官方透露的消息来看，马云与各大股东之间的拉锯战暂时告一段落。几方各区所需，马云要的是权，大股东要权不成只能争取利益上的回报。此次，阿里终止了2011年各方达成的框架协议，就是很好的体现。新协议规定，从仅仅分享支付宝的利润扩大到后者的母公司小微金服，并且明文重申马云个人在小微金服的直接和间接持股比例，不会高于其在阿里集团所持有的比例。前者安抚了在“支付宝事件中”出局的软银、雅虎两大股东，给予了一定的利益补偿，后者表明，马云在大权在握之时主动或者被迫做出了妥协，自古鱼与熊掌不可兼得，相较于“钱财”，现任马云更钟情于“权利”。
		</div>
		<div data-role="footer">
			<h1>页脚文本</h1>
		</div>
	</div>
</body>
</html>