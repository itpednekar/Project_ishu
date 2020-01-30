package com.app.service;

import com.app.pojos.User;

public interface IUserService {

	User userAuthenticate(String email,String password);
	User getUser(String email);
	User getUserByPassword(String password);
	User changePassword(User u);
}
