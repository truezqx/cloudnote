
				//加载笔记列表,给笔记本li绑定单击事件
				function loadBookNotes(){
					//设置笔记本li选中效果
					$("#book_ul a").removeClass("checked");
					$(this).find("a").addClass("checked");
					//获取请求参数
					var bookId = $(this).data("bookId");
					$.ajax({
						"url":path+"/note/loadNotes.do",
						"type":"post",
						"data":{"bookId":bookId},
						"dataType":"json",
						"success":function(result){
							if(result.state==0){
								//清空原有的笔记列表
								$("#note_ul li").remove();
								var notes = result.data;
								for(var i=0;i<notes.length;i++){
									var noteId = notes[i].cn_note_id;
									var noteTitle = notes[i].cn_note_title;
									var noteBody = notes[i].cn_note_body;
									createNoteLi(noteId,noteTitle)
								}
								
							}
						},
						"error":function(){
							alert("获取笔记失败！")
						}
					});
				}
				

				//获取笔记信息
				function getNote(){
					$("#note_ul a").removeClass("checked");
					$(this).find("a").addClass("checked");
					var noteId=$(this).data("noteId");
					$.ajax({
						"url":path+"/note/getNote.do",
						"type":"post",
						"data":{"noteId":noteId},
						"dataType":"json",
						"success":function(result){
							if(result.state==0){
								//获取笔记信息
								var note = result.data;
								var noteTitle = note.cn_note_title;
								var noteBody = note.cn_note_body;
								//设置到编辑区域
								$("#input_note_title").val(noteTitle);
								um.setContent(noteBody);
							}
						},
						"error":function(){
							alert("获取笔记失败");
						}
					});
				}
				
				
				function updateNote(){
					var title = $("#input_note_title").val().trim();
					var body = um.getContent();
					var $li = $("#note_ul a.checked").parent();
					var noteId = $li.data("noteId");
					if($li.length==0){
						alert("请先选择要保存的笔记！");
					}else if(title==""){
							alert("标题不能为空！");
					}else{
						$.ajax({
							url:path+"/note/updateNote.do",
							type:"post",
							data:{"noteId":noteId,"title":title,"body":body},
							dataType:"json",
							success:function(result){
								if(result.state==0){
									if(result.data==true){
										
										//更新列表li中
										var sli="";
										sli+='	<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>' +title+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
										//将选中的li中的a内容替换掉
										$li.find("a").html(sli);
										alert("保存笔记成功");
									}else{
										alert("保存失败，稍后重试")
									}
								}
							},
							error:function(){
								alert("保存笔记异常");
							}
						});
					}
						
				}
				
				function createNoteLi(noteId,noteTitle){
					var sli="";
					sli+='<li class="online">';
					sli+='<a  >';
					sli+='	<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>' +noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
					sli+='</a>';
					sli+='<div class="note_menu" tabindex="-1">';
					sli+='	<dl>';
					sli+='		<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
					sli+='		<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
					sli+='		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
					sli+='	</dl>';
					sli+='</div>';
				sli+='</li>';
				//将noteId绑定到li元素上
				var $li = $(sli);
				$li.data("noteId",noteId);
				$("#note_ul").append($li);
				}