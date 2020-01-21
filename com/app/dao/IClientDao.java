package com.app.dao;

import com.app.pojos.User;

public interface IClientDao {
	User registerClient(User u);
	User showClinetDetails(String email);
	User getUserById(int userid);
}
