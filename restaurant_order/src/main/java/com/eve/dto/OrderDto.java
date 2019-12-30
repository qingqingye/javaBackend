package com.eve.dto;
import java.util.List;

import com.eve.entity.*;

public class OrderDto extends Order {
	private  List<Dish> orderDishes;

	public List<Dish> getOrderDishes() {
		return orderDishes;
	}

	public void setOrderDishes(List<Dish> orderDishes) {
		this.orderDishes = orderDishes;
	}



}
