package c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import uitl.JDBCUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * C3P0连接池
 * @author 李泽坤
 *
 */
public class C3P0Demo {

	@Test
	public void testC3P0 (){
		//连接
		Connection conn = null;
		//预编译
		PreparedStatement ps = null;
		try {
			//1. 创建datasource
//			ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle");
			
			//默认会找 xml 中的 default-config 分支。 
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			System.out.println(dataSource.hashCode() );
			ComboPooledDataSource dataSource2 = new ComboPooledDataSource();
			System.out.println(dataSource2.hashCode()+"-------");
			//2. 设置连接数据的信息
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			
			dataSource.setJdbcUrl("jdbc:mysql://localhost/bank");
			dataSource.setUser("root");
			dataSource.setPassword("root");
			
			//2. 得到连接对象
			conn = dataSource.getConnection();
			String sql = "insert into account values(null , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "admi234n");
			ps.setInt(2, 103200);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
