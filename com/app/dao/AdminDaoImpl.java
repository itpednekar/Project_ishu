package com.app.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.Food;
import com.app.pojos.FoodSubMenu;
import com.app.pojos.Location;
import com.app.pojos.Manager;
import com.app.pojos.User;
import com.app.pojos.VenueCity;

@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public EventDesc insertEventDesc(EventDesc ed) {
		sf.getCurrentSession().persist(ed);
		return ed;
	}
	@Override
	public Manager getManagerById(int mgr_id) {
		return sf.getCurrentSession().get(Manager.class,mgr_id);
	}
	@Override
	public User addManager(User mgr) {
		sf.getCurrentSession().persist(mgr);
		return mgr;
	}
	@Override
	public List<User> listUsers() {
		String jpql = "select u from User u";
		return sf.getCurrentSession().createQuery(jpql, User.class).getResultList();
	}
	@Override
	public List<Event> listEvents() {
		String jpql = "select e from Event e";
		return sf.getCurrentSession().createQuery(jpql, Event.class).getResultList();
	}
	@Override
	public List<VenueCity> listVenueCity() {
		String jpql = "select v from VenueCity v";
		return sf.getCurrentSession().createQuery(jpql, VenueCity.class).getResultList();
	}
	@Override
	public List<Location> listLocation() {
		String jpql = "select l from Location l";
		return sf.getCurrentSession().createQuery(jpql, Location.class).getResultList();
	}
	@Override
	public List<Food> listFoodType() {
		String jpql = "select f from Food f";
		return sf.getCurrentSession().createQuery(jpql, Food.class).getResultList();
	}
	@Override
	public List<FoodSubMenu> listFoodSubMenu() {
		String jpql = "select fs from FoodSubMenu fs";
		return sf.getCurrentSession().createQuery(jpql, FoodSubMenu.class).getResultList();

	}
	@Override
	public VenueCity insertVenueCity(VenueCity vc) {
		sf.getCurrentSession().persist(vc);
		return vc;
	}
	@Override
	public Location insertLocation(Location loc) {
		sf.getCurrentSession().persist(loc);
		return loc;
	}
	@Override
	public VenueCity getVenueCityById(int venueCity_id) {
		return sf.getCurrentSession().get(VenueCity.class, venueCity_id);
	}
	@Override
	public Food insertFood(Food food) {
		sf.getCurrentSession().persist(food);
		return food;
	}
	@Override
	public Event getEventById(int event_id) {
		return sf.getCurrentSession().get(Event.class,event_id);
	}
	@Override
	public Food getFoodTypeById(int food_id) {
		return sf.getCurrentSession().get(Food.class,food_id);
	}
	@Override
	public FoodSubMenu insertFoodSubMenu(FoodSubMenu foodsubmenu) {
		sf.getCurrentSession().persist(foodsubmenu);
		return foodsubmenu;
	}
	@Override
	public FoodSubMenu deleteFoodSubMenu(FoodSubMenu foodSubMenu) {
		sf.getCurrentSession().delete(foodSubMenu);
		return foodSubMenu;
	}
	@Override
	public VenueCity deleteVenueCity(VenueCity venueCity) {
		sf.getCurrentSession().delete(venueCity);
		return venueCity;
	}
	@Override
	public Location editLocation(Location location) {
	 	 VenueCity venueCity	= location.getVenueCity();
		 sf.getCurrentSession().update(location);
	   	 sf.getCurrentSession().update(venueCity);
		 return location;
	}
	@Override
	public Location getLocationById(int loc_id) {
		return sf.getCurrentSession().get(Location.class, loc_id);
	}
	@Override
	public Location deleteLocation(Location location) {
		sf.getCurrentSession().delete(location);
		return location;
	}
}
