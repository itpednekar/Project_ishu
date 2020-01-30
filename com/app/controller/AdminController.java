package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Address;
import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.Food;
import com.app.pojos.Location;
import com.app.pojos.Manager;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.pojos.VenueCity;
import com.app.pojos.foodCategory;
import com.app.service.IAdminService;
import com.app.service.IClientService;
import com.app.service.IEventService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private IClientService clientService;
	@Autowired
	private IEventService eventService;
	
	@PostConstruct
	public void myInit() {
		System.out.println("in init " + adminService);
	}
	
	@GetMapping("/listusers")
	public ResponseEntity<?> listUsers()
	{
		System.out.println("in list users ");
		try {
			List<User> userList = adminService.listUsers();
			if(userList.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/listevents")
	public ResponseEntity<?> listEvents()
	{
		System.out.println("in list events..");
		try {
			List<Event> eventList = adminService.listEvents();
			if(eventList.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Event>>(eventList, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/listeventdesc")
	public ResponseEntity<?> listEventDesc()
	{
		System.out.println("in list event desc ");
		try {
			List<EventDesc> eventDescList = adminService.listEventDesc();
			if(eventDescList.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<EventDesc>>(eventDescList, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/listvenuecity")
	public ResponseEntity<?> listVenueCity()
	{
		System.out.println("in list venue city");
		try {
			List<VenueCity> venueCityList = adminService.listVenueCity();
			if(venueCityList.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<VenueCity>>(venueCityList, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/listlocation")
	public ResponseEntity<?> listLocation()
	{
		System.out.println("in list location");
		try {
			List<Location> locationList = adminService.listLocation();
			if(locationList.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Location>>(locationList, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/listfoodtype")
	public ResponseEntity<?> listFoodType()
	{
		System.out.println("in list food type");
		try {
			List<Food> foodTypeList = adminService.listFoodType();
			if(foodTypeList.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Food>>(foodTypeList, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/inserteventdesc/{mgr_id}")
	public ResponseEntity<?> insertEventDesc(@RequestBody EventDesc ed,@PathVariable int mgr_id)
	{
		System.out.println("in insert event desc.."+ed);
		Manager mgr = adminService.getManagerById(mgr_id);
		mgr.addEventDesc(ed);
		try {
			return new ResponseEntity<EventDesc>(adminService.insertEventDesc(ed), HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping("/addmanager")
	public ResponseEntity<?> addManager(@RequestBody User mgr)
	{
		System.out.println("in add manager "+ mgr);
		try {
			Manager m = new Manager();
			String role = "MANAGER";
			mgr.setRole(UserRole.valueOf(role));
			mgr.addManager(m);
			return new ResponseEntity<User>(adminService.addManager(mgr), HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/addaddressofmanager/{user_id}")
	public ResponseEntity<?> addAddressOfManager(@RequestBody Address addr,@PathVariable int user_id)
	{

		System.out.println("in add address of manager" + addr);
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
	@PostMapping("/insertvenuecity")
	public ResponseEntity<?> insertVenueCity(@RequestBody VenueCity vc)
	{
		System.out.println("in insert venue city");
		try {
			if(vc != null)
				return new ResponseEntity<VenueCity>(adminService.insertVenueCity(vc), HttpStatus.OK);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/insertfood")
	public ResponseEntity<?> insertFoodType(@RequestBody Food food)
	{
		System.out.println("in insert food type");
		try {
			if(food != null)
				return new ResponseEntity<Food>(adminService.insertFood(food), HttpStatus.OK);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/geteventdescbyid/{eventDescId}")
	public ResponseEntity<?> getEventDescById(@PathVariable int eventDescId)
	{
		System.out.println("in get event desc by id");
		try {
			return new ResponseEntity<EventDesc>(adminService.getEventDescById(eventDescId), HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updateeventdesc/{eventDescId}/{mgrId}")
	public ResponseEntity<?> updateEventDesc(@RequestBody EventDesc ed,@PathVariable int eventDescId,@PathVariable int mgrId)
	{
		System.out.println("in update event desc");
		EventDesc evd = adminService.getEventDescById(eventDescId);
		Manager mgr = adminService.getManagerById(mgrId);
		if(evd == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		double eventCost = ed.getEventCost();
		evd.setMgr(mgr);
		evd.setEventCost(eventCost);
		try
		{
			return new ResponseEntity<EventDesc>(adminService.updateEventDesc(evd), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getfoodtypebyid/{foodTypeId}")
	public ResponseEntity<?> getFoodTypeById(@PathVariable int foodTypeId)
	{
		System.out.println("in get food type by id");
		try {
			return new ResponseEntity<Food>(adminService.getFoodTypeById(foodTypeId), HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updatefoodtype")
	public ResponseEntity<?> updateFoodType(@RequestBody Food food)
	{
		System.out.println("in update food type");
		Food oldfood = adminService.getFoodTypeById(food.getFoodId());
		if(oldfood == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		oldfood.setFoodType(food.getFoodType());
		oldfood.setCategory(food.getCategory());
		oldfood.setFoodSubMenu(food.getFoodSubMenu());
		try {
			return new ResponseEntity<Food>(adminService.updateFoodType(oldfood), HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/deletevenuecity/{venueCity_id}")
	public ResponseEntity<?> deleteVenueCity(@PathVariable int venueCity_id)
	{
		System.out.println("in deleteVenueCity()");
		VenueCity venueCity = adminService.getVenueCityById(venueCity_id);
		try {
			return new ResponseEntity<VenueCity>(adminService.deleteVenueCity(venueCity), HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/editlocation/{venucityId}")
	public ResponseEntity<?> editLocation(@RequestBody Location location,@PathVariable int venucityId)
	{	
		System.out.println("in edit location");
		VenueCity vc = adminService.getVenueCityById(venucityId);
		Location loc = adminService.getLocationById(location.getLocationId());
		if(loc == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		loc.setLocationCost(location.getLocationCost());
		loc.setLocationImage(location.getLocationImage());
		loc.setLocationName(location.getLocationName());
		loc.setVenueCity(vc);
		try
		{
			return new ResponseEntity<Location>(adminService.editLocation(loc), HttpStatus.OK);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 @GetMapping("/getlocationbyid/{loc_id}")
	 public ResponseEntity<?> getLocationById(@PathVariable int loc_id)
	 {
		 System.out.println("in getLocationById()");
			try {
				return new ResponseEntity<Location>(adminService.getLocationById(loc_id), HttpStatus.OK);
			}catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	 }
	 @DeleteMapping("/deletelocation/{loc_id}")
	 public ResponseEntity<?> deleteLocation(@PathVariable int loc_id)
	 {
		 System.out.println("in deleteLocation()");
			Location location = adminService.getLocationById(loc_id);
			try {
				return new ResponseEntity<Location>(adminService.deleteLocation(location), HttpStatus.OK);
			}catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	 }
	 @PostMapping(value = "/insertlocation",consumes = {"multipart/form-data"})
	 public ResponseEntity<?> insertLocation(@RequestParam String locationName,@RequestParam double locationCost,
	 @RequestParam int venuCityId,@RequestParam MultipartFile image) throws IOException
	 {
		 System.out.println("in insert location");
		 try {
		 VenueCity vc = adminService.getVenueCityById(venuCityId);
		 byte[] image1 = image.getBytes();
		 Location loc = new Location(locationName,locationCost);
		 System.out.println(loc.toString());
		 loc.setLocationImage(image1);
		 vc.addLocation(loc);
		 if(loc != null)
		 return new ResponseEntity<Location>(adminService.insertLocation(loc), HttpStatus.OK);
		 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		 }catch (RuntimeException e) {
		 e.printStackTrace();
		 return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }

}
