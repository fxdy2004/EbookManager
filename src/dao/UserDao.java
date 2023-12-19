package dao;

import java.sql.SQLException;

import service.User;

public interface UserDao {
	/**
	 * 查询数据库并返回bool值
	 */
	public boolean loginName(User user) throws SQLException;
	public boolean loginEmail(User user) throws SQLException;
	public boolean loginPhone(User user) throws SQLException;
	/**
	 * 将新账号加入数据库
	 */
	public boolean logon(User user) throws SQLException;
	/**
	 * 将用户的新密码覆盖旧密码
	 * @return 
	 */
	public boolean forgetPassword(User user) throws SQLException;
	/**
	 * 特征属性查找
	 */
	public boolean findName(String name) throws SQLException;
	public boolean findEmail(String email) throws SQLException;
	public boolean findPhone(String phone) throws SQLException;
}
