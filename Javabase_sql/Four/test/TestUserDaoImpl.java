package test;

import org.junit.Test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
/**
 * 
 * @author 李泽坤
 *
 */
public class TestUserDaoImpl {
	
	
	
	
	@Test
	public void testInsert(){
		
		UserDao dao = new UserDaoImpl();
		
		dao.insert("aobama", "911");
	}
	
	
	
	@Test
	public void testUpdate(){
		
		UserDao dao = new UserDaoImpl();
		
		dao.update(2, "itheima");
	}
	
	
	
	
	
	
	
	@Test
	public void testDelete(){
		
		UserDao dao = new UserDaoImpl();
		
		dao.delete(30);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Test
	public void testFindAll(){
		
		//面向父类编程 接口编程
		UserDao dao = new UserDaoImpl(); //体现多态的特征 
//		UserDaoImpl dao = new UserDaoImpl();
		dao.findAll();
	}
//	"10087 "+" or 1=1" === “10087 or 1=1”
	@Test
	public void testLogin(){
		UserDao dao = new UserDaoImpl();
		dao.login("admin", "100234khsdf88' or '1=1");
//		dao.login("admin", "10087 "+" or 1=1");
		
//		select * from t_user where username='admin' and password='100234khsdf88'or '1=1'
		
		
//		SELECT * FROM t_user WHERE username='admin' AND PASSWORD='10087' or '1=1'
	}
}
