package c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import uitl.JDBCUtil;
import uitl.JDBCUtil02;
/**
 * 
 * @author 李泽坤
 *
 */
public class Test {

	public static void main(String[] args) {
		
		try {
			Connection conn = JDBCUtil02.getConn();
			
			
			conn.prepareStatement(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
