<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib-activity.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="${ctx}/static/js/common/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/act/pos/common.js"></script>
<link type="text/css" rel="stylesheet" href="${ctx}/static/css/act/pos/common.css">
<link type="text/css" rel="stylesheet" href="${ctx}/static/css/act/pos/weishequ.css">
<link type="text/css" rel="stylesheet" href="${ctx}/static/css/act/pos/photoswipe.css">
<title>刷卡大咖</title>
</head>
<body class="bg-hui02">
	<!--评论框-->
	<div class="kuan-cont02" id="tishi">
		<div class="tishikuang text-center" id="tishikuang"></div>
	</div>
	<div class=" pt15 bg-bai  bb-hui03">
		<div class=" br4   mlr14">
			<p class="plr15 pt10 bd-hui br4">
				<textarea id="pl" name="" cols="" rows="" maxlength="140" class="wenb textareabox pct-w100 ft-yahei  f16 hui  h77" placeholder="说两句吧。。。" oninput="valChange();"></textarea>
			</p>
			<div class=" clearfix  pb10 pt10 pos-rel">
				<div class="fr clearfix pct-w80 text-right">
					<span class=" f15 hui01 lh33" id="lastnum">140</span> <a href="javascript:void(0);" class="bg-blue lh30 bai br4 display-ib pct-w30 text-center ml8 f15" onClick="addposting(this);">发表</a>
				</div>
				<a href="javascript:void(0);" class="face face-ico01 display-ib icon01 fl"></a>
				<div class="select-pos02 pos-abs select-pos">
					<select id="permissions" class="new-input hui05  pct-w100 ">
						<option value="1">全部公开</option>
						<option value="2">部门公开</option>

					</select> <input type="hidden" id="imgids" value="">
					<div class="arrow-down"></div>
				</div>
			</div>
			<div class=" face-box face-box01 display-no">
				<div class="faces-list clearfix">
					<ul>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/0.gif" alt="" width="24" height="24" rel="[微笑]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/1.gif" alt="" width="24" height="24" rel="[撇嘴]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/2.gif" alt="" width="24" height="24" rel="[色]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/3.gif" alt="" width="24" height="24" rel="[发呆]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/4.gif" alt="" width="24" height="24" rel="[得意]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/5.gif" alt="" width="24" height="24" rel="[流泪]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/6.gif" alt="" width="24" height="24" rel="[害羞]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/7.gif" alt="" width="24" height="24" rel="[闭嘴]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/8.gif" alt="" width="24" height="24" rel="[睡]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/9.gif" alt="" width="24" height="24" rel="[大哭]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/10.gif" alt="" width="24" height="24" rel="[尴尬]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/11.gif" alt="" width="24" height="24" rel="[发怒]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/12.gif" alt="" width="24" height="24" rel="[调皮]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/13.gif" alt="" width="24" height="24" rel="[呲牙]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/14.gif" alt="" width="24" height="24" rel="[惊讶]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/15.gif" alt="" width="24" height="24" rel="[难过]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/16.gif" alt="" width="24" height="24" rel="[酷]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/17.gif" alt="" width="24" height="24" rel="[冷汗]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/18.gif" alt="" width="24" height="24" rel="[抓狂]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/19.gif" alt="" width="24" height="24" rel="[吐]"></li>
						<li><img class="faces" src="${ctx}/static/img/act/pos/face/20.gif" alt="" width="24" height="24" rel="[偷笑]"></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!--添加图片-->

	<div class=" ml15 mt22 clearfix">
		<div class="fl" id="addcon"></div>
		<div class="fileInput fl">
			<input type="file" name="upfile" id="upfile" class="upfile" value="" accept="image/png,image/jpg,image/jpeg" /> <input class="upFileBtn" type="button" value="上传图片" onClick="document.getElementById('upfile').click()" />
		</div>
	</div>
	<p class="ml15 mt10 hui04 num">
		最多可再上传<i>3</i>张图片
	</p>
<script type="text/javascript">
	var facesIteam = "[微笑],[撇嘴],[撇嘴],[色],[发呆],[得意],[流泪],[害羞],[闭嘴],[睡],[大哭],[尴尬],[发怒],[调皮],[呲牙],[惊讶],[难过],[酷],[冷汗],[抓狂],[吐],[偷笑]";

	var num = 3;
	var sid;
	var target;
	$(function() {

		$(".kuan-cont").show();
		$(document).on('click', '.closeimg', function(e) {
			$('#imgids').val($('#imgids').val().replace(',' + $(this).parent().parent().attr('id'), ''));
			$(this).parent().parent().remove();
			num++;
			$(".num i").text(num);
			$('.fileInput').show();
		});
	});

	//上传图片
	$("#upfile").change(function(e) {
		if ($(".num i").text() > 0) {
			var freader = new FileReader();
			var file = e.target.files.item(0);
			$("#addcon").append("<div class='addimg mr20 pos-rel'><a href='javascript:void(0);'><img src='${ctx}/static/img/act/pos/loader.gif'><div class='pos-abs closeimg'></div></div>");
			$('.fileInput').hide();

			freader.readAsDataURL(file);

			freader.onloadstart = function(e) {

			}
			freader.onload = function(e) {
				target = e.target.result;
				var result = file.name.split('.');
				var suffix = result[(result.length) - 1];
				if (suffix != 'jpg' && suffix != 'png' && suffix != 'jpeg') {
					alert('上传图片' + file.name + '格式有误，只能上传jpg,jpeg,png后缀图片');
					return;
				}

				if (target.indexOf('image') == -1) {

					target = target.replace('data:', 'data:image/' + result[1] + ';');

				}

				num--;
				$(".num i").text(num);

				var form = new FormData();

				form.append("file", file); // 可以增加表单数据

				// XMLHttpRequest 对象
				var xhr = new XMLHttpRequest();

				xhr.onreadystatechange = function() {
					//判断对象交互完成 
					if (xhr.readyState == 4) {
						//判断http交互是否成功  
						if (xhr.status == 200) {
							//获取服务器的数据  
							//获取XML包装的的数据  
							var responseText = xhr.responseText;
							var s = eval('(' + responseText + ')');
							if (s == '1') {
								alert('上传图片格式有误，只能上传jpg,jpeg,png后缀图片');
								$(".addimg").eq(2 - num).remove();
								num++;
								$(".num i").text(num);
							} else {
								sid = s.picid;
								$('#imgids').val($('#imgids').val() + "," + sid);
								$(".addimg").eq(2 - num).attr("id", sid);
								$(".addimg").eq(2 - num).find("img").attr("src", target);
							}
							if (num != 0) {
								$('.fileInput').show();
							}

						}

					}
				}
				xhr.open("post", "/wsq/upLoadPic.action", true);

				xhr.send(form);

			}

		}

	});

	//提交评论
	function addposting(obj) {

		var content = $('#pl').val();
		if (content.length > 140) {
			$('#tishikuang').html('<font color=red>内容过长</font>');
			tishi();
			return;
		}

		if ($.trim(content) == '') {
			$('#tishikuang').html('<font color=red>请填写内容后再发表</font>');
			tishi();
			return;
		}
		$(obj).attr('onclick', 'return false');

		$('.faces').each(function(index, obj) {
			while (content.indexOf($(obj).attr('rel')) >= 0) {
				content = content.replace($(obj).attr('rel'), "<img src=\"" + $(obj).attr('src') + "\" />");
			}
		});

		var permissions = $('#permissions').val();
		var imgids = $('#imgids').val();

		content = content.replace(/<^>.*?>/g, '');
		content = encodeURIComponent(content);
	}

	function tishi() {
		$("#tishi").fadeIn(1500);
		$("#tishi").fadeOut(1500);
	}

	function valChange() {
		$text = $('#pl').val();

	}
</script>
</body>
</html>