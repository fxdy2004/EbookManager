package service;

import java.sql.SQLException;

public interface UserService {
	/**
	 * 登录
	 */
	public boolean login(User user) throws SQLException;
	/**
	 * 注册
	 */
	public boolean logon(User user) throws SQLException;
	/**
	 * 忘记密码
	 * @throws SQLException 
	 */
	public boolean forgetPassword(User user) throws SQLException;
}
