// JavaScript Document
//评论框光标
(function($){
$.fn.extend({
insertAtCaret: function(myValue){
var $t=$(this)[0];
if (document.selection) {
this.focus();
sel = document.selection.createRange();
sel.text = myValue;
this.focus();
}
else 
if ($t.selectionStart || $t.selectionStart == '0') {
var startPos = $t.selectionStart;
var endPos = $t.selectionEnd;
var scrollTop = $t.scrollTop;
$t.value = $t.value.substring(0, startPos) + myValue + $t.value.substring(endPos, $t.value.length);
this.focus();
$t.selectionStart = startPos + myValue.length;
$t.selectionEnd = startPos + myValue.length;
$t.scrollTop = scrollTop;
}
else {
this.value += myValue;
this.focus();
}
}
}) 
})(jQuery);
//弹出框
function showpop(contentid) {
	
	$('#contentid').val(contentid);
    $('<div class="black-bg"></div>').appendTo("body");
	$('.black-bg').css({ "height": $(document).innerHeight() }).show();
	$('.kuan-cont').show();
	$('#fix').addClass("pos-fix");
}
//隐藏弹出框
function hidepop() {
	$('.black-bg').remove();
    $(".kuan-cont").hide();
    $('#pl').val('');
    $('#fix').removeClass('pos-fix');
}

function valChange(){
	$text=$('#pl').val();

	}


$(document).ready(function(e) {

 
 	
//评论字数
$("#pl").on('input',function(){
	var comment=$('#pl').val();
	var length =140;
	var content_len = comment.length;
	var in_len = length - content_len;
	$("#lastnum").html(in_len);
});	
//返回顶部
	$(window).scroll(function(){
		
		if($(window).scrollTop()<50){
			$(".back-top").hide();			
			}
		else{$(".back-top").show();}
		
		});
	$(".back-top").click( function(){
		$(window).scrollTop(0);	
		});
 

//评论
 	$('.face').click(function(){
	$(this).parent().next('.face-box').toggle();//显示评论表情框
	});   
 	
	$text="";
	$("#pl").blur(function(){
		
		if($text!==""){	
		  var $inputVal=$("#pl").val();
		  $inputVal=$inputVal.split($text);
			$text+=$inputVal[1];	
			$("#pl").val($text);}
		//第一次输入文字的时候
		else{
			
			$text=$("#pl").val();
			}
					
			});
 	
	$('.faces-list li').on("click",function(){
		var textinput=$('.wenb');//评论框
		var face_ico=$(this).find('img').attr('rel');//找到它点击的表情图片
		//textinput.insertAtCaret(face_ico);
		//textinput.append(face_ico);
		$text+=face_ico;
		//alert($text)
		textinput.val($text);

		//移动光标，阻止软键盘弹上来


		//$(".wenb").blur();

		var face_len=face_ico.length;//获取表情字符的字数
		var num=parseInt($("#lastnum").text());//获取提示里的数字
		var txt_len =num-face_len;//计算输入表情后提示里的数字变化   
		    $("#lastnum").html(txt_len);


		  });
});