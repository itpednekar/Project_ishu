package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
import com.app.pojos.Feedback;
import com.app.pojos.User;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sf; 
	@Override
	public User registerClient(User u) {
		sf.getCurrentSession().persist(u);
		return u;
	}
	@Override
	public User updateClient(User u) {
		sf.getCurrentSession().update(u);
		return u;
	}
	@Override
	public User getUserById(int userid) {
		return sf.getCurrentSession().get(User.class, userid);
	}
	@Override
	public Address addAddress(Address addr) {
		sf.getCurrentSession().persist(addr);
		return addr;
	}
	@Override
	public User returnRoleByEmail(String email) {
		String jpql = "select u from User u where u.email=:em";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
						.getSingleResult();
	}
	@Override
	public List<Feedback> ListUserFeedback() {
		String jpql="select f from Feedback f left outer join fetch f.user";
		return sf.getCurrentSession().createQuery(jpql, Feedback.class).getResultList();
	}
	@Override
	public Feedback insertFeedback(Feedback f) {
		sf.getCurrentSession().persist(f); 
		return f;
	}
	@Override
	public User showClientDetails(String email) 
	{
		String jpql = "select u from User u where u.email=:em";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email).getSingleResult();
	}
	
}
