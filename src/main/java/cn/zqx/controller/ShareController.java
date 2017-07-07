package cn.zqx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zqx.entity.Share;
import cn.zqx.service.NoteService;
import cn.zqx.service.ShareService;
import cn.zqx.util.JsonResult;

@Controller
@RequestMapping("/share")
public class ShareController extends BaseController{
	@Resource
	private ShareService shareService;
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/shareNote.do")
	@ResponseBody
	public JsonResult addShareNote(String userId,String noteId){
		
		Share share = shareService.addShareNote(userId,noteId);
		noteService.shareNote(noteId);
		return new JsonResult(share);
		
		
	}

}
