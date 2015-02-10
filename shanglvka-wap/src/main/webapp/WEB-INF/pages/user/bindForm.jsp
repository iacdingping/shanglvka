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
<title>绑定页面</title>
</head>
<body>
<c:if test="${not empty message}">
<script type="text/javascript">
	alert('${message}');
</script>
</c:if>

	<form:form id="inputForm"  action="${ctx}/uc/bind" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>绑定卡号</small></legend>
			<div id="messageBox" class="alert alert-error input-large controls" style="display:none">输入有误，请先更正。</div>
			<div class="control-group">
				<label for="cardNo" class="control-label">卡号:</label>
				<div class="controls">
					<input type="text" id="cardNo" name="cardNo" value="${cardNo}" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="channel" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="password" name="password" value="${password}" class="input-large"/>
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form:form>
</body>
</html>

