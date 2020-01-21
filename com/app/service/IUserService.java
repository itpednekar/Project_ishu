package com.app.service;

import com.app.pojos.User;

public interface IUserService {

	User userAuthenticate(String email,String password);
}
