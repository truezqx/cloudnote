package cn.zqx.dao;

import cn.zqx.entity.Share;

public interface ShareDao {
	public int addShareNote(Share share);
	public Share findById(String noteId);
}
