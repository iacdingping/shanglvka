<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib-activity.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

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

<div style="min-width:320px;display:none;" class="binddiv">
	<div style="width:100%; text-align: center; ">
	   <h6>首次签到，绑定手机领话费</h6>
	</div>
	<div class="form-group">
		<input type="tel" id="phone" value="" placeholder="请输入您的手机号" class="form-control" style="width:250px;margin: auto;" maxlength="11">
	</div>
</div>
<div style="min-width:320px;">
<div style="width:200px;margin: auto;margin-top:20px ">
		<a id="sign" href="javascript:void(0);" class="btn btn-block btn-lg btn-primary">签到</a>
	</div>
</div>	
<br/>

<footer>
	<div style="width:100%;text-align: center;padding:10px 0px;font-size:14px;">
		杭州市商贸旅游集团版权所有<br /> 浙B2-20100257
	</div>
</footer>
<script type="text/javascript">
	var bind = '${bind}' == 'true';
	$(document).ready(function() {
		if(!bind) {
			$('.binddiv').show();
			$('.sign').text('绑定并签到');
		}
		
		$('#sign').click(submit);
	});
	
	function submit() {
		if(bind) {
			location = '${ctx}' + '/act/sign/do';
		} else {
			var phone = $('#phone').val();
			if(/^1\d{10}$/.test(phone) == false) {
				console.log(phone);
				$('#phone').focus();
				alert('请输入正确的手机号码' + phone);
				return;
			}
			location = '${ctx}' + '/act/sign/do?mobile=' + phone;
		}
	}
</script>
</body>
</html>