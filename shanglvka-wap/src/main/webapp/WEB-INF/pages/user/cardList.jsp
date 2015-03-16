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
	<header class="h40 lh40 bg1 w_center">
		<span id="header_title">个人中心</span>
		<div class="clear"></div>
	</header>
	<div style="text-align: center; width: 100%; color: #7b7979">
		<font color="#000000" size="5"><b>${user.weixinUser.nickname}</b></font>
		<div style="margin-top: 10px; margin-bottom: 20px;">
			<font color="#000000">厉害的人</font>
		</div>
	</div>
	<div class="line" style="background: #999999"></div>
	<div class="mg_t_10">
		<c:choose>
			<c:when test="${empty cards}">
				<ul>
					<li><a href="${ctx}/card/jump" style="color:red;">申请卡号</a></li>
					<li><a href="${ctx}/uc/bind" style="color:red;">绑定卡号</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<div id="item_list" style="margin: auto; width: 96%;">
					<c:forEach items="${cards}" var="card" varStatus="status">
						<div style="margin: 10px 0px; padding:10px 0px; border:1px dashed #666">
							<div class="" style="height:30px;line-height: 30px;">
								<span class="font_w_b mg_l_5">卡号:</span> ${card.hiddenCardNo}
								<input type="password" id="password_${status.index}"  placeholder="请输入密码进行操作" class="pwd_input"/>
							</div>
							<c:if test="${card.status == 1}">
								<span style="display:none">状态：已绑定
								<br />绑定时间：<fmt:formatDate value="${card.updateTime}"
										pattern="yyyy-MM-dd HH:mm" /></span>
							</c:if>
							<c:if test="${card.status == 0 or card.status == 2}">
								<a href="javascript:void(0);" onclick="bind(${status.index})">重新绑定</a>
							</c:if>
							<div class="mg_t_10">
								<div id="item_list" style="margin: auto; width: 96%;">
									<li style="background: #01cf45"><a href="javascript:void(0);"
										onclick="balanceQuery(${status.index})">余额查询</a></li>
									<li style="background: #6a74f8"><a href="javascript:void(0);"
										onclick="transactionQuery(${status.index})">交易记录</a></li>
									<li style="background: #0ec3ce"><a href="javascript:void(0);"
										onclick="pointQuery(${status.index})">积分查询</a></li>
									<li style="background: #d2f339"><a href="${ctx}/uc/jfdh">积分兑换</a></li>
									<div class="clear"></div>
								</div>
							</div>
							<input type="hidden" id="card_${status.index}" value="${card.cardNo}" />
							 <span
								id="notice_${status.index}" style="display: none;">此处显示操作消息</span>
						</div>
					</c:forEach>
					<div class="clear"></div>
					<a href="${ctx}/uc/bind">
					<div class="mg_t_10" style="height:70px;width:100%; background: #ddd; margin: auto; text-align: center;line-height:70px;color: #888; font-size: 20px;">
						绑定新卡
					</div>
					</a>
				</div>
			</c:otherwise>
		</c:choose>
		
	</div>

	<footer style="margin-top: 40px;">
		<jsp:include page="${ctx}/WEB-INF/pages/jiahao.jsp"></jsp:include>
	</footer>
	
<script type="text/javascript">
function checkPassword(i) {
	var pwd_input = $('#password_' + i);
	var password = pwd_input.val();
	if(password == null || password == '') {
		pwd_input.attr("placeholder" , "请先输入密码");
		pwd_input.css("border" , "1px solid red");
		//$('#notice_' + i).html('请先输入密码').show().fadeOut(3000);
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

