package cn.zqx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zqx.entity.Notebook;
import cn.zqx.service.NotebookNotFoundException;
import cn.zqx.service.NotebookService;
import cn.zqx.service.UserNotFoundException;
import cn.zqx.util.JsonResult;

@Controller
@RequestMapping("/book")
public class NotebookController {
	@Resource
	private NotebookService notebookService;
	
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public JsonResult loadbooks(String userId){
		List<Notebook> notebooks = notebookService.listNotebooks(userId);	
		
		return new JsonResult(notebooks);
	}
	@RequestMapping("/addbook.do")
	@ResponseBody
	public JsonResult addbook(String userId,String bookName){
		try{
			Notebook notebook = notebookService.addNotebook(userId, bookName);
			return new JsonResult(notebook);
		}catch(UserNotFoundException e){
			e.printStackTrace();
			return new JsonResult(4,e);
		}catch(NotebookNotFoundException e){
			e.printStackTrace();
			return new JsonResult(5,e);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(6,e);
		}
	}
	
	@RequestMapping("/removebook.do")
	@ResponseBody
	public JsonResult removebook(String userId,String bookId){
		try{
			Notebook notebook = notebookService.removeBook(userId, bookId);
			return new JsonResult(notebook);
		}catch(UserNotFoundException e){
			e.printStackTrace();
			return new JsonResult(4,e);
		}catch(NotebookNotFoundException e){
			e.printStackTrace();
			return new JsonResult(5,e);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(6,e);
		}
	}
}
