package jdbc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.util.JDBCUtil;

/**
 * 
 * @author 李泽坤
 *
 */
public class MainTest {

	public static void main(String[] args) {
		
		
		//查询
		Connection conn  = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//1. 获取连接对象
			conn = JDBCUtil.getConn();
			//2. 根据连接对象，得到statement
			st = conn.createStatement();
			
			//3. 执行sql语句，返回ResultSet
			String sql = "select * from t_stu";
			rs= st.executeQuery(sql);
			
			//4. 遍历结果集
			while(rs.next()){
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				System.out.println(name+"   " + age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st, rs);
		}
		
	}

}
