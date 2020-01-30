package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
import com.app.pojos.Appointment;
import com.app.pojos.EventDesc;
import com.app.pojos.Feedback;
import com.app.pojos.Location;
import com.app.pojos.Transaction;
import com.app.pojos.User;
import com.app.pojos.VenueCity;

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
	@Override
	public List<EventDesc> listAllEventDesc() {
		String jpql = "select e from EventDesc e";
		return sf.getCurrentSession().createQuery(jpql,EventDesc.class).getResultList();
	}
	@Override
	public List<Location> listLocationByVenueCityId(int venueCityId) {
		String jpql = "select l from Location l left outer join fetch l.venueCity where l.venueCity.venueCityId=:venueCityid";
		return sf.getCurrentSession().createQuery(jpql, Location.class).setParameter("venueCityid", venueCityId).getResultList();
	}
	@Override
	public Appointment bookAppointment(Appointment appoint) {
		 sf.getCurrentSession().persist(appoint);
		    return appoint;
	}
  @Override
    public Transaction insertPaymentDetails(Transaction trans) {
    sf.getCurrentSession().persist(trans);
    return trans;
    }
	
}
