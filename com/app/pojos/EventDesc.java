package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "EventDesc_Tb")
public class EventDesc 
{
	private Integer eventDescId;
	private String eventName;
	private double eventCost;
	private Event event;
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

	@OneToOne(mappedBy = "eventDesc",cascade = CascadeType.ALL)
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
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
		this.event = e;
		e.setEventDesc(this);
	}
	public void removeEvent(Event e)
	{
		this.event = null;
		e.setEventDesc(null);
	}
	@Override
	public String toString() {
		return "EventDesc [eventDescId=" + eventDescId + ", eventName=" + eventName + ", eventCost=" + eventCost
				+ ", event=" + event + ", mgr=" + mgr + "]";
	}
	
	
	

}
