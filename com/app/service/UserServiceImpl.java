package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService
{
	@Autowired
	private IUserDao dao;

	@Override
	public User userAuthenticate(String email, String password) {
		return dao.userAuthenticate(email, password);
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return dao.getUser(email);
	}

	@Override
	public User getUserByPassword(String password) {
		// TODO Auto-generated method stub
		return dao.getUserByPassword(password);
	}

	@Override
	public User changePassword(User u) {
		// TODO Auto-generated method stub
		return dao.changePassword(u);
	}

}
