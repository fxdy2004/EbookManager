package service;

import java.sql.SQLException;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean login(User user) throws SQLException {
		if(userDao.loginName(user)||userDao.loginEmail(user)||userDao.loginPhone(user)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean logon(User user) throws SQLException {
		if(userDao.findPhone(user.getPhone())==false)
			return userDao.logon(user);
		return false;
	}

	@Override
	public boolean forgetPassword(User user) throws SQLException {
		return userDao.forgetPassword(user);
	}
}
