package cn.zqx.dao;

import java.util.List;
import java.util.Map;

import cn.zqx.entity.Note;

public interface NoteDao {
	//public List<Note> findNotesByBookId(String bookId);
	public List<Map> findNotesById(String bookId);

}
