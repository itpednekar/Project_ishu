package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "Address_Tb")
public class Address {
	private Integer addressId;
	private String address;
	private String state;
	private String pinCode;
	private User user;
	
	public Address() 
	{
		// TODO Auto-generated constructor stub
	}
	public Address(String address, String state, String pinCode) {
		super();
		this.address = address;
		this.state = state;
		this.pinCode = pinCode;
	}
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
    public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	 @Column(length = 30)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	  @Column(length = 30)
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@OneToOne(mappedBy = "addr",cascade = CascadeType.ALL)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address=" +address + ", state=" + state + ", pinCode=" + pinCode+"]";
	}
	
	
	
	

}
