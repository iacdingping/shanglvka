<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${ctx}/static/js/common/jquery.min.js"></script>
<link rel="stylesheet" href="${ctx}/static/css/common/common.css" />
<link rel="stylesheet" href="${ctx}/static/css/info/view.css" />
<script type="text/javascript">
	function submitVoting() {
		var optionalNum = '${viewData.optionalNum}';
		var objName = document.getElementsByName("voteSelect");
		var votes = "";
		var num = 0;
		for (i = 0; i < objName.length; i++) {
			if (objName[i].type == "checkbox" && objName[i].checked) {
				num++;
				votes += objName[i].value + ',';
			}
		}
		if (num == 0) {
			$("#submit_notice").html("请选择投票项");
			return;
		} else if (num > optionalNum) {
			$("#submit_notice").html("投票不能超过" + optionalNum + "项");
			return;
		} else if ($("#phone").val() == '' || $("#phone").val().length != 11) {
			$("#submit_notice").html("请输入正确的手机号码");
			return;
		}
		//此处需要验证传入字段是否全部
		$.ajax({
			url : "${ctx}/info/view/votingSubmit",
			type : 'get',
			data : {
				'articleId' : '${viewData.id}',
				'phone' : $("#phone").val(),
				'voteSelect' : votes.substring(0, votes.length - 1)
			},
			cache : false,
			success : function(data) {
				if (data.success) {
					$("#submit_notice").html('提交成功');
				} else {
					$("#submit_notice").html(data.message);
				}
			}
		});
	}
</script>
<title>详情页</title>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/include/common.jsp"></jsp:include>
	<div class=" margin_T20 ">
		<header class="border_bottom1 padding-B10 content_area">
			<div class="title">${fns:rabbr(viewData.title, 34)}</div>
			<div class="font_size_15 font_color_h2">
				<fmt:formatDate value="${viewData.createDate}"
					pattern="yyyy年MM月dd日  HH:mm:ss" />
			</div>
		</header>
		<article class="conetnt limit_wth content_area" style="overflow: hidden;">
			<p class="sj2 margin_T10">
				${fns:unescapeHtml(viewData.articleData.content)}</p>
			<br />
		</article>
		<c:if test="${fn:length(votings)>0}">
			<div class="font_color_l font_size_16 line-height">
				<div class="border_bottom1" style="height: 36px;">
					<div class="margin_L10 floatL">
						<img src="${ctx}/static/img/info/vote.gif" style="width: 20px;" />
					</div>
					<div class="margin_L10 floatL font_color_hei bold"
						style="line-height: 35px;">投票</div>
					<div class="clearboth "></div>
				</div>
				<div class="margin_T20 border_bottom1 padding-B10">
					<p class="font_color_hei margin_L20">
						<c:if test="${!isHas}">快来参与投票吧，最多选择${viewData.optionalNum}项</c:if>
						<c:if test="${isHas}">您已经参与了投票</c:if>
					</p>
					<p style="width: 80%; margin: auto; margin-top: 10px;">
						<c:forEach var="item" items="${votings}" varStatus="votings">
							<c:if test="${!isHas}">
								<input type="checkbox" value="${item.id}" name="voteSelect"  onchange="validateValue()"/>
							</c:if>&nbsp;&nbsp;${item.title}<c:if test="${isHas}">(${item.voteCount}人)</c:if>
							<br />
						</c:forEach>
					</p>
				</div>
				<c:if test="${!isHas}">
						<div style="width:170px;text-align: left;margin: auto;" class="padding-T10">
							<span id="submit_notice" style="color:red"></span>
							<input id="phone" type="text" value="" class="BTN00" placeholder="请输入手机号">
						</div>
						<a href="javascript:void(0);" class="BTN00 BTN08"
							onclick="submitVoting();" style="margin-top: 5px;">投票</a>
					</c:if>
			</div>
		</c:if>
		<div class="font_color_l font_size_16 floatR displayN"
			style="line-height: 20px; margin-right: 10px;">
			<img src="${ctx}/static/img/info/recommend.gif"
				style="width: 20px; height: 20px;" align="left" /> &nbsp;<span
				id="commandBTN">评论</span> &nbsp;<span class="font_color_h2">(${commends.count})</span>
		</div>
		<div class="clearboth"></div>
	</div>
	<div class="border_bottom1 margin_B10 margin_T10 positionR displayN">
		<div class="positionA" style="right: 70px; top: -11px;">
			<img src="${ctx}/static/img/info/icon05.gif" height="10" />
		</div>
	</div>
	<div class="content_area">

		<ul>
			<c:forEach items="${commends.list}" var="commend">

				<li class="border_bottom1 padding-B10 margin_B10"><img
					src="${ctx}/static/img/common/default_touxiang.jpg" align="left"
					style="margin: 0px 10px;" />
					<p class="margin_B5">
						<span class=" font_color_h font_size_16">${commend.name}</span> <span
							class=1"font_size_14font_color_hfloatR"><fmt:formatDate
								value="${commend.createDate}" pattern="yyyy-MM-dd HH:mm" /></span>
					</p>
					<p>
						<span class="font_size_15 font_color_hei">${commend.content}</span>
					</p>
					<div class="clearboth"></div></li>
			</c:forEach>
		</ul>
	</div>
	<br />
	<br />
	<br />
	<br />
	<div class="positionF black_layout touming displayN"
		id="touming_layout"></div>
	<div class="positionF textarea_layout displayN" id="textarea_layout">
		<div class="border_bottom1">
			<textarea rows="" cols="" placeholder="说点什么吧……"></textarea>
		</div>
		<p class="floatL displayN" id="biaoqing">
			<img src="${ctx}/static/img/info/icon07.gif" width="30" class="BTN00"
				style="border: 0px;" />
		</p>
		<p class="floatR">
			<span class="BTN00 floatL BTN05">140</span> <span
				class="BTN00 floatL BTN04" id="cancel_command">取消</span> <span
				class="BTN00 floatR BTN03">发表</span>
		</p>
		<div class="clearboth"></div>
		<div class="biaoqing_select displayN" id="biaoqing_select">
			<表情列表>
		</div>
	</div>

	<script type="text/javascript">
		$().ready(function() {
			$("#commandBTN").click(function() {
				$("#touming_layout").show();
				$("#textarea_layout").show();
			});
			$("#cancel_command").click(function() {
				$("#touming_layout").hide();
				$("#textarea_layout").hide();
			});
			$("#biaoqing").click(function() {
				$("#biaoqing_select").toggle();
				$("#textarea_layout").attr("top", "")
			});
		});
	</script>
</body>
</html>