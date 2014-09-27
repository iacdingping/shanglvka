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
<title>会员名片</title>
<style type="text/css">
#new-li{
	background: #fff;
	padding: 10px 42px 15px 25px;
	border-bottom:2px dashed #2980b9;
}
.todo ul{
	background-color: #fff;
}
</style>
</head>
<body>
	<div class="todo">
		<ul>
			<li class="todo-done " id="new-li">
				<div class="" style="float: left">
					<img src="${ctx}/static/img/test/touxiang01.png" id="touxiang" width="120"
						style=" width: 80px; height: 80px; border-radius: 40px; left: 36%; top: 50px; border: 5px solid #2980B9;" />
				</div>
				<div class="todo-content" style="color:#000;float: left;margin-left:10px;">
					<h6 style="color:#000">
						刘先生
					</h6>
					<span class="fui-user"></span>&nbsp;商旅集团客户经理
				</div>
				<div style="float: right;color:#2980b9;font-size:25px;"><span class="fui-arrow-right" style="line-height:80px"></span></div>
				<div style="clear:both"></div>
			</li>
			<li class="todo-done " id="new-li">
				<div class="" style="float: left">
					<img src="${ctx}/static/img/test/touxiang01.png" id="touxiang" width="120"
						style=" width: 80px; height: 80px; border-radius: 40px; left: 36%; top: 50px; border: 5px solid #2980B9;" />
				</div>
				<div class="todo-content" style="color:#000;float: left;margin-left:10px;">
					<h6 style="color:#000">
						王先生&nbsp;<img src="${ctx}/static/img/common/v.gif" style="width: 20px;" />
					</h6>
					<span class="fui-user"></span>&nbsp;商旅集团服务生
				</div>
				<div style="float: right;color:#2980b9;font-size:25px;"><span class="fui-arrow-right" style="line-height:80px"></span></div>
				<div style="clear:both"></div>
			</li>
			<li class="todo-done " id="new-li">
				<div class="" style="float: left">
					<img src="${ctx}/static/img/test/touxiang01.png" id="touxiang" width="120"
						style=" width: 80px; height: 80px; border-radius: 40px; left: 36%; top: 50px; border: 5px solid #2980B9;" />
				</div>
				<div class="todo-content" style="color:#000;float: left;margin-left:10px;">
					<h6 style="color:#000">
						好先生
					</h6>
					<span class="fui-user"></span>&nbsp;商旅集团客户经理
				</div>
				<div style="float: right;color:#2980b9;font-size:25px;"><span class="fui-arrow-right" style="line-height:80px"></span></div>
				<div style="clear:both"></div>
			</li>
		</ul>
	</div>
	<br />
	<footer>
		<div
			style="width: 100%; text-align: center; padding: 10px 0px; font-size: 14px;">
			商旅卡服务者<br /> 浙ICP备案号1234567
		</div>
	</footer>
	<script type="text/javascript">
		$().ready(
				});
	</script>
</body>
</html>

