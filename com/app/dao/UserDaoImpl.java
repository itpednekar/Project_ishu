package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao
{
	@Autowired
	private SessionFactory sf;

	@Override
	public User userAuthenticate(String email, String password) {
		String jpql = "select u from User u where u.email=:em and u.password=:pa";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pa",password).getSingleResult();
	}
	
}
