package com.eve.service;
import com.eve.dto.DishDto;
import com.eve.dto.OrderDto;
import com.eve.entity.*;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

public interface DishService {
	 List<DishDto> selectall();
     Dish  selectByPrimaryKey (long id);
     void insert(Dish dish);
     void changePrice(long id, double price);
     long searchTypeId(String typeName);
	 void insertList(List<Dish> dishes);
	 void getRoom(Order order);
	 long checkOrderId(long roomId);
	 void orderDishes(List<OrderItem> oderItem);
	 long freshPrice(long orderId);
	 Order brief(long roomId);
	 OrderDto detail(long roomId);
	 OrderDto test(long roomId);
	
	 
	}




