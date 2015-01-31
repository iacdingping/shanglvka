<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>接口请求</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	$(document).ready(function() {
		$('#ajax_submit_btn').click(formSubmit);
		
		$('#method').change(function(){ 
			var obj = document.getElementById("method"); //selectid

			var index = obj.selectedIndex; // 选中索引
			console.log(index);
			
			$('#jsonData').html($('#method' + index).html());
		}) 
	})

	
	function formSubmit() {
		var form = $('#inputForm');
		var data = form.serialize();
		
		var action = form.attr('action'); 
		var method = form.attr('method') || 'get';
		$('#response').val('waiting...').show().focus();
		$('#ajax_submit_btn').unbind('click').removeAttr('onClick');
		$('#ajax_submit_btn').bind('click', function() {alert('wait for previous submit finished.');});
		
		$.ajax({
			type : method,
			url : action,
			data : data,
			dataType : 'json',
			success : function(data) {
				$('#response').val(data).show();
				$('#ajax_submit_btn').removeAttr('onclick').unbind('click').bind('click', formSubmit);
			},
			error : function(xhr, ajaxOptions, thrownError) {
				$('#response').val('请求失败，请查看日志').show().focus();
				$('#ajax_submit_btn').removeAttr('onclick').unbind('click').bind('click', formSubmit);
			} 
		});
	}
	</script>
</head>
<body>
	<form:form id="inputForm" modelAttribute="reqeustBody" action="${ctx}/shanglv/soap/ajaxRequest" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>输入参数</small></legend>
			<div id="messageBox" class="alert alert-error hide" style="display:none">输入有误，请先更正。</div>
			<div class="control-group">
				<label for="method" class="control-label">调用方法:</label>
				<div class="controls">
				<select id="method" name="method" >
					<option value="请选择">请选择</option>
					<c:forEach items="${requestMethod}" var="method" varStatus="status">
						<option value="${method.method}">${method.methodDesc}</option>
					</c:forEach>
				</select>
				
				<span id="method0" style="display:none;"></span>
				<c:forEach items="${requestMethod}" var="method" varStatus="status">
					<span id="method${status.index + 1}" style="display:none;">${method.example}</span>
				</c:forEach>
				</div>
			</div>
			<div class="control-group">
				<label for="jsonData" class="control-label">请求报文:</label>
				<div class="controls">
					<textarea name="jsonData" class="form-control" rows="10" style="width:98%;" id="jsonData">${reqeustBody.jsonData}</textarea>
				</div>
			</div>
			<div class="control-group">
				<label for="jsonData" class="control-label">响应报文:</label>
				<div class="controls">
					<textarea class="form-control" rows="10" style="width:98%;" id="response">${response}</textarea>
				</div>
				<legend></legend>
			</div>
			<div class="form-actions">
				<span id="ajax_submit_btn" class="btn btn-primary" >提交</span>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form:form>
</body>
</html>