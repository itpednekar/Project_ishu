package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IEventDao;
import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.FoodSubMenu;
import com.app.pojos.Location;
import com.app.pojos.VenueCity;


@Service
public class EventServiceImpl implements IEventService 
{
	@Autowired
	private IEventDao eventDao;

	@Override
	public Event bookAnEvent(Event e) 
	{
		return eventDao.bookAnEvent(e);
	}

	@Override
	public Event updateEvent(Event e) {
		// TODO Auto-generated method stub
		return eventDao.updateEvent(e);
	}

	@Override
	public VenueCity getVenueCityById(int id) {
		// TODO Auto-generated method stub
		return eventDao.getVenueCityById(id);
	}

	@Override
	public List<Location> listLocationsById(int venueCity_id) {
		// TODO Auto-generated method stub
		return eventDao.listLocationsById(venueCity_id);
	}

	@Override
	public List<VenueCity> listVenueCity() {
		// TODO Auto-generated method stub
		return eventDao.listVenueCity();
	}

	@Override
	public Location getLocationById(int loc_id)
	{
		return eventDao.getLocationById(loc_id);
	}

	@Override
	public EventDesc getEventDescById(int eventdesc_id) {
		return eventDao.getEventDescById(eventdesc_id);
	}

	@Override
	public FoodSubMenu getFoodSubMenuById(int id) {
		return eventDao.getFoodSubMenuById(id);
	}

	@Override
	public FoodSubMenu editFoodSubMenu(FoodSubMenu foodSubMenu) {
		// TODO Auto-generated method stub
		return eventDao.editFoodSubMenu(foodSubMenu);
	}

}
