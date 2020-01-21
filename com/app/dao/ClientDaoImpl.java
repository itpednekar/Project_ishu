package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;

@Repository
@Transactional
public class ClientDaoImpl implements IClientDao 
{
	@Autowired
    private SessionFactory sf;
    
	@Override
	public User registerClient(User u) 
	{
		sf.getCurrentSession().persist(u);
		return u;
	}

	@Override
	public User showClinetDetails(String email) 
	{
		String jpql = "select u from User u where u.email=:em";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email).getSingleResult();
	}

	@Override
	public User getUserById(int userid)
	{	
		return sf.getCurrentSession().get(User.class, userid);
	}

}
