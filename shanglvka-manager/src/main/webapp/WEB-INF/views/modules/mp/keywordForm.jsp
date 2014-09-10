<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>关键字管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			//类型变化时，变更输入项
			setShowItem();
			$("#responseType").change(function(){
				setShowItem();
			});
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
		function setShowItem(){
			var responseType = $("#responseType option:selected").val();
			if(responseType=='TEXT'){
				$("#picture_input").hide();
				$("#url_input").hide();
				$("#title_input").hide();
			}else if(responseType=='NEWS'){
				$("#picture_input").show();
				$("#url_input").show();
				$("#title_input").show();
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/mp/keyword/">关键字列表</a></li>
		<li class="active"><a href="${ctx}/mp/keyword/form?id=${keyword.id}">关键字<shiro:hasPermission name="mp:keyword:edit">${not empty keyword.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="mp:keyword:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="keyword" action="${ctx}/mp/keyword/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group" style="displya:none">
			<label class="control-label">ID:</label>
			<div class="controls">
				<form:input path="id" htmlEscape="false" maxlength="200" class="required" disabled="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">关键字:</label>
			<div class="controls">
				<form:input path="key" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">回复类型:</label>
			<div class="controls">
				<form:select path="responseType" id="responseType" >
					<form:options items="${fns:getDictList('weixin_reply_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group" id="title_input">
			<label class="control-label">标题:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="1000" class="required"/>
			</div>
		</div>
		<div class="control-group" id="picture_input">
			<label class="control-label">缩略图(<span id="image_size_id">640X314</span>):
			</label>
			<div class="controls">
				<input type="hidden" id="picture" name="picture"
					value="${keyword.picture}" />
				<tags:ckfinder input="picture" type="thumb" uploadPath="/cms/article"
					selectMultiple="false" />
			</div>
		</div>
		<div class="control-group" id="url_input">
			<label class="control-label">链接地址:</label>
			<div class="controls">
				<form:input path="url" htmlEscape="false" maxlength="1000" class="required input-xxlarge"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">回复内容:</label>
			<div class="controls">
				<form:textarea path="unbindContent" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
			</div>
		</div>
		<form:input type="hidden" path="content" />
		<form:input type="hidden" path="priority" />
		<form:input type="hidden" path="needBind" />
		<form:input type="hidden" path="delFlag" />
		<div class="form-actions">
			<shiro:hasPermission name="mp:keyword:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>

