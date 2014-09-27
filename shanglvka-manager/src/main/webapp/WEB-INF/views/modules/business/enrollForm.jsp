<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商旅活动管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/business/enroll/">商旅活动列表</a></li>
		<li class="active"><a href="${ctx}/business/enroll/form?id=${enroll.id}">商旅活动<shiro:hasPermission name="business:enroll:edit">${not empty enroll.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="business:enroll:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="enroll" action="${ctx}/business/enroll/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
        <div class="control-group">
			<label class="control-label">contact:</label>
			<div class="controls">
				<form:input path="contact" htmlEscape="false" maxlength="20" class="required"/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">contact_phone:</label>
			<div class="controls">
				<form:input path="contactPhone" htmlEscape="false" maxlength="20" class="required"/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">enroll_date:</label>
			<div class="controls">
				<form:input path="enrollDate" htmlEscape="false" maxlength="10" class="required"/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">enroll_time:</label>
			<div class="controls">
				<form:input path="enrollTime" htmlEscape="false" maxlength="10" class="required"/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">note:</label>
			<div class="controls">
				<form:input path="note" htmlEscape="false" maxlength="255" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="business:enroll:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
