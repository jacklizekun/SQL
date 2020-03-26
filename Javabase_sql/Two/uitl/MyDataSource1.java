package uitl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 这是一个数据库连接池
 * 一开始先往池子里面放10个连接
 * 
 * 	1. 开始创建10个连接。
 * 
 * 	2. 来的程序通过getConnection获取连接
 * 
 * 	3. 用完之后，使用addBack 归还连接。
 * 
 * 	4. 扩容。 
 * 
 * 
 * 问题： 
 * 
 * 		1. sun公司针对数据库连接池定义的一套规范。 
 * 	
 * 	1. 需要额外记住 addBack方法
 * 
 * 	2. 单例。
 * 
 * 	3. 无法面向接口编程。 
 * 
 * 		UserDao dao = new UserDaoImpl();
 * 		dao.insert();
 * 
 * 
 * 		DataSource dataSource = new MyDataSource();
 * 
 * 		因为接口里面没有定义addBack方法。 
 * 
 * 	4. 怎么解决?  
 * 		
 */
public class MyDataSource1 implements DataSource {
	
	List <Connection> list = new ArrayList<Connection>();
	
	public  MyDataSource1() {
		for (int i = 0; i < 10; i++) {
			Connection conn = JDBCUtil.getConn();
			list.add(conn);
		}
	}
	
	
//	该连接池对外公布的获取连接的方法
	@Override
	public Connection getConnection() throws SQLException {
		//来拿连接的时候，先看看，池子里面还有没有。
		if(list.size() == 0 ){
			for (int i = 0; i < 5; i++) {
				Connection conn = JDBCUtil.getConn();
				list.add(conn);
			}
		}
		
		//remove(0) ---> 移除第一个。 移除的是集合中的第一个。  移除的是开始的那个元素
		Connection conn = list.remove(0);
		
		//在把这个对象抛出去的时候， 对这个对象进行包装。
		Connection connection = new ConnectionWrap(conn, list);
		
		return connection;
	}
	
	/**
	 * 用完之后，记得归还。
	 * @param conn
	 */
	public void addBack(Connection conn){
		list.add(conn);
	}
	
	//----------------------------

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
