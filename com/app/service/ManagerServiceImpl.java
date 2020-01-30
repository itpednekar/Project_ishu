package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IManagerDao;
import com.app.pojos.Appointment;
import com.app.pojos.Transaction;

@Service
@Transactional
public class ManagerServiceImpl implements IManagerService {
	
	@Autowired
	private IManagerDao managerDao;

	@Override
	public List<Appointment> getAllAppointments() {
		return managerDao.getAllAppointments();
	}

	@Override
	public List<Transaction> getClientTransactionDetails() {
		// TODO Auto-generated method stub
		return managerDao.getClientTransactionDetails();
	}

}
