<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameFirstLower = table.classNameFirstLower>
<#assign classNameLower = className?uncap_first> 
<#macro mapperEl value>${r"${"}${value}}</#macro>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>${table.tableAlias}</title>
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
		<li><a href="<@mapperEl 'ctx'/>/${appModule}/${classNameLower}/">${table.tableAlias}列表</a></li>
		<li class="active"><a href="<@mapperEl 'ctx'/>/${appModule}/${classNameLower}/form?id=<@mapperEl classNameLower + '.id'/>">网站首页<shiro:hasPermission name="${appModule}:${classNameLower}:edit"><@mapperEl 'not empty ' + classNameLower + '.id?"修改":"添加"'/></shiro:hasPermission><shiro:lacksPermission name="${appModule}:${classNameLower}:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="${classNameLower}" action="<@mapperEl 'ctx'/>/${appModule}/${classNameLower}/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="<@mapperEl 'message'/>"/>
		
		<#list table.columns as column>
		<div class="control-group">
			<label class="control-label">${column.columnAlias}:</label>
			<div class="controls">
				<form:input path="${column.columnNameFirstLower}" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		</#list>	
		
		<div class="form-actions">
			<shiro:hasPermission name="${appModule}:${classNameLower}:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
