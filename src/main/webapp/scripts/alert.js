/** 封装弹出对话框处理js**/

function alertAddBookWindow(){
	$("#can").load("alert/alert_notebook.html");
	$(".opacity_bg").show();
}

function alertAddNoteWindow(){
	var $a = $("#book_ul a.checked");
	if($a.length==0){
		alert("请先选择笔记本");
	}else{
		$("#can").load("alert/alert_note.html");
		$(".opacity_bg").show();
	}
	
}

function closeWindow(){
	$("#can").empty();
	$(".opacity_bg").hide();
}

function alertRenameWindow(){
	$("#can").load("alert/alert_rename.html");
	$(".opacity_bg").show();
}