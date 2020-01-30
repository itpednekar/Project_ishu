package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Address;
import com.app.pojos.Appointment;
import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.Feedback;
import com.app.pojos.Location;
import com.app.pojos.Manager;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.service.IAdminService;
import com.app.service.IClientService;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IAdminService adimService;
	
	@PostConstruct
	public void myInit() {
		System.out.println("in init " + clientService);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> clientRegister(@RequestBody User u)
	{
		System.out.println("in client register" + u);
		try {
			String role = "CLIENT";
			u.setRole(UserRole.valueOf(role));
			return new ResponseEntity<User>(clientService.registerClient(u), HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{user_id}")
	public ResponseEntity<?> updateClient(@RequestBody Address addr,
										@PathVariable int user_id)
	{
		System.out.println("in update client" + addr);
		System.out.println("user id" +user_id);
		try {
			User user = clientService.getUserById(user_id);
			clientService.addAddress(addr);
			user.addAddress(addr);
			return new ResponseEntity<User>(clientService.updateClient(user), HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getrole")
	public ResponseEntity<?> returnRoleByEmail(@RequestParam String email)
	{
		System.out.println("in return role by email"+email);
		try {
			User u = clientService.returnRoleByEmail(email);
			UserRole role = u.getRole();
			return new ResponseEntity<UserRole>(role, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/listfeedback")
	public ResponseEntity<?> listUserFeedback()
	{
		System.out.println("in list user feedback");
		try {
			List<Feedback> list = clientService.ListUserFeedback();
			if(list.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Feedback>>(list, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping("/insertfeedback/{user_id}")
	public ResponseEntity<?> insertFeedback(@RequestBody Feedback f ,@PathVariable int user_id)
	{
		System.out.println("in insert feedback" +user_id +"  "+f);
		try {
		User u = clientService.getUserById(user_id);
		u.addFeedback(f);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		   Date date = new Date();  
		   System.out.println(formatter.format(date));  
		 
		f.setFeedbackDate(date);
		return new ResponseEntity<Feedback>(clientService.insertFeedback(f), HttpStatus.OK);
		}catch (RuntimeException e) {
		e.printStackTrace();
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/mydetails")
	   public ResponseEntity<?> showClientDetails(@RequestBody User u)
	   {
		   String em = u.getEmail();
			System.out.println("em and pass" + em );
			User user = clientService.showClientDetails(em);
			System.out.println("user" +user); 
			try{ 
				if(user != null) 
					return new ResponseEntity<User>(user, HttpStatus.OK);
				 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			 catch (RuntimeException e) 
			{
			  e.printStackTrace(); 
			  return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR); 
			}
	   }
	@GetMapping("/listeventdesc")
	public ResponseEntity<?> listAllEventDesc()
	{
		System.out.println("listAllEventDesc()");
		try {
			return new ResponseEntity<List<EventDesc>>(clientService.listAllEventDesc(), HttpStatus.OK);
		}
		catch (RuntimeException e) 
		{
			  e.printStackTrace(); 
			  return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	@GetMapping("/listlocationbyvenuecityid/{venueCityId}")
	public ResponseEntity<?> listLocationByVenueCityId(@PathVariable int venueCityId)
	{
		System.out.println("listLocationByVenueCityId()");
		try {
			return new ResponseEntity<List<Location>>(clientService.listLocationByVenueCityId(venueCityId), HttpStatus.OK);
		}
		catch (RuntimeException e) 
		{
			  e.printStackTrace(); 
			  return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	@PostMapping("/bookappointment/{eventId}/{managerId}")
	public ResponseEntity<?> bookAppointment(@RequestBody Appointment appoint,@PathVariable int eventId,@PathVariable int managerId)
	{
		System.out.println("in book appointment");
		Event event = adimService.getEventById(eventId);
		Manager mgr = adimService.getManagerById(managerId);
		event.addAppointment(appoint);
		mgr.addAppointmentsList(appoint);
		try {
		return new ResponseEntity<Appointment>(clientService.bookAppointment(appoint), HttpStatus.OK);
		}catch (RuntimeException e) {
		e.printStackTrace();
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
  
}
