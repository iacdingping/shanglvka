<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>常见问题解答管理</title>
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
		<li><a href="${ctx}/business/questions/">常见问题解答列表</a></li>
		<li class="active"><a
			href="${ctx}/business/questions/form?id=${questions.id}">常见问题解答<shiro:hasPermission
					name="business:questions:edit">${not empty questions.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="business:questions:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="questions"
		action="${ctx}/business/questions/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<tags:message content="${message}" />
		<div class="control-group">
			<label class="control-label">问题:</label>
			<div class="controls">
				<form:textarea path="question" htmlEscape="false" cols="6" rows="6"
					class="required" cssStyle="width:600px;" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">答案:</label>
			<div class="controls">
				<form:textarea path="context" htmlEscape="false" cols="6" rows="6"
					class="required" cssStyle="width:600px;" />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="business:questions:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保 存" />&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>
