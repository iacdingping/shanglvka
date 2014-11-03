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
	src="${ctx}/static/js/common/validate/jquery.validate.method.js"></script>
<script type="text/javascript"
	src="${ctx}/static/js/common/validate/jquery.validate.method.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/js/common/validate/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/js/common/validate/localization/messages_zh.js"></script>
<script type="text/javascript" src="${ctx}/static/js/page-frame.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/common1/common.css" />
<title>查. MY商旅卡</title>
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
		if ('${success}' == 'true') {
			alert('提交信息成功，客服会在近期与您联系！');
		}
		$("#purchaseApply_form").validate();
	});
</script>
</head>
<body>
	<div style="padding: 30px 20px 10px 20px; background: #f5f5f5">
		<IMG src="${ctx}/static/img/bind01.jpg" width="100%" />
	</div>
	<div style="margin: 0px 10px;" class="form_list">
		<form id="purchaseApply_form" action="${ctx}/card/purchaseSave"
			method="post" modelAttribute="purchaseApply" name="purchaseApply">
			<li>购卡金额&nbsp;&nbsp;&nbsp;<input type="text" id="buyMoney"
				name="buyMoney" placeholder="请输入购卡金额" class="digits required" /></li>
			<li>购卡联系人<input type="text" id="buyName" name="buyName"
				placeholder="请输入购卡联系" class="form-control required" /></li>
			<li>购卡人电话<input type="text" id="buyPhone" name="buyPhone"
				placeholder="请输入购卡人电话" class="form-control required" /></li>
			<li>购卡单位&nbsp;&nbsp;&nbsp;<input type="text" id="buyUnit"
				name="buyUnit" placeholder="请输入购卡单位" class="form-control required"/></li>
			<br />
			<p style="font-size: 14px; color: #999">请您详细填写以上信息，以方便我们为您服务，谢谢您的支持</p>
			<br />
			<button type="submit" class="button"
				style="margin: 0px 10px; margin: auto; width: 100%;">确认</button>
		</form>
	</div>
	<footer style="margin-top: 40px;">
		<div style="text-align: center; width: 100%; color: #7b7979">杭州市商贸旅游集团商旅卡销售分公司</div>
		</foote>
</body>
</html>