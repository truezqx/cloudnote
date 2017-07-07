package cn.zqx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zqx.dao.NoteDao;
import cn.zqx.dao.ShareDao;
import cn.zqx.entity.Note;
import cn.zqx.entity.Share;
import cn.zqx.util.NoteUtil;

@Service("shareService")
public class ShareServiceimpl implements ShareService{
	@Resource
	private ShareDao shareDao;
	@Resource
	private NoteDao noteDao;

	public Share addShareNote(String userId,String noteId) {
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("用户ID为空");
		}
		Share share = shareDao.findById(noteId);
		if(share!=null){
			throw new ShareException("笔记已被分享");
		}
		Note note = noteDao.findNoteById(noteId);
		String cn_share_id = NoteUtil.createId();
		String cn_share_title=note.getCn_note_title();
		String cn_share_body=note.getCn_note_body();
		share = new Share();
		share.setCn_note_id(noteId);
		share.setCn_share_body(cn_share_body);
		share.setCn_share_id(cn_share_id);
		share.setCn_share_title(cn_share_title);
		int row = shareDao.addShareNote(share);
		if(row>=1){
			return share;
		}
		return null;
	}


}
