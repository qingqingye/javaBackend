package com.eve.service.impl;

import com.eve.service.*;
import com.eve.dao.dishMapper;
import com.eve.dto.*;
import com.eve.dto.OrderDto;
import com.eve.entity.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dishServiceImpl implements DishService {

	@Autowired
	private dishMapper dishMapper;

	@Override
	public Dish selectByPrimaryKey(long id) {
		// TODO Auto-generated method stub
		return dishMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DishDto> selectall() {
		return dishMapper.selectAll();
	}

	@Override
	public void insert(Dish dish) {
		dishMapper.insert(dish);
		// TODO Auto-generated method stub
	}

	@Override
	public void insertList(List<Dish> dishes){
		dishMapper.insertList(dishes);
	}
		

	@Override
	public long searchTypeId(String typeName) {
		// TODO Auto-generated method stub
		return dishMapper.searchTypeID(typeName);
	}
  
	@Override
	public void changePrice(long id, double price){
		dishMapper.changePrice(id, price);
		
	}
	
	@Override
	public void getRoom(Order order){
		int count= dishMapper.check(order.getRoomId());
	    if (count==0){
	    	dishMapper.getRoom(order);
	    }
	}
	
	@Override
	public long checkOrderId(long roomId){
		long orderId = dishMapper.checkOrderId(roomId);
		return orderId;
	}
	
	@Override
	public void orderDishes( List<OrderItem> orderItem){
		dishMapper.orderDishes(orderItem);
	
	}
	
	@Override
	public long freshPrice(long orderId){
		long totalPrice = dishMapper.freshPrice(orderId);
		dishMapper.freshPrice_table(totalPrice, orderId);
		return totalPrice;
	}
	
	
	@Override
	public Order brief(long roomId){
		return dishMapper.brief(roomId);
	}
	
	@Override
	public OrderDto detail(long roomId){
		List<Dish> dishes = dishMapper.checkDishes(roomId);
		OrderDto orderListDto = dishMapper.detail(roomId);
		orderListDto.setOrderDishes(dishes);
		return orderListDto;
	}
	
	@Override
	public OrderDto test(long roomId){
		
		OrderDto orderListDto = dishMapper.test(roomId);
	
		return orderListDto;
	}
	
}
