package uitl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	//数据库的链接信息
	private static final String URL="jdbc:mysql://127.0.0.1:3306/e_books?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private static final String USERNAME="root";
	private static final String PASSWORD="123456";
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	//按理来说,这些东西都应该写在配置文件里的, properties, 有时间再改呗
	
	private DBUtil(){};
	
	//加载驱动
	static {
		try {
			Class.forName(DRIVER);
			System.out.print("数据库,");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//创建连接
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("启动!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return connection;
	}
	//关闭连接
	public static void close(ResultSet rs,Statement statement,Connection connection) throws SQLException {
		if (rs != null) {
	        rs.close();
	    }
	    if (statement != null) {
	        statement.close();
	    }
	    if (connection != null) {
	        connection.close();
	    }
	    System.out.println("数据库连接已关闭！");
	}
//	//test
//	public static void main(String[] args) {
//		System.out.println(DBUtil.getConnection());
//	}
}
