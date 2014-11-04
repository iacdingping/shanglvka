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
<title>商旅列表</title>
<style>
.store_list .store {
	height: 100px;
	border-bottom: 1px solid #ccc;
	position: relative;
	width: 90%;
	margin: auto;
	margin-top: 10px;
	padding-bottom: 10px;
}

.store_list .store div {
	line-height: 33.3px;
	height: 33.3px;
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
	font-size: 16px;
	font-weight: bold;
}

.store_list .store div.telephone {
	color: #666666;
	font-size: 18px;
}

.store_list .store div.address {
	color: #666666;
	font-size: 14px;
}

.store_list .store .more {
	border-radius: 8px;
	position: absolute;
	top: 2px;
	right: 1px;
	padding: 0px 10px;
	border: 2px solid #0f63ae;
	color: #0f63ae;
	font-size: 16px;
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
				<c:if test="${not empty item.phone}">
					<div class="telephone">
						<img src="${ctx}/static/img/icons02.png" width="15" /><span><a
							href="tel:${item.phone}">${item.phone}</a></span>
					</div>
				</c:if>
				<div class="address">
					<img src="${ctx}/static/img/icons03.png" width="16" /><span>
						<a
						href="http://map.baidu.com/mobile/webapp/place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=${item.address}/?fromhash=1#place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=${item.address}&vt=map">${item.address}</a>
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