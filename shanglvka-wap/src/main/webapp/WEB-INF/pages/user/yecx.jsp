<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib-activity.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<script type="text/javascript"
	src="${ctx}/static/js/common/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/page-frame.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/common1/common.css" />
<title>余额查询</title>
</head>
<body>
    	<header class="h40 lh40 bg1 w_center">
            <span id="header_title">余额查询</span>
            <div class="clear"></div>
        </header> 
        <div class="container">
        	<div class="mg_nb_10" style=" background:#093;height:35px; line-height:35px; font-size:20px">
            	<span class="pd_a_10">
                    <span style="font-size:14px;">您的卡号：</span><span>123456567787</span>
                </span>
            </div>
           <!-- <div class="mg_nt_10">-->
                <div class="pd_a_10 mg_a_10 f_l" style=" background:#3C9;height:100px;width:50%">
                    <div class="" style=" font-size:14px;height:25px;">当前余额</div>
                    <div class="wfull w_center">
                        <span class="font_c_b1" style="font-size:40px; margin-top:10px">12345</span><br/>
                        <span style=" font-size:11px; color:#F30">(失效日期：2015年12月30日)</span>
                        
                    </div>
                </div>
                <div class="f_l mg_t_10" style="width:34.5%">
                    <a href="">
                        <div class="w_center" style=" background:#0CF;height:55px; width:100%; line-height:55px;">
                        交易记录</div>
                    </a>
                </div>
                <div class="f_l mg_t_10" style="width:34.5%">
                    <a href="">
                        <div class="w_center" style=" background:#399;height:55px; width:100%; line-height:55px;">
                        使用说明</div>
                    </a>
                </div>
                <div class="clear"></div>
            <!--</div>-->
        </div>
	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
</body>
</html>

