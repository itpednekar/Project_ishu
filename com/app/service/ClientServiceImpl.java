package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IClientDao;
import com.app.pojos.User;

@Service
public class ClientServiceImpl implements IClientService 
{
	@Autowired
	private IClientDao clientDao;

	@Override
	public User registerClient(User u) 
	{
		return clientDao.registerClient(u);
	}

	@Override
	public User showClinetDetails(String email) 
	{
		return clientDao.showClinetDetails(email);
	}

	@Override
	public User getUserById(int userid) {
		// TODO Auto-generated method stub
		return clientDao.getUserById(userid);
	}

}
