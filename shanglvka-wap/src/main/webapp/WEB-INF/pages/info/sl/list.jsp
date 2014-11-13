<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib-activity.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<script type="text/javascript" src="${ctx}/static/js/common/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/page-frame.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/common1/common.css" />
<title>商旅列表</title>
<style>
.store_list .store {
	border-bottom: 1px solid #ccc;
	position: relative;
	width: 86%;
	margin: auto;
	margin-top: 20px;
	padding-bottom: 10px;
}

.store_list .store div {
	line-height: 33.3px;
	position: relative
}

.store_list .store div img {
	position: absolute;
	top: 5px;
}

.store_list .store div span {
	margin-left: 25px;
}

.store_list .store div.store_name {
	color: #0f63ae;
	font-size: 18px;
	width: 220px;
	white-space: nowrap;
	font-family: '黑体';
}

.store_list .store div.telephone,.store_list .store div.telephone a {
	color: #5c5c5c;
	font-size: 16px;
}

.store_list .store div.address,.store_list .store div.address a {
	color: #666666;
	font-size: 14px;
}

.store_list .store div.address {
	line-height: 28px;
	width: 95%;
}

.store_list .store .more {
	border-radius: 8px;
	position: absolute;
	top: 35px;
	right: 1px;
	padding: 0px 10px;
	border: 2px solid #0f63ae;
	color: #fff;
	font-size: 12px;
	height: 22px;
	line-height: 22px;
	background: #0056a2;
}
</style>
</head>

<body>
	<div style="display: none;">
		<img src="${ctx}/static/img/test02.jpg" width="100%" />
	</div>
	<div class="store_list">
		<!--一个循环元素-->
		<c:forEach var="item" items="${merchantMaps}" varStatus="merchantMap">
			<div class="store">
				<div class="store_name">${item.title}</div>
				<c:choose>
					<c:when  test="${not empty item.phone}">
						<div class="telephone">
							<img src="${ctx}/static/img/icons02.png" width="20" />
							<span><a href="tel:${item.phone}">${item.phone}</a></span>
						</div>
					</c:when>
					<c:otherwise>
						<div class="telephone">
							<img src="${ctx}/static/img/icons02.png" width="20" />
							<span><a href="javascript:void(0)" style="color:#ccc">暂无号码</a></span>
						</div>
					 </c:otherwise>
				</c:choose>
				<div class="address">
					<img src="${ctx}/static/img/icons03.png" width="16" /><span> <a
						href="http://map.baidu.com/mobile/webapp/search/search/qt=s&wd=${item.address}&c=179&searchFlag=bigBox&version=5&exptype=dep/vt=/?pagelets[]=pager&pagelets[]=page_data&t=697386">${item.address}</a>
					</span>
				</div>
				<a href="${ctx}/sl/detail/${item.id}">
					<div class="more">详情>></div>
				</a>
			</div>
		</c:forEach>
	</div>
	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
	<script>
		$().ready(function() {

		});
	</script>
</body>
</html>