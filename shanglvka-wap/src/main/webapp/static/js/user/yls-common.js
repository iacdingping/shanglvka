/**
* 叶绿素-通用前端函数
* 2015-01-25
* v-1.0
*/

/**全屏遮罩*/
//TO DO
function full_screen_shade(transparency){
	var doc_body = document.getElementsByTagName("body");
	p(doc_body);
}

/**关闭弹框*/
function closeTK(){
	$("#b_tk").removeClass("tk_show_slide_down");
	$("#b_tk").addClass("_tk_show_slide_down");
	
	//$("#b_tk").hide();
	$("#detail").hide();
}


/**打印而已*/
function p(obj){
	console.log(obj);
}