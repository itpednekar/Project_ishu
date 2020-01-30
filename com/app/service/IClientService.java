package com.app.service;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Appointment;
import com.app.pojos.EventDesc;
import com.app.pojos.Feedback;
import com.app.pojos.Location;
import com.app.pojos.Transaction;
import com.app.pojos.User;

public interface IClientService {
	User registerClient(User u);
	User updateClient(User u);
	User getUserById(int userid);
	Address addAddress(Address addr);
	User returnRoleByEmail(String email);
	List<Feedback> ListUserFeedback();
	Feedback insertFeedback(Feedback f);
	User showClientDetails(String email);
	List<EventDesc> listAllEventDesc();
	List<Location> listLocationByVenueCityId(int venueCityId);
	Appointment bookAppointment(Appointment appoint);
	Transaction insertPaymentDetails(Transaction trans);
}
