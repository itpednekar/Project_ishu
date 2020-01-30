package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Transaction_Tb")
public class Transaction 
{
	private Integer tranId;
	private TransactionType tranType;
	private String paymentStatus;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	private Date transDate;
	private double totalCost;
	private Event event;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	

	public Transaction(TransactionType tranType, String paymentStatus,Date finalTransDate, 
		   double totalCost) {
		super();
		this.tranType = tranType;
		this.paymentStatus = paymentStatus;
		this.transDate = finalTransDate;
		this.totalCost = totalCost;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	public Integer getTranId() {
		return tranId;
	}

	public void setTranId(Integer tranId) {
		this.tranId = tranId;
	}

	@Enumerated(EnumType.STRING)
	public TransactionType getTranType() {
		return tranType;
	}

	public void setTranType(TransactionType tranType) {
		this.tranType = tranType;
	}
	
	public String isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date finalTransDate) {
		this.transDate = finalTransDate;
	}

	
	public double getTotalCost() {
		return totalCost;
	}



	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}



	@OneToOne
	@JoinColumn(name = "event_id")
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}



	@Override
	public String toString() {
		return "Transaction [tranId=" + tranId + ", tranType=" + tranType + ", paymentStatus=" + paymentStatus
				+ ", finalTransDate=" + transDate + ", totalCost=" + totalCost + "]";
	}

	
	
	
	
}
