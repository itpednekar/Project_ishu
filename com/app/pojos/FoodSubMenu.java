package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "FoodSubMenu_Tb")
public class FoodSubMenu 
{
	private Integer foodSubMenuId;
	private String subMenu;
	private double cost;
	private Food food;
	public FoodSubMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public FoodSubMenu(String subMenu, double cost) {
		super();
		this.subMenu = subMenu;
		this.cost = cost;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "foodSubMenu_id")
	public Integer getFoodSubMenuId() {
		return foodSubMenuId;
	}
	public void setFoodSubMenuId(Integer foodSubMenuId) {
		this.foodSubMenuId = foodSubMenuId;
	}
	@Column(length = 30)
	public String getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	@ManyToOne
	@JoinColumn(name = "food_id")
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "FoodSubMenu [foodSubMenuId=" + foodSubMenuId + ", subMenu=" + subMenu + ", cost=" + cost + "]";
	}
	
	
}
