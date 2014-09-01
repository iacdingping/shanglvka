<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>微信平台自定义菜单</title>
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
		<li><a href="${ctx}/mp/buttonMenu/">微信平台自定义菜单列表</a></li>
		<li class="active"><a href="${ctx}/mp/buttonMenu/form?id=${buttonMenu.id}">微信平台自定义菜单添加	<shiro:hasPermission name="mp:buttonMenu:edit">${not empty buttonMenu.id?"修改":"添加"}</shiro:hasPermission><shiro:lacksPermission name="mp:buttonMenu:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="buttonMenu" action="${ctx}/mp/buttonMenu/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">id:</label>
			<div class="controls">
				<form:input path="id" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">菜单名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">关键字</label>
			<div class="controls">
				<form:input path="key" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">父ID:</label>
			<!--<div class="controls">
				<tags:treeselect id="buttonMenu" name="buttonMenu.id" value="${buttonMenu.id}" labelName="buttonMenu.name" labelValue="${buttonMenu.name}"
					title="父ID" url="#" module="buttonMenu" notAllowSelectRoot="false" cssClass="input-small"/>
			</div>-->
			  
			<div class="controls">
				<form:input path="parent" htmlEscape="false" maxlength="50" class="required"/>
			</div>
			
		</div>
		<div class="control-group">
			<label class="control-label">类型:</label>
			<div class="controls">
			<form:select id="type" path="type" class="input-small">
				<form:option value="click" label="按钮"/>
				<form:option value="view" label="链接"/>
			</form:select>
			</div>
			<!-- <div class="controls">
				<form:input path="type" htmlEscape="false" maxlength="50" class="required"/>
			</div>
			 -->
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="mp:buttonMenu:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
