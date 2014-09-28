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
<title>抢. 购商旅卡</title>
<style type="text/css">
#service-list li {
	list-style: none;
	float: left;
	text-align: center;
	margin: 0px 5px;
	width: 60px;
	font-size: 14px;
}

#service-list li a span {
	font-size: 35px;
	color: #fdef09
}

#service-list li a {
	color: #fff99a
}
</style>
</head>
<body>
	<div class="palette palette-peter-river"
		style="height: 100px; position: relative; margin-bottom: 10px;">
		<p style="text-align: center; height: 25px; width: 100%">
			${businessCard.name}&nbsp;<img src="${ctx}/static/img/common/v.gif" style="width: 20px;" />
		</p>
		<div class="" style="float: left;position: absolute;;width: 100px; height: 100px;top:50px;" id="touxiang">
			<div style="position: absolute;width: 100px; height: 100px; border-radius: 50px; left: 10px; top: 5px; border: 5px solid #2980B9;z-index: 101">
			</div>
			<img src="${businessCard.icoHeader}" id="touxiang"
				style="position: absolute;width: 90px; height: 90px; border-radius: 50px; left: 15px; top: 10px;z-index: 100" />
		</div>
		<!--<div>
			<img src="${businessCard.icoHeader}" id="touxiang" width="120"
				style="position: absolute; width: 100px; height: 100px; border-radius: 50px; left: 36%; top: 50px; border: 5px solid #2980B9;" />
		</div>
		 -->
	</div>
	<div style="height: 50px; width: 100%"></div>
	<div style="position: relative; width: auto; font-size: 14px;" id="detail-info">
		<div>
			<span class="fui-user"></span>&nbsp;职位：${businessCard.job}
		</div>
		<div>
			<span class="fui-mic"></span>&nbsp;手机：<a href="tel:${businessCard.phone}">${businessCard.phone}</a>
		</div>
		<div>
			<span class="fui-mail"></span>&nbsp;&nbsp;邮箱：${businessCard.mail}
		</div>
		<div>
			<span class="fui-location"></span>&nbsp;地址：
			<a
					href="http://map.baidu.com/mobile/webapp/place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=${businessCard.address}/?fromhash=1#place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=${businessCard.address}&vt=map">
					${businessCard.address}</a>
		</div>
	</div>
	<div style="background: #6CF; margin-top: 20px; height: 100px;padding-top:10px">
		<ul id="service-list">
			<li><a href="${ctx}/">
					<div
						style="width: 60px; height: 60px; border: 2px solid yellow; border-radius: 50px; text-align: center; line-height: 64px;">
						<span class="fui-windows"></span>
					</div>商&nbsp;旅&nbsp;卡
			</a></li>
			<li><a href="">
					<div
						style="width: 60px; height: 60px; border: 2px solid yellow; border-radius: 50px; text-align: center; line-height: 60px;">
						<span class="fui-star-2"></span>
					</div>精彩活动
			</a></li>
			<li><a href="">
					<div
						style="width: 60px; height: 60px; border: 2px solid yellow; border-radius: 50px; text-align: center; line-height: 60px;">
						<span class="fui-cmd"></span>
					</div>商旅人脉
			</a></li>
			<li><a href="">
					<div
						style="width: 60px; height: 60px; border: 2px solid yellow; border-radius: 50px; text-align: center; line-height: 60px;">
						<span class="fui-exit"></span>
					</div>更多福利
			</a></li>
			
		</ul>
	</div>
	<br />
	<footer>
		<div
			style="width: 100%; text-align: center; padding: 10px 0px; font-size: 14px;">
			杭州市商贸旅游集团版权所有<br /> 浙B2-20100257
		</div>
	</footer>
	<script type="text/javascript">
		$().ready(
				function() {
					//头像居中 
					$("#touxiang").css("left", $(document).width() / 2 - 50);
					//详细信息居中
					$("#detail-info").css("width",
							$("#detail-info").width() / 2)
					$("#detail-info").css(
							"left",
							$(document).width() / 2
									- ($("#detail-info").width() / 2));
				});
	</script>
</body>
</html>

