package com.app.service;

import com.app.pojos.User;

public interface IClientService 
{
	User registerClient(User u);
	User showClinetDetails(String email);
	User getUserById(int userid);
}
