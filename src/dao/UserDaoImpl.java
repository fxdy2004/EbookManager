package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.User;
import uitl.DBUtil;

public class UserDaoImpl implements UserDao {
	private final static String loginName = "select * from tb_user_table where username = ? and password = ?";
	private final static String loginEmail = "select * from tb_user_table where email = ? and password = ?";
	private final static String loginPhone = "select * from tb_user_table where phone = ? and password = ?";
	private final static String logon = "insert into tb_user_table (username, password, phone, category_id) values (?, ?, ?, ?)";
	private final static String forgetPassword = "update tb_user_table set password = ? where phone = ?";
	private final static String findName = "select * from tb_user_table where username = ?";
	private final static String findEmail = "select * from tb_user_table where email = ?";
	private final static String findPhone = "select * from tb_user_table where phone = ?";
	
	
	static Connection conn = null;
	static PreparedStatement statement = null;
	
	public UserDaoImpl() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public boolean loginName(User user) throws SQLException {
		statement = conn.prepareStatement(loginName);
		statement.setString(1, user.getUserName());
		statement.setString(2, user.getPassword());
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean loginEmail(User user) throws SQLException {
		statement = conn.prepareStatement(loginEmail);
		statement.setString(1, user.getUserName());
		statement.setString(2, user.getPassword());
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean loginPhone(User user) throws SQLException {
		statement = conn.prepareStatement(loginPhone);
		statement.setString(1, user.getUserName());
		statement.setString(2, user.getPassword());
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean logon(User user) throws SQLException {
		statement = conn.prepareStatement(logon);
		statement.setString(1, user.getUserName());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getPhone());
		statement.setInt(4, 2);
		statement.executeUpdate();
		return true;
	}

	@Override
	public boolean forgetPassword(User user) throws SQLException {
		statement = conn.prepareStatement(forgetPassword);
		statement.setString(1, user.getPassword());
		statement.setString(2, user.getPhone());
		int result = statement.executeUpdate();
		if(result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean findName(String name) throws SQLException {
		statement = conn.prepareStatement(findName);
		statement.setString(1, name);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean findEmail(String email) throws SQLException {
		statement = conn.prepareStatement(findEmail);
		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean findPhone(String phone) throws SQLException {
		statement = conn.prepareStatement(findPhone);
		statement.setString(1, phone);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			return true;
		}else {
			return false;
		}
	}
}
