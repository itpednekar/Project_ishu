package com.app.service;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.Transaction;

public interface IManagerService {
	List<Appointment> getAllAppointments();
	List<Transaction> getClientTransactionDetails();
}
