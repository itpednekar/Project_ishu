package com.app.dao;

import java.util.List;

import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.Food;
import com.app.pojos.Location;
import com.app.pojos.Manager;
import com.app.pojos.User;
import com.app.pojos.VenueCity;

public interface IAdminDao {
	EventDesc insertEventDesc(EventDesc ed);
	Manager getManagerById(int mgr_id);
	User addManager(User mgr);
	List<User> listUsers();
	List<Event> listEvents();
	List<EventDesc> listEventDesc();
	List<VenueCity> listVenueCity();
	List<Location> listLocation();
	List<Food> listFoodType();
	VenueCity insertVenueCity(VenueCity vc);
	Location insertLocation(Location loc);
	VenueCity getVenueCityById(int venueCity_id);
	Food insertFood(Food food);
	Event getEventById(int event_id);
	Food getFoodTypeById(int food_id);
	Manager blockManager(Manager mgr);
	EventDesc updateEventDesc(EventDesc ed);
	EventDesc getEventDescById(int eventDescId);
	Food updateFoodType(Food food);
	VenueCity deleteVenueCity(VenueCity venueCity);
	Location getLocationById(int loc_id);
	Location editLocation(Location location);
	Location deleteLocation(Location location);
}
