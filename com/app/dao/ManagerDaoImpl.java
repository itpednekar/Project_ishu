package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Appointment;
import com.app.pojos.Transaction;

@Repository
public class ManagerDaoImpl implements IManagerDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Appointment> getAllAppointments() {
		String jpql = "select a from Appointment a";
		return sf.getCurrentSession().createQuery(jpql, Appointment.class).getResultList();
	}
	@Override
	public List<Transaction> getClientTransactionDetails() {
	String jpql = "select t from Transaction t";
	System.out.println(sf.getCurrentSession().createQuery(jpql, Transaction.class).getResultList());
	return sf.getCurrentSession().createQuery(jpql, Transaction.class).getResultList();
	}

}
