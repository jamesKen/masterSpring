package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private LoginLogDao loginLogDao;

	public boolean hasMatchUser(String userName, String password) {
		int matchCount = userDao.getMatchCount ( userName,password );
		return matchCount > 0;
	}

	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName ( userName );
	}

//	@Transactional
	public void loginSuccess(User user) {
		user.setCredits ( 5+user.getCredits () );
		LoginLog loginLog = new LoginLog ();
		loginLog.setUserId ( user.getUserId () );
		loginLog.setIp ( user.getLastIp () );
		loginLog.setLoginDate ( user.getLastVisit () );
		userDao.updateLoginInfo ( user );
		loginLogDao.insertLoginLog ( loginLog );
	}
}
