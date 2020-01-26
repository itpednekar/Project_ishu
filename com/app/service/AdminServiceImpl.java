package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.Food;
import com.app.pojos.FoodSubMenu;
import com.app.pojos.Location;
import com.app.pojos.Manager;
import com.app.pojos.User;
import com.app.pojos.VenueCity;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao adminDao;
	@Override
	public EventDesc insertEventDesc(EventDesc ed) {
		return adminDao.insertEventDesc(ed);
	}
	@Override
	public Manager getManagerById(int mgr_id) {
		return adminDao.getManagerById(mgr_id);
	}
	@Override
	public User addManager(User mgr) {
		return adminDao.addManager(mgr);
	}
	@Override
	public List<User> listUsers() {
		return adminDao.listUsers();
	}
	@Override
	public List<Event> listEvents() {
		return adminDao.listEvents();
	}
	@Override
	public List<VenueCity> listVenueCity() {
		return adminDao.listVenueCity();
	}
	@Override
	public List<Location> listLocation() {
		return adminDao.listLocation();
	}
	@Override
	public List<Food> listFoodType() {
		return adminDao.listFoodType();
	}
	@Override
	public List<FoodSubMenu> listFoodSubMenu() {
		return adminDao.listFoodSubMenu();
	}
	@Override
	public VenueCity insertVenueCity(VenueCity vc) {
		return adminDao.insertVenueCity(vc);
	}
	@Override
	public Location insertLocation(Location loc) {
		return adminDao.insertLocation(loc);
	}
	@Override
	public VenueCity getVenueCityById(int venueCity_id) {
		return adminDao.getVenueCityById(venueCity_id);
	}
	@Override
	public Food insertFood(Food food) {
		return adminDao.insertFood(food);
	}
	@Override
	public Event getEventById(int event_id) {
		return adminDao.getEventById(event_id);
	}
	@Override
	public Food getFoodTypeById(int food_id) {
		return adminDao.getFoodTypeById(food_id);
	}
	@Override
	public FoodSubMenu insertFoodSubMenu(FoodSubMenu foodsubmenu) {
		return adminDao.insertFoodSubMenu(foodsubmenu);
	}
	@Override
	public FoodSubMenu deleteFoodSubMenu(FoodSubMenu foodSubMenu) {
		// TODO Auto-generated method stub
		return adminDao.deleteFoodSubMenu(foodSubMenu);
	}
	@Override
	public VenueCity deleteVenueCity(VenueCity venueCity) {
		// TODO Auto-generated method stub
		return adminDao.deleteVenueCity(venueCity);
	}
	@Override
	public Location editLocation(Location location) {
		// TODO Auto-generated method stub
		return adminDao.editLocation(location);
	}
	@Override
	public Location getLocationById(int loc_id) {
		// TODO Auto-generated method stub
		return adminDao.getLocationById(loc_id);
	}
	@Override
	public Location deleteLocation(Location location) {
		// TODO Auto-generated method stub
		return adminDao.deleteLocation(location);
	}

}
