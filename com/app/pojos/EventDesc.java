package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "EventDesc_Tb")
@JsonIgnoreProperties(value = {"event","mgr","eventlist"})
public class EventDesc 
{
	private Integer eventDescId;
	private String eventName;
	private double eventCost;
	private List<Event> eventlist = new ArrayList<Event>();
	private Manager mgr;
	public EventDesc()
	{
		
	}
	
	public EventDesc(String eventName, double eventCost) {
		super();
		this.eventName = eventName;
		this.eventCost = eventCost;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventDesc_id")
	public Integer getEventDescId() {
		return eventDescId;
	}
	public void setEventDescId(Integer eventDescId) {
		this.eventDescId = eventDescId;
	}
	@Column(length = 30)
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public double getEventCost() {
		return eventCost;
	}

	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}

	@OneToMany(mappedBy = "eventDesc",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Event> getEventlist() {
		return eventlist;
	}

	public void setEventlist(List<Event> eventlist) {
		this.eventlist = eventlist;
	}
	
	@OneToOne
	@JoinColumn(name = "manager_id")
	public Manager getMgr() {
		return mgr;
	}
	
	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}
	//convinience methods
		public void addEvent(Event e)
		{
			eventlist.add(e);
			e.setEventDesc(this);
		}
		public void removeEvent(Event e)
		{
			eventlist.remove(e);
			e.setEventDesc(null);
		}

		@Override
		public String toString() {
			return "EventDesc [eventDescId=" + eventDescId + ", eventName=" + eventName + ", eventCost=" + eventCost
					+ "]";
		}
	
	
	
	

}
