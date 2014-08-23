<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>商旅地图管理</title>
<meta name="decorator" content="default" />
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
		<li><a href="${ctx}/business/merchantMap/">商旅地图列表</a></li>
		<li class="active"><a
			href="${ctx}/business/merchantMap/form?id=${merchantMap.id}">商旅地图<shiro:hasPermission
					name="business:merchantMap:edit">${not empty merchantMap.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="business:merchantMap:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="merchantMap"
		action="${ctx}/business/merchantMap/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<tags:message content="${message}" />
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="50"
					class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简要标签:</label>
			<div class="controls">
				<form:input path="label" htmlEscape="false" maxlength="50"
					class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">列表图片:</label>
			<div class="controls">
				<input type="hidden" id="smallPic" name="smallPic"
					value="${merchantMap.smallPic}" />
				<tags:ckfinder input="smallPic" type="thumb"
					uploadPath="/cms/article" selectMultiple="false" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">大图片:</label>
			<div class="controls">
				<input type="hidden" id="bgPic" name="bgPic"
					value="${merchantMap.bgPic}" />
				<tags:ckfinder input="bgPic" type="thumb" uploadPath="/cms/article"
					selectMultiple="false" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地址区域:</label>
			<div class="controls">
				<tags:treeselect id="area" name="area.id"
					value="${merchantMap.area.id}" labelName="name"
					labelValue="${merchantMap.area.name}" title="父类别"
					url="/sys/area/treeData" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">详细地址:</label>
			<div class="controls">
				<form:textarea path="address" htmlEscape="false" rows="4"
					maxlength="100" class="required input-xlarge" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系电话:</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="13"
					class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">优惠简介:</label>
			<div class="controls">
				<form:input path="offer" htmlEscape="false" maxlength="30"
					class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">详细说明:</label>
			<div class="controls">
				<form:textarea path="detail" htmlEscape="false" rows="4"
					maxlength="500" class="required input-xxlarge" />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="business:merchantMap:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保 存" />&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>
