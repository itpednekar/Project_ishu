package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Food_Tb")
@JsonIgnoreProperties(value = {"foodEventList"})
public class Food 
{
	private Integer foodId;
	private String foodType;
	private foodCategory category;
	private String foodSubMenu;
	private double cost;
	private List<FoodEvent> foodEventList = new ArrayList<>();
	public Food() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Food(Integer foodId, String foodType, foodCategory category, String foodSubMenu, double cost) {
		super();
		this.foodId = foodId;
		this.foodType = foodType;
		this.category = category;
		this.foodSubMenu = foodSubMenu;
		this.cost = cost;
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
	
	public String getFoodSubMenu() {
		return foodSubMenu;
	}

	public void setFoodSubMenu(String foodSubMenu) {
		this.foodSubMenu = foodSubMenu;
	}
	
	@OneToMany(mappedBy = "food",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<FoodEvent> getFoodEventList() {
		return foodEventList;
	}

	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setFoodEventList(List<FoodEvent> foodEventList) {
		this.foodEventList = foodEventList;
	}
	//cm
	public void addFoodEvent(FoodEvent foodEvent)
	{
		foodEventList.add(foodEvent);
		foodEvent.setFood(this);
	}
	public void removeFoodEvent(FoodEvent foodEvent)
	{
		foodEventList.remove(foodEvent);
		foodEvent.setFood(null);
	}



	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodType=" + foodType + ", category=" + category + ", foodSubMenu="
				+ foodSubMenu + ", cost=" + cost + "]";
	}
	
	
}
