<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib-activity.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="${ctx}/static/js/common/jquery.min.js"></script>
<!-- Loading Bootstrap -->
<link href="${ctx}/static/css/common/flat-ui/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI -->
<link href="${ctx}/static/css/common/flat-ui/flat-ui.css" rel="stylesheet">
<link href="${ctx}/static/css/common/flat-ui/demo.css" rel="stylesheet">
<title>签到</title>
</head>
<body>
<div style="width:100%;text-align: center">
   <h6>首次签到，绑定手机领话费</h6>
</div>
<div style="min-width:320px;">
	<div class="form-group">
	            <input type="tel" value="" placeholder="请输入您的手机号" class="form-control" style="width:250px;margin: auto;" maxlength="11">
	</div>
	<div style="width:200px;margin: auto;">
		 <a href="" class="btn btn-block btn-lg btn-primary">绑定并签到</a>
	</div>
</div>
<br/>
<footer>
	<div style="width:100%;text-align: center;padding:10px 0px;font-size:14px;">
		商旅卡服务者<br/>
		浙ICP备案号1234567
	</div>
</footer>
</body>
</html>