package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "VenueCity_Tb")
@JsonIgnoreProperties(value = {"locList"})
public class VenueCity 
{
	private Integer venueCityId;
	private String venueCityName;
	private List<Location> locList = new ArrayList<>();
	public VenueCity() {
		// TODO Auto-generated constructor stub
	}
	public VenueCity(String venueCityName) {
		super();
		this.venueCityName = venueCityName;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venueCity_id")
	public Integer getVenueCityId() {
		return venueCityId;
	}
	public void setVenueCityId(Integer venueCityId) {
		this.venueCityId = venueCityId;
	}
	@Column(length = 30)
	public String getVenueCityName() {
		return venueCityName;
	}
	public void setVenueCityName(String venueCityName) {
		this.venueCityName = venueCityName;
	}
	@OneToMany(mappedBy = "venueCity",cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Location> getLocList() {
		return locList;
	}
	public void setLocList(List<Location> locList) {
		this.locList = locList;
	}
	//cm
	public void addLocation(Location loc)
	{
		locList.add(loc);
		loc.setVenueCity(this);
	}
	public void removeLocation(Location loc)
	{
		locList.remove(loc);
		loc.setVenueCity(null);
	}
	@Override
	public String toString() {
		return "VenueCity [venueCityId=" + venueCityId + ", venueCityName=" + venueCityName + "]";
	}
	
}
