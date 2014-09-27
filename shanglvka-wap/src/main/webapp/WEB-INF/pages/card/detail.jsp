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
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/card/wei_webapp.css" />
<title>会员卡详情</title>
</head>
<body>
	<div id="">
		<div class="">
		<br/>
			<div class="card"
				style="margin:auto;background: url('http://imgcache.life.qq.com/www/misc/images/wei_webapp_new/card_bk_13.png') no-repeat 0 0; -webkit-background-size: 267px 159px; background-size: 267px 159px;">
				<img src="http://imgcache.life.qq.com/www/misc/images/weixin_shop_logo/1110765756_card_170_170.png?update=1385455493"
					class="logo">
				<h1 style=""></h1>
				<!--<h2>9639485</h2>-->
				<strong class="pdo verify" style="top:150px;position: absolute;left:45%">
						<span style="color: #a79d8d; text-shadow: 0 1px #f7f5f2;">
							<em style="color: #a79d8d; text-shadow: 0 1px #f7f5f2;">卡号</em>963 9485
						</span>
				</strong>
			</div>
			<p>
				<p>使用时向服务员出示此卡</p>
			</p>
			<ul class="round" id="customs2" style="display: none;">
			</ul>
			<ul class="round" id="privates">
				<li
					style=" -webkit-background-size: 24px 21px; background-size: 24px 21px;">
					<a class="balance" href="javascript:void(0)" data-ajax-act="6" ><span class="fui-tag"></span>&nbsp;预存余额:
						0元<span class="fui-arrow-right" style="float:right"</span></i>
				</a>
				</li>
				<li
					style=" -webkit-background-size: 24px 21px; background-size: 24px 21px;">
					<a class="score" href="javascript:void(0)" data-ajax-act="5"><span class="fui-document"></span>&nbsp;积分:
						100分<span class="fui-arrow-right" style="float:right"</span>
				</a>
				</li>
			</ul>
			<br/>
			<ul class="round" id="additional">
				<li><a class="record" href="javascript:void(0)" data-ajax-act="7"><span class="fui-windows"></span>&nbsp;交易记录<span class="fui-arrow-right" style="float:right"</span></a>
				</li>
				<li><a class="applicable" href="javascript:void(0)" data-ajax-act="9"><span class="fui-radio-checked"></span>&nbsp;适用门店电话及地址<span class="fui-arrow-right" style="float:right"</span></a>
				</li>
			</ul>
			<a href="javascript:void(0)" class="helpTel">使用会员卡遇到了问题？</a>
		</div>
		<div class="footFix" id="modal"></div>
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
				});
	</script>
</body>
</html>

