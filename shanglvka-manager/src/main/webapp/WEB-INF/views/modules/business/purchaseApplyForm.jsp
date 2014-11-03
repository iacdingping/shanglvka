<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>申购单管理</title>
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
		<li><a href="${ctx}/business/purchaseApply/">申购单列表</a></li>
		<li class="active"><a href="${ctx}/business/purchaseApply/form?id=${purchaseApply.id}">申购单<shiro:hasPermission name="business:purchaseApply:edit">${not empty purchaseApply.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="business:purchaseApply:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="purchaseApply" action="${ctx}/business/purchaseApply/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
        <div class="control-group">
			<label class="control-label">购卡金额:</label>
			<div class="controls">
				<form:input path="buyMoney" htmlEscape="false" maxlength="8" class="number required"/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">购卡联系人:</label>
			<div class="controls">
				<form:input path="buyName" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">购卡人电话:</label>
			<div class="controls">
				<form:input path="buyPhone" htmlEscape="false" maxlength="13" class="required"/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">购卡单位:</label>
			<div class="controls">
				<form:input path="buyUnit" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="business:purchaseApply:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
