package uitl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
/**
 * 
 * @author 李泽坤
 *
 */
public class TestPool {

	@Test
	public void testPool(){
		Connection conn = null;
		PreparedStatement ps = null;
		MyDataSource dataSource = new MyDataSource();
		try {
			conn =  dataSource.getConnection();
			
			String sql = "insert into account values (null , 'xilali' , 10)";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//归还连接
			//conn.close();
			dataSource.addBack(conn);
			//JDBCUtil.release(conn, st, rs);
		}
	}
}
