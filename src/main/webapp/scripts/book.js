/*
 *封装笔记本相关处理 
 */
function loadUserBooks(){
	//获取请求参数
	var userId = getCookie("userId");
	//检查格式
	if(userId==null){
		window.location.href="log_in.html";
	}else{
		//发送ajax请求
		$.ajax({
			"url":path+"/book/loadbooks.do",
			"type":"post",
			"data":{"userId":userId},
			"dataType":"json",
			"success":function(result){
				if(result.state==0){
					//获取结果集
					var books = result.data;
					//循环生成列表元素
					for(var i=0;i<books.length;i++){
						 var bookId = books[i].cn_notebook_id;
						 var bookName = books[i].cn_notebook_name;
						 //构建页面
						 var sli = "";
						 sli+='<li class="online">';
						 sli+='  <a  >';
						 sli+='    <i class="fa fa-book" title="online" rel="tooltip-bottom">';
						 sli+='    </i>'+bookName;
						 sli+='  </a>';
						 sli+='</li>';
						 //将bookId绑定到li元素上
						 var $li = $(sli);
						 $li.data("bookId",bookId);
						 //将li元素添加到ul列表中
						 $("#book_ul").append($li);
					}
				}
			},
			"error":function(){
				alert("服务器异常，内容加载失败")
			}
		});
	}
	
}
