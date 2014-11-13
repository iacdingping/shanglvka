<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=8" />

<%@ page contentType="text/html;charset=UTF-8"%>
<script type="text/javascript"
	src="http://3g.k189.cn/static/js/common/jquery.min.js"></script>

<script>
	$().ready(function(e) {
		$("#show-btn").click(function() {
			$("#show-list").slideToggle();
		});
	});
</script>
<style>
#show-list ul li {
	list-style-type: none;
	line-height: 34px;
	height:34px;
	width:34px;
	text-align:center;
	background: #e9e8e9;
	border-radius: 30px;
	margin-bottom: 15px;
	color: #1ca9c0;
	box-shadow:2px 2px
             rgba(20%,20%,40%,0.5);
}
#show-list ul li:first-child {
  margin-left: 20px;
}
#show-list ul li a{
	padding-top: 5px;
	display: block;
}
</style>
<div style="text-align: center; width: 100%; color: #7b7979;margin-bottom: 16px;">杭州市商贸旅游集团·商旅卡</div>
<div style="position: fixed; right: 20px; bottom: 20px; cursor: pointer">
	<div style="width: 40px; height:40px;" id="show-btn">
		<img src="${ctx}/static/img/icons04.png" />
	</div>
	<div style=" position: absolute; left: -85px; top: -45px; display: none"
		id="show-list">
		<ul>
			<li>
				<a style="color: #1ca9c0" href="http://map.baidu.com/mobile/webapp/place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=杭州市上城区国货路1号/?fromhash=1#place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=杭州市上城区国货路1号&vt=map">
					<img src="${ctx}/static/img/icons03.png" style="width:20px;"></img>
				</a>
			</li>
			<li><a style="color: #1ca9c0" href="tel:0571-28196999">
				<img src="${ctx}/static/img/icons02.png" style="width:25px;"></img>
			</a></li>
		</ul>
	</div>
</div>