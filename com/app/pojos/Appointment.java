package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Appointment_Tb")
public class Appointment 
{
	private Integer appointmentId;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	private Date appointmentDate;
	private Event event;
	private Manager mgr;
	public Appointment() {
		// TODO Auto-generated constructor stub
	}
	public Appointment(Date appointmentDate) {
		super();
		this.appointmentDate = appointmentDate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	@Column(name = "appointment_date")
	@Temporal(TemporalType.DATE)
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	@OneToOne
	@JoinColumn(name = "event_id")
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	public Manager getMgr() {
		return mgr;
	}
	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate + "]";
	}
	
}