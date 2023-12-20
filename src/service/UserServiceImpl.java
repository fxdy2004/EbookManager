package service;

import java.sql.SQLException;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(User user) throws SQLException {
		User user1 = userDao.loginName(user);
		User user2 = userDao.loginEmail(user);
		User user3 = userDao.loginPhone(user);
		if(user1==null) {
			if(user2==null) {
				if(user3==null) {
					return null;
				}
				else {
					return user3;
				}
			}else {
				return user2;
			}
		}else {
			return user1;
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
