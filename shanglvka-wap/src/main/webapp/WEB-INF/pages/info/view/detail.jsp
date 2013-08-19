<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${ctx}/static/js/common/jquery.min.js"></script>
<link rel="stylesheet" href="${ctx}/static/css/common/common.css" />
<link rel="stylesheet" href="${ctx}/static/css/info/view.css" />
<title>详情页</title>
</head>
<body>
	<div style="background: #3696ba;border-bottom: 2px solid #4ea5c6;padding: 0px 0px;" class="displayN">
		<div class="limit_wth" >
			<ul style="padding: 10px 20px 0px 20px">
				<li class="button_class">最新活动</li>
				<li class="button_class">惊喜优惠</li>
				<li class="button_class">刷卡潮人</li>
				
				<li class="button_class">精彩回顾</li>
				<li class="button_class">积分攻略</li>
				<li class="button_class">扩展阅读</li>
			</ul>
		</div>
	</div>
	<header class="title">
		<div class="limit_wth">
		<div class="floatL margin_L20 font_color_b bold font_size_16" style="line-height: 45px;">房祖名涉毒被抓 恐涉刑事犯罪</div>
		<div class="floatR" style="margin-top:5px;margin-right: 10px;">
			<div class="">
				<img src="${ctx}/static/img/info/icon01.png" width="85%" onclick="showClass()"/>
			</div>
		</div>
		</div>
	</header>
	
	<article class="conetnt limit_wth">
		<p class="sj2">前晚,有网友爆料演员柯震东吸毒，一开始，柯震东的经纪人表示自己与柯震东父母都联络不到柯震东，同时对于“吸毒事件”没有直接否认，一时间让“柯震东吸毒”的消息在网上传得沸沸扬扬。随后，有网友表示该消息为假消息，最先发布该微博的网友“火华社队长豆豆”也在网上表示是误会，并删除原帖。
		</p>
		<img src="${ctx}/static/img/test/test03.gif" align="middle" style="margin: auto;vertical-align:middle" width="96%"/>
		<p class="sj2">不过，事情峰回路转，昨天下午，有消息指柯震东吸毒情况属实，而房祖名也牵涉其中，并被爆不光涉毒，还牵涉刑事犯罪，再度引起舆论哗然。对此，有网友调侃道：“网络时代，人人都是爆料者。”而近日因为与新男友甜蜜互动的照片被曝光的萧亚轩也感叹现在的艺人没有隐私：“现在根本就是全民狗仔的时代！”本报记者 黄岸
		</p>
		<br/>
		<div class="other_info margin_R20 margin_T20 limit_wth" style="font-weight: normal;">
		<p>2014-07-17 10点01分</p>
		<p class="margin_T5">
			<span class="font_size_16 bold">11</span>人浏览
			&nbsp;&nbsp;
			<span class="font_size_16 bold">22</span><span class="underline">赞</span>
		</p> 
	</div>
	</article>
	
	
	<br/>
	
	<hr style="width:95%" class="limit_wth"/>
	
	<div class="limit_wth" style="width: 90%">
		<div class="margin_T20" >
			<div  class="floatL">
			<img alt="评论" src="${ctx}/static/img/info/icon03.png">
			<span class="font_size_18" style="line-height: 10px;">123</span>
			</div>
			
			<div class="floatR underline">我也吐槽</div>
			<div class="clearboth"></div>
		</div>
		
		<div class="margin_T20">
			<ul>
				<li class="border_top1 padding-T10 margin_B10">
					<img src="${ctx}/static/img/common/default_touxiang.jpg"  align="left" style="margin: 0px 10px;"/>
					<p><span class="bold font_size_16">用户名1</span>&nbsp;&nbsp;<span class="font_color_h">9分钟前</span></p>
					<p>
						<span class="font_size_16">不好意思，沙发了</span>
					</p>
					<div class="clearboth"></div>
				</li>
				<li class="border_top1 padding-T10 margin_B10">
					<img src="${ctx}/static/img/common/default_touxiang.jpg"  align="left" style="margin: 0px 10px;"/>
					<p><span class="bold font_size_16">用户名3</span>&nbsp;&nbsp;<span class="font_color_h">9分钟前</span></p>
					<p>
						<span class="font_size_16">巴赫表示，国际奥委会致力于在全球推广奥林匹克精神，用体育促进世界和平和可持续发展，国际奥委会高度评价同中方的合作，赞赏中国重视发展体育事业，为国际奥林匹克运动作出的重要贡献。</span>
					</p>
					<div class="clearboth"></div>
				</li>
				<li class="border_top1 padding-T10 margin_B10">
					<img src="${ctx}/static/img/common/default_touxiang.jpg"  align="left" style="margin: 0px 10px;"/>
					<p><span class="bold font_size_16">用户名2</span>&nbsp;&nbsp;<span class="font_color_h">10小时前</span></p>
					<p>
						<span class="font_size_16">三楼</span>
					</p>
					<div class="clearboth"></div>
				</li>
				<li class="border_top1 padding-T10 margin_B10">
					<img src="${ctx}/static/img/common/default_touxiang.jpg"  align="left" style="margin: 0px 10px;"/>
					<p><span class="bold font_size_16">用户名4</span>&nbsp;&nbsp;<span class="font_color_h">2014/01/11</span></p>
					<p>
						<span class="font_size_16">4lou</span>
					</p>
					<div class="clearboth"></div>
				</li>
			</ul>
		</div>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<footer class="footStyle">
		<div class="limit_wth" style="color:#fff;line-height: 60px;text-align: center;">
			<span style="font-size: 20px;">页脚</span>
		</div>
	</footer>
	
	
	<script type="text/javascript">
			
	</script>
</body>
</html>