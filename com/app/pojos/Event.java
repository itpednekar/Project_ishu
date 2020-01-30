package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Event_Tb")
@JsonIgnoreProperties(value= {"user","eventDesc","transaction","foodEventList","loc","appoint","report"})
public class Event 
{
	private Integer eventId;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	private Date eventDate;
	private int noOfGuests;
	private int eventDuration;
	private double decorationBudget;
	private String theme;
	private String musicSystem;
	private double totalCost;
	private User user;
	private EventDesc eventDesc;
	private Transaction transaction;
	private Location loc;
	private Appointment appoint;
	private Report report;
	private List<FoodEvent> foodEventList = new ArrayList<>();
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	public Event(Date eventDate, int noOfGuests, int eventDuration, double decorationBudget,
			String theme, String musicSystem, double totalCost) {
		super();
		this.eventDate = eventDate;
		this.noOfGuests = noOfGuests;
		this.eventDuration = eventDuration;
		this.decorationBudget = decorationBudget;
		this.theme = theme;
		this.musicSystem = musicSystem;
		this.totalCost = totalCost;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "event_date")
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public int getNoOfGuests() {
		return noOfGuests;
	}


	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}


	public int getEventDuration() {
		return eventDuration;
	}
	public void setEventDuration(int eventDuration) {
		this.eventDuration = eventDuration;
	}
	public double getDecorationBudget() {
		return decorationBudget;
	}
	public void setDecorationBudget(double decorationBudget) {
		this.decorationBudget = decorationBudget;
	}
	
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}


	public String getMusicSystem() {
		return musicSystem;
	}


	public void setMusicSystem(String musicSystem) {
		this.musicSystem = musicSystem;
	}


	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser()
	{
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name = "eventDesc_id")
	public EventDesc getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(EventDesc eventDesc) {
		this.eventDesc = eventDesc;
	}
	@OneToOne(mappedBy = "event",cascade = CascadeType.ALL)
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	@OneToOne
	@JoinColumn(name = "location_id")
	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}
	@OneToOne(mappedBy = "event",cascade = CascadeType.ALL)
	public Appointment getAppoint() {
		return appoint;
	}

	public void setAppoint(Appointment appoint) {
		this.appoint = appoint;
	}

	@OneToOne(mappedBy = "event",cascade = CascadeType.ALL)
	public Report getReport() {
		return report;
	}


	public void setReport(Report report) {
		this.report = report;
	}
     
	@OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<FoodEvent> getFoodEventList() {
		return foodEventList;
	}
	public void setFoodEventList(List<FoodEvent> foodEventList) {
		this.foodEventList = foodEventList;
	}


	//convenience methods
	public void addAppointment(Appointment a)
	{
		this.appoint=a;
		a.setEvent(this);
	}
	public void removeAppointment(Appointment a)
	{
		this.appoint=null;
		a.setEvent(null);
	}
	public void addReport(Report r)
	{
		this.report = r;
		r.setEvent(this);
	}
	public void removeReport(Report r)
	{
		this.report = null;
		r.setEvent(null);
	}
	public void addFoodEvent(FoodEvent foodEvent)
	{
		foodEventList.add(foodEvent);
		foodEvent.setEvent(this);
	}
	public void removeFoodEvent(FoodEvent foodEvent)
	{
		foodEventList.remove(foodEvent);
		foodEvent.setEvent(null);
	}
	public void addTrans(Transaction t)
	{
	this.transaction = t;
	t.setEvent(this);
	}
	public void removeTrans(Transaction t)
	{
	this.transaction = null;
	t.setEvent(null);;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventDate=" + eventDate + ", noOfGuests=" + noOfGuests
				+ ", eventDuration=" + eventDuration + ", decorationBudget=" + decorationBudget + ", theme=" + theme
				+ ", musicSystem=" + musicSystem + ", totalCost=" + totalCost + "]";
	}


	

	
	
	
}