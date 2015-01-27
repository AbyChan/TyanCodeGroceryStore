package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class SqlDemo2 {

	public static void main(String args[]) throws Exception { // 所有的异常抛出
		try {
			// 加载MySql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/knowledge?useUnicode=true&amp;characterEncoding=UTF-8";
			String username = "root";
			String password = "wangwenzhi";

			try {
				Connection con = DriverManager.getConnection(url, username,
						password);
				con.setAutoCommit(false);
				//String sql = "INSERT INTO `fuckyou`.`fuckfuckyou`(`id`,`haha`)VALUES('12282123','哈哈');";
				String sql = "INSERT INTO `knowledge`.`ZhidaoKnowledge`(`qstHash`,`question`)VALUES('12282123','哈哈');";
				PreparedStatement ps = con.prepareStatement(sql);
				 ps.addBatch();
		        ps.executeBatch();
		        con.commit();
		        ps.close();
		        con.close();
			} catch (SQLException se) {
				System.out.println("数据库连接失败！");
				se.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
	}

};