<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib-activity.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript"
	src="${ctx}/static/js/common/jquery.min.js"></script>
<!-- Loading Bootstrap -->
<link href="${ctx}/static/css/common/flat-ui/bootstrap.min.css"
	rel="stylesheet">
<!-- Loading Flat UI -->
<link href="${ctx}/static/css/common/flat-ui/flat-ui.css"
	rel="stylesheet">
<link href="${ctx}/static/css/common/flat-ui/demo.css" rel="stylesheet">
<title>抢. 购商旅卡</title>
<style type="text/css">
#new-li {
	background: #fff;
	padding: 10px 42px 15px 25px;
	border-bottom: 2px dashed #2980b9;
}

.todo ul {
	background-color: #fff;
}

</style>
</head>
<body>
	<div class="todo">
		<ul>
			<c:forEach var="item" items="${list}" varStatus="businessCard">
				<li class="todo-done " id="new-li">
				<a href="${ctx}/card/index?id=${item.id}">
					<div class="" style="float: left;position: relative;width: 90px; height: 90px;">
						<!-- <img src="${item.icoHeader}" id="touxiang"
							width="120"
							style="width: 80px; height: 80px; border-radius: 40px; left: 36%; top: 50px; border: 5px solid #2980B9;" />
							 -->
						<div style="position: absolute;width: 80px; height: 80px; border-radius: 40px; left: 10px; top: 5px; border: 5px solid #2980B9;z-index: 101">
						
						</div>
						<img src="${item.icoHeader}" id="touxiang"
							style="position: absolute;width: 70px; height: 70px; border-radius: 40px; left: 15px; top: 10px;z-index: 100" />
					</div>
					
							
					<div class="todo-content"
						style="color: #000; float: left; margin-left: 10px;">
						<h6 style="color: #000">${item.name}</h6>
						<span class="fui-user"></span>&nbsp;${item.job}
					</div>
					<div style="float: right; color: #2980b9; font-size: 25px;">
						<span class="fui-arrow-right" style="line-height: 80px"></span>
					</div>
					<div style="clear: both"></div></a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<br />
	<footer>
		<div
			style="width: 100%; text-align: center; padding: 10px 0px; font-size: 14px;">
			杭州市商贸旅游集团版权所有<br /> 浙B2-20100257
		</div>
	</footer>
	<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	<script type="text/javascript">
		$().ready(
				});
	</script>
</body>
</html>

