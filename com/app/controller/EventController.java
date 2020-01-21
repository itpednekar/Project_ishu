package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.Location;
import com.app.pojos.User;
import com.app.pojos.VenueCity;
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
	 
	
	 @PostMapping("/bookanevent/{user_id}/{eventdesc_id}/{loc_id}")
	 public ResponseEntity<?> bookAnEvent(@RequestBody Event e, @PathVariable int user_id,@PathVariable int loc_id ,@PathVariable int eventdesc_id)
	 {
		 Location loc = eventService.getLocationById(loc_id);
		 EventDesc eventDesc = eventService.getEventDescById(eventdesc_id);
		 System.out.println("in n=bookAnEvent() "+e+" User id "+user_id);
		 
		 System.out.println(e);
		 try 
		 {
			User u = clientService.getUserById(user_id);	
			loc.addEvent(e);
			u.addEvents(e);
			eventDesc.addEvent(e);
			Event event = eventService.bookAnEvent(e);
		    eventService.updateEvent(event);
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
	 
}
