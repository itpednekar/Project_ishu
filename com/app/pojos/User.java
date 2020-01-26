package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "User_Tb")
@JsonIgnoreProperties(value= {"feedBackList","eventList","mgr"})
public class User 
{
	private Integer userId;
	private String name;
	private String email;
	private String password;
	private String confirmPassword;
	private UserRole role;
	private String mobNo;
	private Address addr;
	private List<Feedback> feedBackList = new ArrayList<>();
	private List<Event> eventList = new ArrayList<>();
	private Manager mgr;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String email, String password, String confirmPassword, UserRole role, String mobNo) 
	{
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
		this.mobNo = mobNo;	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(length = 30, name = "u_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 30, name = "u_email", unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	@Column(length = 30, name = "u_password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    @Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 30, name = "u_role")
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Column(length = 30, name = "u_mobNo")
	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	@OneToOne
	@JoinColumn(name = "address_id")
	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public List<Feedback> getFeedBackList() {
		return feedBackList;
	}

	public void setFeedBackList(List<Feedback> feedBackList) {
		this.feedBackList = feedBackList;
	}
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	public Manager getMgr() {
		return mgr;
	}

	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}
//cm
	public void addAddress(Address a)
	{
		this.addr = a;
		a.setUser(this);
	}
	public void removeAddress(Address a)
	{
		addr = null;
		a.setUser(null);
	}
	public void addFeedback(Feedback f)
	{
		feedBackList.add(f);
		f.setUser(this);
	}
	public void removeFeedback(Feedback f)
	{
		feedBackList.remove(f);
		f.setUser(null);
	}
	public void addEvents(Event e) 
	{
		eventList.add(e);
		e.setUser(this);
	}
	public void removeEvents(Event e)
	{
		eventList.remove(e);
		e.setUser(null);
	}
	public void addManager(Manager m)
	{
		this.mgr = m;
		m.setUser(this);
	}
	public void removeManager(Manager m)
	{
		this.mgr = null;
		m.setUser(null);
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", role=" + role + ", mobNo=" + mobNo + "]";
	}

	

	
	
}
