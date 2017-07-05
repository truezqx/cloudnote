package test;



import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zqx.dao.UserDao;
import cn.zqx.entity.Notebook;
import cn.zqx.entity.User;
import cn.zqx.service.NoteService;
import cn.zqx.service.NotebookService;
import cn.zqx.service.UserService;

public class TestService {
	private ApplicationContext ac;
	private UserService userService;
	private NotebookService notebookService;
	private NoteService noteService;
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		 ac = new ClassPathXmlApplicationContext(conf);
		 userService = ac.getBean("userService",UserService.class);
		 notebookService = ac.getBean("notebookService",NotebookService.class);
		 noteService = ac.getBean("noteService",NoteService.class);
	}
	@Test
	public void test1() throws SQLException{
		
//		DataSource ds = ac.getBean("dbcp",DataSource.class);
//		System.out.println(ds.getConnection());
		UserDao dao = ac.getBean("userDao",UserDao.class);
		User user = dao.findByName("demo");
		System.out.println(user);
	}
	@Test//用户名错误
	public void test2(){
		userService.Login("demo", "123");
	}
	@Test//密码错误
	public void test3(){
		userService.Login("demo", "123");
	}
	@Test//登录成功
	public void test4(){
		
		User user = userService.Login("demo", "123456");
		System.out.println(user);
	}
	@Test//注册
	public void test5(){
		User user = userService.regist("zqx", "123456", null);
		System.out.println(user);
	}
	@Test
	public void test6(){
		List<Notebook> notebooks = notebookService.listNotebooks("48595f52-b22c-4485-9244-f4004255b972");
		System.out.println(notebooks);
	}
	@Test
	public void test7(){
		List<Map> notes = noteService.loadNotes("516f6f4f-eaa3-4c76-84ff-530b92c7f64d");
		System.out.println(notes);
	}

}
