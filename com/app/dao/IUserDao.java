package com.app.dao;

import com.app.pojos.User;

public interface IUserDao 
{
	User userAuthenticate(String email,String password);
	User getUser(String email);
	 User getUserByPassword(String password);
	 User changePassword(User u);
}
