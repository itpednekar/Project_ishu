package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IClientDao;
import com.app.pojos.Address;
import com.app.pojos.Appointment;
import com.app.pojos.EventDesc;
import com.app.pojos.Feedback;
import com.app.pojos.Location;
import com.app.pojos.Transaction;
import com.app.pojos.User;

@Service
@Transactional
public class ClientServiceImpl implements IClientService
{
	@Autowired
	private IClientDao clientDao;

	@Override
	public User registerClient(User u) {
		return clientDao.registerClient(u);
	}

	@Override
	public User updateClient(User u) {
		return clientDao.updateClient(u);
	}

	@Override
	public User getUserById(int userid) {
		return clientDao.getUserById(userid);
	}

	@Override
	public Address addAddress(Address addr) {
		return clientDao.addAddress(addr);
	}

	@Override
	public User returnRoleByEmail(String email) {
		return clientDao.returnRoleByEmail(email);
	}

	@Override
	public List<Feedback> ListUserFeedback() {
		return clientDao.ListUserFeedback();
	}

	@Override
	public Feedback insertFeedback(Feedback f) {
		return clientDao.insertFeedback(f);
	}
	@Override
	public User showClientDetails(String email) 
	{
		return clientDao.showClientDetails(email);
	}

	@Override
	public List<EventDesc> listAllEventDesc() {
		// TODO Auto-generated method stub
		return clientDao.listAllEventDesc();
	}

	@Override
	public List<Location> listLocationByVenueCityId(int venueCityId) {
		// TODO Auto-generated method stub
		return clientDao.listLocationByVenueCityId(venueCityId);
	}

	@Override
	public Appointment bookAppointment(Appointment appoint) {
		// TODO Auto-generated method stub
		return clientDao.bookAppointment(appoint);
	}

	@Override
	public Transaction insertPaymentDetails(Transaction trans) {
		// TODO Auto-generated method stub
		return clientDao.insertPaymentDetails(trans);
		}
}
