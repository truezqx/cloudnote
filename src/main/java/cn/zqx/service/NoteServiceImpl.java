package cn.zqx.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zqx.dao.NoteDao;
import cn.zqx.entity.Note;

@Service("noteService")
public class NoteServiceImpl implements NoteService{
	@Resource
	private NoteDao noteDao;
	
	public List<Map> loadNotes(String bookId) {
		List<Map> notes = noteDao.findNotesById(bookId);
		return notes;
	}

}
