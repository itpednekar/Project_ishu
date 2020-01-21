package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Feedback_Tb")
public class Feedback {
	private Integer feedbackId;
	private String desc;
	private Date feedbackDate;
	private User user;
	public Feedback() {
		// TODO Auto-generated constructor stub
	}
	public Feedback(String desc, Date feedbackDate) {
		super();
		this.desc = desc;
		this.feedbackDate = feedbackDate;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	@Column(name = "feedback_desc")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Column(name = "feedback_date")
	@Temporal(TemporalType.DATE)
	public Date getFeedbackDate() {
		return feedbackDate;
	}
	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", desc=" + desc + ", feedbackDate=" + feedbackDate + "]";
	}
	
}
