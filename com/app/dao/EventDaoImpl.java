package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Event;
import com.app.pojos.EventDesc;
import com.app.pojos.Food;
import com.app.pojos.FoodEvent;
import com.app.pojos.Location;
import com.app.pojos.VenueCity;



@Repository
@Transactional
public class EventDaoImpl implements IEventDao 
{
	@Autowired
	private SessionFactory sf;

	@Override
	public Event bookAnEvent(Event e)
	{
		sf.getCurrentSession().persist(e);
		return e;
	}

	@Override
	public Event updateEvent(Event e) 
	{
		sf.getCurrentSession().update(e);
		return e;
	}

	@Override
	public VenueCity getVenueCityById(int id)
	{
		return sf.getCurrentSession().get(VenueCity.class, id);
	}

	@Override
	public List<Location> listLocationsById(int venueCity_id) {
		String jpql = "select l from Location l where l.venueCity = :vCityid";
		return sf.getCurrentSession().createQuery(jpql, Location.class).setParameter("vCityid", venueCity_id).getResultList();
	}

	@Override
	public List<VenueCity> listVenueCity() 
	{
		String jpql = "select v from VenueCity v";
		return sf.getCurrentSession().createQuery(jpql, VenueCity.class).getResultList();
	}

	@Override
	public Location getLocationById(int loc_id) {
		return sf.getCurrentSession().get(Location.class, loc_id);
	}

	@Override
	public EventDesc getEventDescById(int eventdesc_id) {
		return sf.getCurrentSession().get(EventDesc.class, eventdesc_id);
	}

	@Override
	public Food updateFood(Food f) {
		sf.getCurrentSession().update(f);
		return f;
	}

	@Override
	public FoodEvent insertFoodEvent(FoodEvent fe) {
		sf.getCurrentSession().update(fe);
		return fe;
	}
	

}
