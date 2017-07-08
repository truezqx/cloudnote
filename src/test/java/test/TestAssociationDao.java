package test;



import java.awt.print.Book;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zqx.dao.AssociationDao;
import cn.zqx.entity.Notebook;

public class TestAssociationDao {
	private ApplicationContext ac;
	private AssociationDao dao;
	
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		 ac = new ClassPathXmlApplicationContext(conf);
		 dao = ac.getBean("associationDao",AssociationDao.class);
	}
	@Test//关联映射
	public void test1(){
		Notebook book = dao.findById("0fb17cd6-db93-428c-b2e0-154cb23a6d15");
		System.out.println(book.getUser().getCn_user_name());
		System.out.println(book);
	}
	@Test
	public void test2(){
		List<Notebook> books = dao.findAllBook();
		for(Notebook book:books){
			System.out.println(book);
		}
	}


		
	
	

}
