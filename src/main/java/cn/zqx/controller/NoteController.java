package cn.zqx.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zqx.service.NoteService;
import cn.zqx.util.JsonResult;

@Controller
@RequestMapping("/note")
public class NoteController extends BaseController{
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/loadNotes.do")
	@ResponseBody
	public JsonResult loadNotes(String bookId){
		List<Map> notes = noteService.loadNotes(bookId);
		return new JsonResult(notes);
	}

}
