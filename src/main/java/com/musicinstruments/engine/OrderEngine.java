package com.musicinstruments.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

import com.musicinstruments.dao.OrderDao;
import com.musicinstruments.dao.OrderStateDao;
import com.musicinstruments.entity.Order;
import com.musicinstruments.entity.OrderState;

@Service
public class OrderEngine {

	private static OrderEngine instance;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderStateDao orderStateDao;
	
	private OrderEngine() {
		
	}
	
	public static OrderEngine getInstance() {
		if (instance == null) {
			return new OrderEngine();
		}
		return instance;
	}
	
	public void createOrder(Order order) {
		orderDao.persist(order);
	}
	
	public void confirmOrder(Order order) {
		OrderState orderState = orderStateDao.findByName("Confirmed");
		order.setOrderState(orderState);
		orderDao.update(order);
	}
	
	public void cancelOrder(Order order) {
		OrderState orderState = orderStateDao.findByName("Canceled");
		order.setOrderState(orderState);
		orderDao.update(order);
	}
	
	public void payOrder(Order order) {
		OrderState orderState = orderStateDao.findByName("Paid");
		order.setOrderState(orderState);
		orderDao.update(order);
	}
	
	public void sheduleOrderDelivery(Order order, Timestamp deliveryDate) {
		order.setDeliveryDate(deliveryDate);
		orderDao.update(order);
	}
	
	
}
