package cn.zqx.service;

import java.util.List;
import java.util.Map;

public interface NoteService {
	List<Map> loadNotes(String bookId);

}
