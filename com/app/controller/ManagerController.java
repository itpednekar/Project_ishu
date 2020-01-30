package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Appointment;
import com.app.pojos.Transaction;
import com.app.service.IManagerService;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	IManagerService managerService;
	
	@GetMapping("/getallappointments")
	public ResponseEntity<?> getAllAppointments()
	{
		System.out.println("getAllAppointments");
		try {
			return new ResponseEntity<List<Appointment>>(managerService.getAllAppointments(), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/clienttransactionstatus")
	public ResponseEntity<?> getClientTransactionDetails()
	{
		System.out.println("in get Client Transaction Details");
		try {
		return new ResponseEntity<List<Transaction>>(managerService.getClientTransactionDetails(), HttpStatus.OK);
		}catch (RuntimeException e) {
		e.printStackTrace();
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
