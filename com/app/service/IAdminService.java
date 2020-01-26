package com.app.service;

import java.util.List;

import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.Food;
import com.app.pojos.FoodSubMenu;
import com.app.pojos.Location;
import com.app.pojos.Manager;
import com.app.pojos.User;
import com.app.pojos.VenueCity;

public interface IAdminService {
	EventDesc insertEventDesc(EventDesc ed);
	Manager getManagerById(int mgr_id);
	User addManager(User mgr);
	List<User> listUsers();
	List<Event> listEvents();
	List<VenueCity> listVenueCity();
	List<Location> listLocation();
	List<Food> listFoodType();
	List<FoodSubMenu> listFoodSubMenu();
	VenueCity insertVenueCity(VenueCity vc);
	Location insertLocation(Location loc);
	VenueCity getVenueCityById(int venueCity_id);
	Food insertFood(Food food);
	Event getEventById(int event_id);
	Food getFoodTypeById(int food_id);
	FoodSubMenu insertFoodSubMenu(FoodSubMenu foodsubmenu);
	FoodSubMenu deleteFoodSubMenu(FoodSubMenu foodSubMenu);
	VenueCity deleteVenueCity(VenueCity venueCity);
	Location editLocation(Location location);
	Location getLocationById(int loc_id);
	Location deleteLocation(Location location);
}
