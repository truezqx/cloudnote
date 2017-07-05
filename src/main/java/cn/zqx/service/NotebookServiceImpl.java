package cn.zqx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zqx.dao.NotebookDao;
import cn.zqx.entity.Notebook;

@Service("notebookService")
public class NotebookServiceImpl implements NotebookService{
	@Resource(name="notebookDao")
	private NotebookDao notebookDao;

	public List<Notebook> listNotebooks(String userId) {
		return notebookDao.findNotebookByUserId(userId);
	}

}
