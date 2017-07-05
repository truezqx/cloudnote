package test;



import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zqx.dao.NoteDao;
import cn.zqx.dao.NotebookDao;
import cn.zqx.dao.UserDao;
import cn.zqx.entity.Notebook;
import cn.zqx.entity.User;

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
		
	
	

}
