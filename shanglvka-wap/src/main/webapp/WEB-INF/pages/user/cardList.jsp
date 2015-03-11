<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib-activity.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<script type="text/javascript"
	src="${ctx}/static/js/common/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/page-frame.js"></script>
<title>个人中心</title>
</head>
<body>
	<div style="text-align: center; width: 100%; color: #7b7979">
		<font color="#000000" size="5"><b>${user.weixinUser.nickname}</b></font>
		<div  style="margin-top: 10px;margin-bottom: 20px;"><font  color="#000000">厉害的人</font></div>
	</div>
	<div class="line" style="background: #999999"></div>
	<div class="mg_t_10 mg_l_10">
		<c:choose>
			<c:when test="${empty cards}">
				<ul>
					<li><a href="${ctx}/card/jump" style="color:red;">申请卡号</a></li>
					<li><a href="${ctx}/uc/bind" style="color:red;">绑定卡号</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<div id="item_list" style="margin: auto;width:96%;">
					<c:forEach items="${cards}" var="card" varStatus="status">
						卡号: ${card.hiddenCardNo}
						<input type="hidden" id="card_${status.index}" value="${card.cardNo}"/>
						<input type="password" id="password_${status.index}"/>
						
						<c:if test="${card.status == 1}">
							状态：已绑定		绑定时间：<fmt:formatDate value="${card.updateTime}" pattern="yyyy-MM-dd HH:mm"/>
							<a href="javascript:void(0);" onclick="balanceQuery(${status.index})" style="color:red;">余额查询</a>
							<a href="javascript:void(0);" onclick="transactionQuery(${status.index})" style="color:red;">交易记录</a>
							<a href="javascript:void(0);" onclick="pointQuery(${status.index})" style="color:red;">积分记录</a>
							<!-- <a href="javascript:void(0);" onclick="pointExchange(${status.index})" style="color:red;">积分兑换</a> -->
						</c:if>
						<c:if test="${card.status == 0 or card.status == 2}">
							<a href="javascript:void(0);" onclick="bind(${status.index})">重新绑定</a>
						</c:if>
						<span id="notice_${status.index}" style="display:none;">此处显示操作消息</span>
						<div class="clear"></div>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
	
<script type="text/javascript">
function checkPassword(i) {
	var password = $('#password_' + i).val();
	if(password == null || password == '') {
		$('#notice_' + i).html('请先输入密码').show().fadeOut(3000);
		$('#password_' + i).focus();
		return null;
	}
	return password;
}

function balanceQuery(i) {
	var password = checkPassword(i);
	if(password == null) {
		return;
	}
	
	var cardNo = $('#card_' + i).val();
	// ajax bind ? 
	$.ajax({
		url:'${ctx}/uc/yecx',
		data:{'cardNo': cardNo , 'password' : password},
		type:'post',
		success: function(data) {
			console.log(data);
			if(data.success) {
				$('#notice_' + i).html('balance: ' + data.money + ' 有效时间：' + data.validTime).hide().show();
			} else {
				alert('服务错误， 请稍后再试');
			}
		},
		error: function() {
			alert('服务错误， 请稍后再试');
		}
	})
}

function transactionQuery(i) {
	var password = checkPassword(i);
	if(password == null) {
		return;
	}
	
	var cardNo = $('#card_' + i).val();
	window.location = '${ctx}/uc/jyjl?cardNo=' + cardNo + '&password='+password;
}

function pointQuery(i) {
	var password = checkPassword(i);
	if(password == null) {
		return;
	}
	
	var cardNo = $('#card_' + i).val();
	// ajax bind ? 
	$.ajax({
		url:'${ctx}/uc/jfcx',
		data:{'cardNo': cardNo , 'password' : password},
		type:'post',
		success: function(data) {
			console.log('data');
			if(data.success) {
				$('#notice_' + i).html('有效积分为： ' + data.point).hide().show();
			} else {
				$('#notice_' + i).html('服务错误， 请稍后再试').fadeOut(3000);
			}
		},
		error: function() {
			$('#notice_' + i).html('服务错误， 请稍后再试').fadeOut(3000);
		}
	})
}

</script>
</body>
</html>

