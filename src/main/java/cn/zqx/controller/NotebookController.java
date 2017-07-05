package cn.zqx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zqx.entity.Notebook;
import cn.zqx.service.NotebookService;
import cn.zqx.util.JsonResult;

@Controller
@RequestMapping("/book")
public class NotebookController {
	@Resource
	private NotebookService notebookService;
	
	@RequestMapping("loadbooks.do")
	@ResponseBody
	public JsonResult loadbooks(String userId){
		List<Notebook> notebooks = notebookService.listNotebooks(userId);	
		
		return new JsonResult(notebooks);
	}
}
