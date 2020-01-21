package com.app.dao;

import com.app.pojos.User;

public interface IUserDao 
{
	User userAuthenticate(String email,String password);
}
