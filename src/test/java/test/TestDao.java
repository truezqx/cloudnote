package test;



import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.jmx.snmp.Timestamp;

import cn.zqx.dao.NoteDao;
import cn.zqx.dao.NotebookDao;
import cn.zqx.dao.UserDao;
import cn.zqx.entity.Note;
import cn.zqx.entity.Notebook;
import cn.zqx.entity.User;
import cn.zqx.util.NoteUtil;

public class TestDao {
	private ApplicationContext ac;
	private UserDao userDao;
	private NotebookDao notebookDao;
	private NoteDao noteDao;
	
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		 ac = new ClassPathXmlApplicationContext(conf);
		 userDao = ac.getBean("userDao",UserDao.class);
		 notebookDao = ac.getBean("notebookDao",NotebookDao.class);
		 noteDao = ac.getBean("noteDao",NoteDao.class);
	}
	@Test
	public void test1() throws SQLException{
		
//		DataSource ds = ac.getBean("dbcp",DataSource.class);
//		System.out.println(ds.getConnection());
		User user = userDao.findByName("demo1");
		System.out.println(user);
	}
	@Test//插入数据
	public void test2(){
		User user = new User();
		user.setId("1");
		user.setName("zqx");
		user.setPassword("123456");
		user.setToken(null);
		user.setNick("aaa");
		System.out.println(user);
		userDao.addUser
		(user);
	}
	@Test
	public void test3(){
		List<Notebook> list= notebookDao.findNotebookByUserId("0b164152-4fd0-4f9a-b272-0b6d4ed316f8");
		System.out.println(list);
	}
	@Test
	public void test4(){
		List<Map> notes = noteDao.findNotesById("516f6f4f-eaa3-4c76-84ff-530b92c7f64d");
		System.out.println(notes);
	}
	@Test
	public void test5(){
		Note note = noteDao.findNoteById("3621cb2a-a40d-496f-8505-48725462f68d");
		System.out.println(note);
	}
	@Test
	public void test6(){
		User user = userDao.findById("0b164152-4fd0-4f9a-b272-0b6d4ed316f8");
		System.out.println(user);
	}
	@Test
	public void test7(){
		Note note = new Note();
		note.setCn_note_id("3621cb2a-a40d-496f-8505-48725462f68d");
		note.setCn_note_title("测试1111111");
		note.setCn_note_body("测试11111");
		Long time = System.currentTimeMillis();
		System.out.println(time);
		note.setCn_note_last_modify_time(time);
		int i =noteDao.updateNoteById(note);
		System.out.println(i);
	}
	@Test
	public void test8(){
		Notebook notebook = new Notebook();
		notebook.setCn_notebook_id(NoteUtil.createId());
		notebook.setCn_notebook_name("测试zqx");
		notebook.setCn_user_id("48595f52-b22c-4485-9244-f4004255b972");
		notebook.setCn_notebook_desc(null);
		notebook.setCn_notebook_type_id(null);
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(now);
		notebook.setCn_notebook_createtime(time);
		System.out.println(notebook);
		int row = notebookDao.addNotebook(notebook);
		System.out.println(row);
	}
		
	
	

}
