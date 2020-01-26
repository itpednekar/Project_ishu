package com.app.pojos;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Manager_Tb")
@JsonIgnoreProperties(value = {"eventDesc","appointmentList"})
public class Manager {
	private Integer managerId;
	private User user;
	private EventDesc eventDesc;
	private List<Appointment> appointmentList = new ArrayList<Appointment>();
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_id")
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	@OneToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@OneToOne(mappedBy = "mgr",cascade = CascadeType.ALL)
	public EventDesc getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(EventDesc eventDesc) {
		this.eventDesc = eventDesc;
	}
    @OneToMany(mappedBy = "mgr", cascade = CascadeType.ALL)   
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	//cm
	public void addEventDesc(EventDesc ed)
	{
		this.eventDesc = ed;
		ed.setMgr(this);
	}
	public void removeEventDesc(EventDesc ed)
	{
		this.eventDesc = null;
		ed.setMgr(null);
	}
	public void addAppointmentsList(Appointment a)
	{
		appointmentList.add(a);
		a.setMgr(this);
	}
	public void removeAppointmentsList(Appointment a)
	{
		appointmentList.remove(a);
		a.setMgr(null);
	}
	
	@Override
	public String toString() {
		return "Manger [managerId=" + managerId + "]";
	}
	

}