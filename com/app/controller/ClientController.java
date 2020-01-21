package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.service.IClientService;



@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController 
{
   @Autowired
   private IClientService clientService;
   
   @PostConstruct
   public void myInit()
   {
	   System.out.println("in init of "+getClass().getName());
   }
   
   @PostMapping("/register")
   public ResponseEntity<?> registerClient(@RequestBody User u)
   {
	   System.out.println("in registerClient() of "+getClass().getName());
	   String role = "CLIENT";
	   u.setRole(UserRole.valueOf(role));
	   User user = clientService.registerClient(u);
	   System.out.println("User details : "+user);
	   try
	   {
		  return new ResponseEntity<User>(user, HttpStatus.OK);
	   }
	   catch (RuntimeException e) {
		e.printStackTrace();
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
   }
   @PostMapping("/mydetails")
   public ResponseEntity<?> showClientDetails(@RequestBody User u)
   {
	   String em = u.getEmail();
		System.out.println("em and pass" + em );
		User user = clientService.showClinetDetails(em);
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
}
