package dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
//针对增加  、 删除 、 修改
queryRunner.update(sql)

//针对查询
queryRunner.query(sql, rsh);*/
/**
 * queryRunner
 * @author 李泽坤
 *
 */
public class TestDBUtils {

	
	@Test
	public void testInsert() throws SQLException, InstantiationException, IllegalAccessException{
		
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		//dbutils 只是帮我们简化了CRUD 的代码， 但是连接的创建以及获取工作。 不在他的考虑范围
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
	
		
		//增加
		//queryRunner.update("insert into account values (null , ? , ? )", "aa" ,1000);
		
		//删除
//		queryRunner.update("delete from account where id = ?", 5);
		
		//更新
		//queryRunner.update("update account set money = ? where id = ?", 10000000 , 6);
		
		
		//去执行查询，查询到的数据还是在哪个result里面。 然后调用下面的handle方法，由用户手动去封装。
		/*Account  account =  queryRunner.query("select * from account where id = ?", new ResultSetHandler<Account>(){

			@Override
			public Account handle(ResultSet rs) throws SQLException {
				Account account  =  new Account();
				while(rs.next()){
					String name = rs.getString("name");
					int money = rs.getInt("money");
					
					account.setName(name);
					account.setMoney(money);
				}
				return account;
			}
			 
		 }, 6);
		
		System.out.println(account.toString());
		*/
		
		
		// 通过类的字节码得到该类的实例
		
/*		
		Account a = new Account();
		
		//创建一个类的实例。
		Account a1=  Account.class.newInstance();
		*/
		
		
		//查询单个对象
		Account account = queryRunner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), 8);
		System.out.println(account.toString());
		
		/*List<Account> list = queryRunner.query("select * from account ",
				new BeanListHandler<Account>(Account.class));
		
		for (Account account : list) {
			System.out.println(account.toString());
		}*/
	}
}
