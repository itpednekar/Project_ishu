package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Food_Tb")
@JsonIgnoreProperties(value= {"foodSbmenuList"})
public class Food 
{
	private Integer foodId;
	private String foodType;
	private foodCategory category;
	private Event event;
	private List<FoodSubMenu> foodSbmenuList=new ArrayList<>();
	public Food() {
		// TODO Auto-generated constructor stub
	}
	public Food(String foodCuisine, foodCategory category) {
		super();
		this.foodType = foodCuisine;
		this.category = category;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	@Column(length = 30)
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	@Enumerated(EnumType.STRING)
	public foodCategory getCategory() {
		return category;
	}
	public void setCategory(foodCategory category) {
		this.category = category;
	}
	@ManyToOne
	@JoinColumn(name = "event_id")
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	@OneToMany(mappedBy = "food",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<FoodSubMenu> getFoodSbmenuList() {
		return foodSbmenuList;
	}
	public void setFoodSbmenuList(List<FoodSubMenu> foodSbmenuList) {
		this.foodSbmenuList = foodSbmenuList;
	}
	//cm
	public void addFoodSubMenu(FoodSubMenu fsm)
	{
		foodSbmenuList.add(fsm);
		fsm.setFood(this);
	}
	public void removeFoodSubMenu(FoodSubMenu fsm)
	{
		foodSbmenuList.remove(fsm);
		fsm.setFood(null);
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodType=" + foodType + ", category=" + category + "]";
	}
	
}
