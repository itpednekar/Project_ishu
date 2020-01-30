package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private IUserService service;
	
	@PostConstruct
	public void myInit() {
		System.out.println("in init " + service);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> signUp(@RequestBody User u)
	{
		System.out.println("in signUp "+ u);
		String em = u.getEmail();
		String pass = u.getPassword();
		System.out.println("em and pass" + em +" "+pass);
		User user = service.userAuthenticate(em, pass);
		System.out.println("user ::"+user);
		
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
	@PostMapping("/forgetpassword")
	public ResponseEntity<?> forgetPassword(@RequestBody User u)
	{
	System.out.println("in forgetPassword "+ u);
	String em = u.getEmail();
	System.out.println("em and pass" + em);
	User user = service.getUser(em);
	System.out.println("user ::"+user);

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
	@GetMapping("/getuserbypassword")
	public ResponseEntity<?> getUserByPassword(@RequestBody User u)
	{
	System.out.println("in get user by password");
	String pass = u.getPassword();
	System.out.println("password" +pass);
	try {
	return new ResponseEntity<User>(service.getUserByPassword(pass), HttpStatus.OK);
	}catch (RuntimeException e) {
	e.printStackTrace();
	return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

	@PutMapping("/changepaswword")
	public ResponseEntity<?> changePassword(@RequestBody User u)
	{
	System.out.println("in chnage password");
	String pass = u.getPassword();
	User user = service.getUserByPassword(pass);
	try {
	return new ResponseEntity<User>(service.changePassword(user), HttpStatus.OK);
	}catch (RuntimeException e) {
	e.printStackTrace();
	return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}
