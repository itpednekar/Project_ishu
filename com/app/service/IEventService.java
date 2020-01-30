package com.app.service;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.Food;
import com.app.pojos.FoodEvent;
import com.app.pojos.Location;
import com.app.pojos.Transaction;
import com.app.pojos.VenueCity;

public interface IEventService 
{
	Event bookAnEvent(Event e);
	Event updateEvent(Event e);
	VenueCity getVenueCityById(int id);
	List<Location> listLocationsById(int venueCity_id);
	List<VenueCity> listVenueCity();
	Location getLocationById(int loc_id);
	EventDesc getEventDescById(int eventdesc_id);
	Food updateFood(Food f);
	FoodEvent insertFoodEvent(FoodEvent fe);
}
