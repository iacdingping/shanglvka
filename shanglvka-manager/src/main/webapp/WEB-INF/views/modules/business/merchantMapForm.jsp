<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>商旅地图管理</title>
<meta name="decorator" content="default" />
<%@include file="/WEB-INF/views/include/treeview.jsp"%>
<script type="text/javascript">
		$(document).ready(function(){
			$("#title").focus();
			$("#inputForm").validate({
				//rules: {
					//name: {remote: "${ctx}/sys/role/checkName?oldName=" + encodeURIComponent("${role.name}")}
				//},
				//messages: {
					//name: {remote: "角色名已存在"}
				//},
				submitHandler: function(form){
					var ids = [], nodes = tree.getCheckedNodes(true);
					for(var i=0; i<nodes.length; i++) {
						ids.push(nodes[i].id);
					}
					$("#typeIds").val(ids);
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

			var setting = {check:{enable:true,nocheckInherit:true},view:{selectedMulti:false},
					data:{simpleData:{enable:true}},callback:{beforeClick:function(id, node){
						tree.checkNode(node, !node.checked, true, true);
						return false;
					}}};
			
			// 用户-菜单
			var zNodes=[
					<c:forEach items="${typeList}" var="type">{id:'${type.id}', pId:'${not empty type.parent.id?type.parent.id:0}', name:"${not empty type.parent.id?type.name:'所属类别列表'}"},
		            </c:forEach>];
			// 初始化树结构
			var tree = $.fn.zTree.init($("#typeTree"), setting, zNodes);
			// 默认选择节点
			var ids = "${merchantMap.typeIds}".split(",");
			for(var i=0; i<ids.length; i++) {
				var node = tree.getNodeByParam("id", ids[i]);
				try{tree.checkNode(node, true, false);}catch(e){}
			}
			// 默认展开全部节点
			tree.expandAll(true);
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
			<label class="control-label">所属品牌:</label>
			<div class="controls">
				<form:select path="merchantBrand.id">
					<form:option value="" label="请选择"/>
					<form:options items="${brandList}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">店铺名称:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="50"
					class="required" />
			</div>
		</div>
		<div class="control-group" style="display: none;">
			<label class="control-label">简要标签:</label>
			<div class="controls">
				<form:input path="label" htmlEscape="false" maxlength="50"
					class="required" />
			</div>
		</div>
		<div class="control-group" style="display: none;">
			<label class="control-label">列表图片(50*50):</label>
			<div class="controls">
				<input type="hidden" id="smallPic" name="smallPic"
					value="${merchantMap.smallPic}" />
				<tags:ckfinder input="smallPic" type="thumb"
					uploadPath="/cms/article" selectMultiple="false" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">大图片(640*320):</label>
			<div class="controls">
				<input type="hidden" id="bgPic" name="bgPic"
					value="${merchantMap.bgPic}" />
				<tags:ckfinder input="bgPic" type="thumb" uploadPath="/cms/article"
					selectMultiple="false" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属类别:</label>
			<div class="controls">
				<div id="typeTree" class="ztree"
					style="margin-top: 3px; float: left;"></div>
				<form:hidden path="typeIds" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地址区域:</label>
			<div class="controls">
				<tags:treeselect id="area" name="area.id"
					value="${merchantMap.area.id}" labelName="name"
					labelValue="${merchantMap.area.name}" title="父类别"
					url="/sys/area/treeData?pid=3e9ab3f7ea4a43e79e3e067d2835d303"
					cssClass="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">详细地址:</label>
			<div class="controls">
				<form:textarea path="address" htmlEscape="false" rows="2"
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
