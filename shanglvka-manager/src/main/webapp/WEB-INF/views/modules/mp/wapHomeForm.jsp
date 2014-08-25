<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>网站首页管理</title>
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
		<li><a href="${ctx}/mp/wapHome/">网站首页列表</a></li>
		<li class="active"><a href="${ctx}/mp/wapHome/form?id=${wapHome.id}">网站首页<shiro:hasPermission name="mp:wapHome:edit">${not empty wapHome.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="mp:wapHome:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="wapHome" action="${ctx}/mp/wapHome/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
        <div class="control-group">
			<label class="control-label">首页模块位置:</label>
			<div class="controls">
				<form:select path="location">
					<form:options items="${fns:getDictList('index_module')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">标题:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">超链接:</label>
			<div class="controls">
				<form:input path="link" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">图片(640*320):</label>
			<div class="controls">
                <input type="hidden" id="pic" name="pic" value="${wapHome.pic}"  class="required"/>
				<tags:ckfinder input="pic" type="thumb" uploadPath="/cms/wapHome" selectMultiple="false"/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
				<form:input path="sort" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="mp:wapHome:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
