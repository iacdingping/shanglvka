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
		<div class="floatL margin_L20 font_color_b bold font_size_16" style="line-height: 45px;">我这里是一个文章的标题</div>
		<div class="floatR" style="margin-top:5px;margin-right: 10px;">
			<div class="">
				<img src="${ctx}/static/img/info/icon01.png" width="85%" onclick="showClass()"/>
			</div>
		</div>
		</div>
	</header>
	
	<article class="conetnt limit_wth">
		<p class="sj2">习近平指出，第二届夏季青年奥运会今晚即将在南京拉开帷幕，青奥会是一项创新，把体育和文化教育结合起来，既是世界各国青少年的竞技场，又是他们沟通交流的平台，为广泛传播奥林匹克精神，引导年轻人思考正确的生活方式和生活态度，增进世界青年融合、友谊作出了贡献。中方非常重视南京青奥会筹备工作，从各方面给予了全力保障和大力支持，力争把青奥会办得精彩，办出中国特色。
		</p>
		<img src="${ctx}/static/img/common/ty01.jpg" align="middle" style="margin: auto;vertical-align:middle" width="96%"/>
		<p class="sj2">习近平强调，体育是社会发展和人类进步的重要标志，是综合国力和社会文明程度的重要体现，能为经济社会发展增添动力，凝聚力量。现代奥林匹克运动发展至今已有百余年历史，奥林匹克精神超越国界，在全世界深入人心。中方赞赏和支持国际奥委会推进改革，为推动奥林匹克运动、促进世界可持续发展作出的努力。北京市和张家口市是2022年冬奥会候选城市，中国政府和人民都希望在成功举办北京奥运会后办一届冬奥会，为奥林匹克运动作出新贡献。
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