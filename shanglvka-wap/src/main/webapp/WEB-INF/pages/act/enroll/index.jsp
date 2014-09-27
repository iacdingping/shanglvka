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
<script type="text/javascript" src="${ctx}/static/js/common/validate/jquery.validate.method.js"></script>
<script type="text/javascript" src="${ctx}/static/js/common/validate/jquery.validate.method.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/common/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/common/validate/localization/messages_zh.js"></script>

<script type="text/javascript" src="${ctx}/static/js/plugins/My97DatePicker/calendar.js"></script>
<script type="text/javascript" src="${ctx}/static/js/plugins/My97DatePicker/WdatePicker.js"></script>


<link href="${ctx}/static/js/common/validate/jquery.validate.min.css" rel="stylesheet">
<!-- Loading Bootstrap -->
<link href="${ctx}/static/css/common/flat-ui/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI -->
<link href="${ctx}/static/css/common/flat-ui/flat-ui.css" rel="stylesheet">
<link href="${ctx}/static/css/common/flat-ui/demo.css" rel="stylesheet">
<title>活动报名</title>
</head>
<body>
	<div>
		<img
			src="http://afanti.huisou.com/Public/js/kindeditor/attached/21/image/20140425/20140425152024_93602.jpg"
			width="100%" '/>
	</div>
	<div style="min-width: 320px; padding: 10px;">
		<div style="min-width: 320px;">
			<p>
				<span class="fui-list-large-thumbnails"></span>&nbsp;&nbsp;<strong>活动说明</strong>
			</p>
			<p>
				商旅卡，作为城市的名片，将实现跨地区商业交流，结合具有代表性的商户，建立一卡
				通合作商圈，将为来杭宾客、民生消费、企事业单位福利、客情关系管理等建立完善的服务。<b>速来报名，参加活动！</b>
			</p>
			<hr>
			<p>
				<span class="fui-location"></span>&nbsp;&nbsp;<strong>地址：</strong><a
					href="http://map.baidu.com/mobile/webapp/place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=杭州市上城区国货路1号/?fromhash=1#place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=杭州市上城区国货路1号&vt=map">
					杭州市上城区国货路1号 &nbsp;&nbsp;&nbsp;&nbsp;<span class="fui-arrow-right"></span>
				</a>
			</p>
			<hr>
			<p>
				<span class="fui-volume"></span>&nbsp;&nbsp;<strong>电话：</strong> <a
					href="tel:0571-87250823">0571-87250823&nbsp;&nbsp;&nbsp;&nbsp;<span
					class="fui-arrow-right"></span></a>
			</p>
			<hr>
			<p>
				<span class="fui-new"></span>&nbsp;&nbsp;<strong>报名信息</strong>
			</p>
			<div>
				<form id="enroll_form" action="${ctx}/act/enroll/submit" method="post"  modelAttribute="enroll" name="enroll">
					联系人：<div class="controls"><input type="text" name="contact" value="" placeholder="您的称呼" class="form-control required"></div>
					联系电话：<div class="controls"><input type="text"  name="contactPhone" value="" placeholder="你的固定电话或手机 " class="form-control required"></div>
					预约日期：<div class="controls"><input id="enrollDateStr" name="enrollDateStr" type="text" readonly="readonly" class="input-small Wdate form-control required"
					value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" placeholder="选择您的日期" /></div>
					预约时间：<div class="controls"><input id="enrollTimeStr" name="enrollTimeStr" type="text" readonly="readonly" class="input-small Wdate form-control required"
					value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" placeholder="选择预约时间" /></div>
					备注：<textarea class="form-control" name="note" rows="3" placeholder="请输入备注信息"></textarea>
					<button type="submit" class="btn btn-primary"
						style="width: 100%; margin: auto; margin-top: 20px;">提交</button>
				</form>
			</div>
		</div>
	</div>
	<br />

	<footer>
		<div
			style="width: 100%; text-align: center; padding: 10px 0px; font-size: 14px;">
			杭州市商贸旅游集团版权所有<br /> 浙B2-20100257
		</div>
	</footer>
	
	<script type="text/javascript">
	
	$(document).ready(function() {
		if('${exists}' == 'true') {
			alert('该号码已经申请过');
		}
		if('${success}' == 'true') {
			alert('报名成功');
		}
		$("#enroll_form").validate();
	});
	</script>
</body>
</html>