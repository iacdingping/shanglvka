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
<script type="text/javascript"
	<script type="text/javascript" src="${ctx}/static/js/page-frame.js"></script>
	<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/common1/common.css" />
	<title>购卡助手</title>
<style type="text/css">
#purchaseApply_form label.error {
	padding-left: 16px;
	margin-left: 2px;
	font-size: 14px;
	color: red;
}
</style>
<style>
.form_list li {
	height: 35px;
	line-height: 35px;
	border-bottom: 1px solid #dedede;
	color: #4c4c4c
}

.form_list li input {
	margin-left: 20px;
	height: 25px;
	width: 40%;
}
</style>
<script>
	$(document).ready(function() {
		if ('${message}' != '') {
			alert('${message}');
		}
	});

	function submitFrom() {
		if ($("#buyMoney").val() == '' || isNaN($("#buyMoney").val())) {
			alert('请输入购卡金额');
		} else if ($("#buyName").val() == '') {
			alert('请输入购卡联系人');
		} else if ($("#buyPhone").val() == '') {
			alert('请输入购卡人电话');
		} else if ($("#buyUnit").val() == '') {
			alert('请输入购卡单位');
		} else {
			purchaseForm.action = '${ctx}/card/purchaseSave';
			purchaseForm.submit();
		}
	}
</script>
</head>
<body>
	<div style="padding: 30px 20px 10px 20px; background: #f5f5f5">
		<IMG src="${ctx}/static/img/bind01.jpg" width="100%" />
	</div>
	<div style="margin: 0px 10px;" class="form_list">
		<form id="purchaseForm" name="purchaseForm">
			<li>购卡金额&nbsp;&nbsp;&nbsp;<input type="text" id="buyMoney"
				name="buyMoney" placeholder="请输入购卡金额" /></li>
			<li>购卡联系人<input type="text" id="buyName" name="buyName"
				placeholder="请输入购卡联系" /></li>
			<li>购卡人电话<input type="text" id="buyPhone" name="buyPhone"
				placeholder="请输入购卡人电话" /></li>
			<li>购卡单位&nbsp;&nbsp;&nbsp;<input type="text" id="buyUnit"
				name="buyUnit" placeholder="请输入购卡单位" /></li> <br />
			<p style="font-size: 14px; color: #999">请您详细填写以上信息，以方便我们为您服务，谢谢您的支持</p>
			<br />
			<button type="button" onclick="submitFrom();" class="button"
				style="margin: 0px 10px; margin: auto; width: 100%;">确认</button>
		</form>
	</div>
	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
</body>
</html>