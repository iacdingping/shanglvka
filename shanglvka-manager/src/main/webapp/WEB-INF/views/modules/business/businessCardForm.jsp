<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>商旅地图管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#name").focus();
				$("#inputForm")
						.validate(
								{
									submitHandler : function(form) {
										loading('正在提交，请稍等...');
										form.submit();
									},
									errorContainer : "#messageBox",
									errorPlacement : function(error, element) {
										$("#messageBox").text("输入有误，请先更正。");
										if (element.is(":checkbox")
												|| element.is(":radio")
												|| element.parent().is(
														".input-append")) {
											error.appendTo(element.parent()
													.parent());
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
		<li><a href="${ctx}/business/businessCard/">商旅名片列表</a></li>
		<li class="active"><a
			href="${ctx}/business/businessCard/form?id=${businessCard.id}">商旅名片<shiro:hasPermission
					name="business:businessCard:edit">${not empty businessCard.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="business:businessCard:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="businessCard"
		action="${ctx}/business/businessCard/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<tags:message content="${message}" />
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="30"
					class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="13"
					class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="mail" htmlEscape="false" maxlength="50"
					class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地址:</label>
			<div class="controls">
				<form:input path="address" htmlEscape="false" maxlength="100"
					class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">头像:</label>
			<div class="controls">
				<input type="hidden" id="icoHeader" name="icoHeader"
					value="${businessCard.icoHeader}" />
				<tags:ckfinder input="icoHeader" type="thumb"
					uploadPath="/ico/header" selectMultiple="false" />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="business:businessCard:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保 存" />&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>
