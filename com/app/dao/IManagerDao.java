package com.app.dao;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.Transaction;

public interface IManagerDao {
	List<Appointment> getAllAppointments();
	List<Transaction> getClientTransactionDetails();
}
