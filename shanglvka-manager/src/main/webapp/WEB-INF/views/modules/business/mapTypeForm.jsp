<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>地图类别管理</title>
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
		<li><a href="${ctx}/business/mapType/">地图类别列表</a></li>
		<li class="active"><a href="${ctx}/business/mapType/form?id=${mapType.id}">地图类别<shiro:hasPermission name="business:mapType:edit">${not empty mapType.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="business:mapType:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="mapType" action="${ctx}/business/mapType/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
        <div class="control-group">
			<label class="control-label">map_id:</label>
			<div class="controls">
				<form:input path="mapId" htmlEscape="false" maxlength="21" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="business:mapType:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
