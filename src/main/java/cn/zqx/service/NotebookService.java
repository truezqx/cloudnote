package cn.zqx.service;

import java.util.List;

import cn.zqx.entity.Notebook;

public interface NotebookService {
	List<Notebook> listNotebooks(String userId);

}
