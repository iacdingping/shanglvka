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
	line-height: 25px;
	height: 25px;
	background: #09C;
	border-radius: 5px;
	margin-bottom: 5px;
	padding: 0px 10px;
	color: #fff
}
</style>
<div style="position: fixed; right: 20px; bottom: 20px; cursor: pointer">
	<div
		style="color: #fff; font-size: 30px; font-weight: bold; width: 25px; height: 25px; border: 1px solid #09C; background: #09C; border-radius: 25px; text-align: center; line-height: 25px;"
		id="show-btn">+</div>
	<div
		style="display: none; position: absolute; left: -100px; top: -40px;"
		id="show-list">
		<ul>
			<li><a style="color: #fff"
				href="http://map.baidu.com/mobile/webapp/place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=杭州市上城区国货路1号/?fromhash=1#place/detail/qt=s&c=179&searchFlag=bigBox&version=5&exptype=dep/i=0&showall=1&detail_from=list&wd=杭州市上城区国货路1号&vt=map">地址</a></li>
			<li><a style="color: #fff" href="tel:0571-87250823">电话</a></li>
		</ul>
	</div>
</div>