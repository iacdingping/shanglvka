<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>商旅类别管理</title>
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
		<li><a href="${ctx}/business/merchantType/">商旅类别列表</a></li>
		<li class="active"><a
			href="${ctx}/business/merchantType/form?id=${merchantType.id}">商旅类别<shiro:hasPermission
					name="business:merchantType:edit">${not empty merchantType.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="business:merchantType:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="merchantType"
		action="${ctx}/business/merchantType/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<tags:message content="${message}" />
		<div class="control-group">
			<label class="control-label">上级类别:</label>
			<div class="controls">
				<tags:treeselect id="merchantType" name="parent.id"
					value="${merchantType.parent.id}" labelName="parent.name"
					labelValue="${merchantType.parent.name}" title="类别"
					url="/business/merchantType/treeData" extId="${merchantType.id}" cssClass="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类别名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50"
					class="required" />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="business:merchantType:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保 存" />&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>
