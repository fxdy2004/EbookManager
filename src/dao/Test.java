package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args)
	{
		String driverName = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://127.0.0.1:3306/E_books?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String userName = "root";
		String userPwd = "123456";
		Connection dbConn = null;
		try
		{
			Class.forName(driverName);
			System.out.println("连接数据库...");
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("连接数据库成功");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.print("连接失败");
		}
	}
}
