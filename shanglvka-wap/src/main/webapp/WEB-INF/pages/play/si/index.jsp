<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>商旅卡-签到</title>
<meta name="description" content="商旅卡" />
<meta name="keywords" content="rent apartments, apartment rentals" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0" />
<meta name="format-detection" content="telephone=no" />
</head>
<body>
	<DIV id="mcover" style="display: none"
		onclick="document.getElementById('mcover').style.display='none';">
		<IMG id="blackImg">
	</DIV>
	<div>
		<form action="servlet/SignInInterfaceServlet" name="signInForm"
			style="height: 210px">
			<input type="hidden" name="agentId" value="null" />
			<div style="margin: 15px 0 20px 0">
				<div id="id_h1_presentYuan">

					<h1 align="center">首次使用送5元话费</h1>

				</div>
			</div>
			<div align="center">
				<input id="button_id_sign" class="ui-button ui-button-submit"
					type="button" onclick="signin()" value="点我签到领话费" />
			</div>
			<div id="tipMsg" style="margin: 10px 0 0 0;" align="center"></div>
			<div id="divInput" style="margin: 10px 0 10px 0; display: block"
				align="center">
				<div id="div_sign" style="font-size: 13px" align="center">
					第一次签到，请输入您的本机号码，领取话费<br />
				</div>
				<div class="ui-field-input" id="input_telNo"
					style="margin: 10px 0 0 0; width: 70%">
					<input name="telNo" id="telNo" value="" />
				</div>1
			</div>
		</form>
		<div
			style="border-top: 1px dashed #aaa; padding: 5px; margin-bottom: 50px;"
			id="div_tip_title">
			<p>
			<p>
			<h2 align="center" id="id_h2_head">欢迎拨打电话</h2>
			<table width="100%">
				<tr valign="top">
					<td><h3>
							<div id="a_id_otherDown" align="center">您可拨打国内任意固话或手机，通话过程不耗流量，只扣除您签到所得的话费。</div>
						</h3></td>
				</tr>
			</table>
		</div>
	</div>

	<style type="text/css">
ul,li {
	list-style: none;
	margin: 0;
	padding: 0
}

.top_bar {
	position: fixed;
	z-index: 900;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	font-family: Helvetica, Tahoma, Arial, Microsoft YaHei, sans-serif;
}

.top_menu {
	display: -webkit-box;
	border-top: 1px solid #aaa;
	display: block;
	width: 100%;
	background: rgba(255, 255, 255, 0.7);
	height: 55x;
	display: -webkit-box;
	display: box;
	margin: 0;
	padding: 0;
	-webkit-box-orient: horizontal;
	background: e5e3e3;
	box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.1) inset;
}

.ui-field-button button {
	height: 42px;
	width: 100%;
	text-align: center;
	font-size: 1.115em;
	line-height: 1;
	border-radius: 5px;
	border: solid 1px #ada1a1;
	background: -webkit-gradient(linear, 0 0, 0 100%, from(#e5e3e3),
		to(#b2b2b2), color-stop(60%, #b2b2b2));
}

.ui-field-help-button button {
	width: 44px;
	height: 44px;
	text-align: center;
	font-size: 1.115em;
	line-height: 1;
	border-radius: 22px;
	border: solid 1px #ada1a1;
	background: -webkit-gradient(linear, 0 0, 0 100%, from(#e5e3e3),
		to(#b2b2b2), color-stop(60%, #b2b2b2));
}

.ui-field-help-button button:active,.ui-field-button button:active {
	box-shadow: inset 0 3px 8px rgba(239, 117, 36, 0.4);
	-webkit-box-shadow: inset 0 3px 8px rgba(239, 117, 36, 0.4);
	-ms-box-shadow: inset 0 3px 8px rgba(239, 117, 36, 0.4);
}
</style>
	<script type="text/javascript">
		
	</script>
	<div class="top_bar" id="div_top_bar"
		style="-webkit-transform: translate3d(0, 0, 0)">
		<nav>
			<div id="top_menu" class="top_menu">
				<div
					style="padding: 5px 5px 5px 5px; width: 15%; text-align: center;"
					class="ui-field-help-button">
					<button onclick="helppage()">?</button>
				</div>
				<div style="padding: 5px 5px 5px 5px; width: 60%"
					class="ui-field-input">
					<input id="callNo" style="height: 44px; width: 100%; color: #999"
						value="输入被叫号码" onfocus="cls()" onblur="res()" />
				</div>
				<div style="padding: 6px 5px 5px 5px; width: 25%"
					class="ui-field-button">
					<button onclick="makecall()">呼叫</button>
				</div>
			</div>
		</nav>
	</div>

</body>
</html>