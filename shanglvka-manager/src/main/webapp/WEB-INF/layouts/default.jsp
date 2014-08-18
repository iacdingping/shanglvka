<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<title>后台管理<sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/static/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/static/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/static/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/static/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="${ctx}/static/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
	<link rel="shortcut icon" href="${ctx}/static/image/favicon.ico" />
<sitemesh:head />

</head>

<body class="page-header-fixed">
	<%@ include file="/WEB-INF/layouts/header.jsp"%>
	<div class="page-container row-fluid">
		<%@ include file="/WEB-INF/layouts/left.jsp"%>
		<div class="page-content">
			<sitemesh:body />
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
	<!-- END COPYRIGHT -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<script src="${ctx}/static/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="${ctx}/static/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="${ctx}/static/js/bootstrap.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
	<script src="${ctx}/static/js/excanvas.min.js"></script>
	<script src="${ctx}/static/js/respond.min.js"></script>  
	<![endif]-->   
	<script src="${ctx}/static/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="${ctx}/static/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/jquery.uniform.min.js" type="text/javascript" ></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="${ctx}/static/js/jquery.validate.min.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${ctx}/static/js/app.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/login.js" type="text/javascript"></script>      
	<!-- END PAGE LEVEL SCRIPTS --> 
	<script>
		jQuery(document).ready(function() {     
		  App.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script>
</body>
</html>