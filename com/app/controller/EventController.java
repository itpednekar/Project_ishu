package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.Food;
import com.app.pojos.FoodEvent;
import com.app.pojos.Location;
import com.app.pojos.Transaction;
import com.app.pojos.User;
import com.app.pojos.VenueCity;
import com.app.service.IAdminService;
import com.app.service.IClientService;
import com.app.service.IEventService;

@RestController
@CrossOrigin
@RequestMapping("/event")
public class EventController 
{
	 @Autowired
     private IEventService eventService;
	 @Autowired
	 private IClientService clientService;
	 @Autowired 
	 private IAdminService adminService;
	 
	
	 @PostMapping("/bookanevent/{user_id}/{eventdesc_id}/{loc_id}/{food_id}")
	 public ResponseEntity<?> bookAnEvent(@RequestBody Event e, @PathVariable int user_id,@PathVariable int loc_id 
			 							,@PathVariable int eventdesc_id, @PathVariable int food_id
			 							)
	 {
		 double totleCost = 0;
		 int mu = 0;
		 int th = 0;
		 Location loc = eventService.getLocationById(loc_id);
		 EventDesc eventDesc = eventService.getEventDescById(eventdesc_id);
		 Food food = adminService.getFoodTypeById(food_id);
		 FoodEvent foodEvent = new FoodEvent();
		 
		 if(e.getTheme() != null)
		 {
			 if(e.getTheme().equals("true"))
			 mu = 5000;
		 }
		 if(e.getMusicSystem() != null)
		 {
			 if(e.getMusicSystem().equals("true"))
			 th = 4000;
		 }
		 
		 totleCost = eventDesc.getEventCost() + mu + th + (loc.getLocationCost() + e.getNoOfGuests()*food.getCost()
				     + e.getDecorationBudget()) * e.getEventDuration();
		 e.setTotalCost(totleCost);
		 System.out.println("Total cost : "+totleCost);
		 System.out.println("in n=bookAnEvent() "+e+" User id "+user_id);
		 food.addFoodEvent(foodEvent);
		 System.out.println(e);
		 try 
		 {
			User u = clientService.getUserById(user_id);	
			loc.addEvent(e);
			u.addEvents(e);
			eventDesc.addEvent(e);
			Event event = eventService.bookAnEvent(e);
			event.addFoodEvent(foodEvent);
		    eventService.updateEvent(e);
		    eventService.insertFoodEvent(foodEvent);
			return new ResponseEntity<Event>(event, HttpStatus.CREATED);
		 }
		 catch (RuntimeException cause) {
			 cause.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
	
	 @PostMapping("/bookanevent")
	 public ResponseEntity<?> listVenueCity( )
	 {
		 System.out.println("in listVenueCity()");
		 try
		 {
			 return new ResponseEntity<List<VenueCity>>(eventService.listVenueCity(), HttpStatus.OK);
		 }
		 catch (RuntimeException e) {
			 e.printStackTrace();
			 return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
	 
	 @PostMapping("/paymentdetails/{eventId}")
	 public ResponseEntity<?> paymentDetails(@RequestBody Transaction trans,@PathVariable int eventId)
	 {
		 System.out.println("in payment details...");
		 Event event = adminService.getEventById(eventId);
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    Date date = new Date();  
		 trans.setTransDate(date);
		 event.addTrans(trans);
		 trans.setPaymentStatus("Complete");
	
		 try {
		 return new ResponseEntity<Transaction>(clientService.insertPaymentDetails(trans), HttpStatus.OK);
		 }catch (RuntimeException e) {
		 e.printStackTrace();
		 return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }
	 
}
