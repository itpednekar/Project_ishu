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
	private boolean paymentStatus;
	private double advanceAmt;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	private Date advanceDate;
	private double remainingAmt;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	private Date finalTransDate;
	private double totalCost;
	private Event event;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	

	public Transaction(TransactionType tranType, boolean paymentStatus, double advanceAmt, Date advanceDate,
			double remainingAmt, Date finalTransDate, double totalCost) {
		super();
		this.tranType = tranType;
		this.paymentStatus = paymentStatus;
		this.advanceAmt = advanceAmt;
		this.advanceDate = advanceDate;
		this.remainingAmt = remainingAmt;
		this.finalTransDate = finalTransDate;
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
	
	public boolean isPaymentStatus() {
		return paymentStatus;
	}



	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	public double getAdvanceAmt() {
		return advanceAmt;
	}

	public void setAdvanceAmt(double advanceAmt) {
		this.advanceAmt = advanceAmt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getAdvanceDate() {
		return advanceDate;
	}

	public void setAdvanceDate(Date advanceDate) {
		this.advanceDate = advanceDate;
	}

	public double getRemainingAmt() {
		return remainingAmt;
	}

	public void setRemainingAmt(double remainingAmt) {
		this.remainingAmt = remainingAmt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFinalTransDate() {
		return finalTransDate;
	}

	public void setFinalTransDate(Date finalTransDate) {
		this.finalTransDate = finalTransDate;
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
		return "Transaction [tranId=" + tranId + ", tranType=" + tranType + ", advanceAmt=" + advanceAmt
				+ ", advanceDate=" + advanceDate + ", remainingAmt=" + remainingAmt + ", finalTransDate=" + finalTransDate
				+ ", totalCost=" + totalCost + "]";
	}
	
	
	
	
}
