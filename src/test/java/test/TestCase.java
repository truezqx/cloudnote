package test;



import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zqx.dao.UserDao;
import cn.zqx.entity.User;
import cn.zqx.service.UserService;

public class TestCase {
	private ApplicationContext ac;
	private UserService service;
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		 ac = new ClassPathXmlApplicationContext(conf);
		 service = ac.getBean("userService",UserService.class);
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
		service.Login("demo", "123");
	}
	@Test//密码错误
	public void test3(){
		service.Login("demo", "123");
	}
	@Test//登录成功
	public void test4(){
		
		User user = service.Login("demo", "123456");
		System.out.println(user);
	}
	
	

}
