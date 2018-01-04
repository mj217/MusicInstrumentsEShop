package com.musicinstruments.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.musicinstruments.dao.Dao;
import com.musicinstruments.dao.OrderDao;
import com.musicinstruments.dao.OrderItemDao;
import com.musicinstruments.dao.OrderStateDao;
import com.musicinstruments.entity.Order;
import com.musicinstruments.entity.OrderItem;
import com.musicinstruments.entity.OrderState;

@Service
public class OrderEngine {

	private static OrderEngine instance;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderStateDao orderStateDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	public OrderEngine() {
		
	}

	public static OrderEngine getInstance() {
		if (instance == null) {
			return new OrderEngine();
		}
		return instance;
	}
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public void setOrderStateDao(OrderStateDao orderStateDao) {
		this.orderStateDao = orderStateDao;
	}
	
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}
	
	@Transactional
	public void createOrder(Order order) {
		orderDao.persist(order);
	}
	
	@Transactional
	public void confirmOrder(Order order) {
		OrderState orderState = orderStateDao.findByName("Confirmed");
		order.setOrderState(orderState);
		orderDao.update(order);
	}
	
	@Transactional
	public void cancelOrder(Order order) {
		OrderState orderState = orderStateDao.findByName("Canceled");
		order.setOrderState(orderState);
		orderDao.update(order);
	}
	
	@Transactional
	public void payOrder(Order order) {
		OrderState orderState = orderStateDao.findByName("Paid");
		order.setOrderState(orderState);
		orderDao.update(order);
	}
	
	@Transactional
	public void sheduleOrderDelivery(Order order, LocalDate deliveryDate) {
		order.setDeliveryDate(deliveryDate);
		orderDao.update(order);
	}
	
	@Transactional
	public void addItem(Order order, OrderItem orderItem) {
		order.addOrderItem(orderItem);
		orderDao.update(order);
		orderItemDao.update(orderItem);
	}
	
	@Transactional
	public void updateItem(OrderItem orderItem) {
		orderItemDao.update(orderItem);
	}
	
	@Transactional
	public void deleteItem(OrderItem orderItem) {
		Order order = orderItem.getOrder();
		order.removeOrderItem(orderItem);
		orderDao.update(order);
	}
	
	@Transactional
	public Collection<OrderItem> getAllItems(Order order) {
		return order.getOrderItems();
	}
	
	@Transactional
	public BigDecimal getOrderTotal(Order order) {
		Set<OrderItem> orderItems =  order.getOrderItems();
		BigDecimal totalPrice = BigDecimal.ZERO;
		for(OrderItem orderItem : orderItems) {
			totalPrice = totalPrice.add(getItemFullPrice(orderItem));
		}
		return totalPrice;
	}
	
	@Transactional
	public BigDecimal getItemFullPrice(OrderItem orderItem) {
		return orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()));
	}
}
