package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Event_Tb")
public class Event 
{
	private Integer eventId;
	private Date eventDate;
	private int noOfGuestsVeg;
	private int noOfGuestsNonVeg;
	private int eventDuration;
	private double decorationBudget;
	private String theme;
	private String musicSystem;
	private double costWithoutDiscount;
	private int discount;
	private double costWithDiscount;
	private User user;
	private EventDesc eventDesc;
	private Transaction transaction;
	private List<Food> foodList = new ArrayList<>();
	private Location loc;
	private Appointment appoint;
	private Report report;
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Event(Date eventDate, int noOfGuestsVeg, int noOfGuestsNonVeg, int eventDuration, double decorationBudget,
			String theme, String musicSystem, double costWithoutDiscount, int discount, double costWithDiscount) {
		super();
		this.eventDate = eventDate;
		this.noOfGuestsVeg = noOfGuestsVeg;
		this.noOfGuestsNonVeg = noOfGuestsNonVeg;
		this.eventDuration = eventDuration;
		this.decorationBudget = decorationBudget;
		this.theme = theme;
		this.musicSystem = musicSystem;
		this.costWithoutDiscount = costWithoutDiscount;
		this.discount = discount;
		this.costWithDiscount = costWithDiscount;
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
	@Column(name = "no_of_vegGuests")
	public int getNoOfGuestsVeg() {
		return noOfGuestsVeg;
	}


	public void setNoOfGuestsVeg(int noOfGuestsVeg) {
		this.noOfGuestsVeg = noOfGuestsVeg;
	}

	@Column(name = "no_of_NonVegGuests")
	public int getNoOfGuestsNonVeg() {
		return noOfGuestsNonVeg;
	}


	public void setNoOfGuestsNonVeg(int noOfGuestsNonVeg) {
		this.noOfGuestsNonVeg = noOfGuestsNonVeg;
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


	@Column(name = "cost_without_discount")
	public double getCostWithoutDiscount() {
		return costWithoutDiscount;
	}
	public void setCostWithoutDiscount(double costWithoutDiscount) {
		this.costWithoutDiscount = costWithoutDiscount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Column(name = "cost_with_discount")
	public double getCostWithDiscount() {
		return costWithDiscount;
	}
	public void setCostWithDiscount(double costWithDiscount) {
		this.costWithDiscount = costWithDiscount;
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
	@OneToOne
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
     
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
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


	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventDate=" + eventDate + ", noOfGuestsVeg=" + noOfGuestsVeg
				+ ", noOfGuestsNonVeg=" + noOfGuestsNonVeg + ", eventDuration=" + eventDuration + ", decorationBudget="
				+ decorationBudget + ", theme=" + theme + ", musicSystem=" + musicSystem + ", costWithoutDiscount="
				+ costWithoutDiscount + ", discount=" + discount + ", costWithDiscount=" + costWithDiscount + "]";
	}

	
	
	
}
