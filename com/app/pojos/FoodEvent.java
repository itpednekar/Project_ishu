package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Food_Event_Tb")
public class FoodEvent {

	private Integer foodEventId;
	private Food food;
	private Event event;
	public FoodEvent()
	{
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "foodevent_id")
	public Integer getFoodEventId() {
		return foodEventId;
	}

	public void setFoodEventId(Integer foodEventId) {
		this.foodEventId = foodEventId;
	}
	@ManyToOne
	@JoinColumn(name = "food_id")
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	@ManyToOne
	@JoinColumn(name = "event_id")
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "FoodEvent [foodEventId=" + foodEventId + "]";
	}
	
}
