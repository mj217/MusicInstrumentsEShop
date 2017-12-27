package com.musicinstruments.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.musicinstruments.utils.CommonUtil;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name = "OrderStateID", nullable = false)
	private OrderState orderState;
	
	@Column(name = "DeliveryDate")
	private LocalDateTime deliveryDate;
	
	@ManyToOne
	@JoinColumn(name = "CustomerID", nullable = false)
	private User customer;
	
	@ManyToOne
	@JoinColumn(name = "ManagerID", nullable = false)
	private User manager;
	
	@OneToMany(mappedBy = "order",
			fetch = FetchType.LAZY)
	Set<OrderHistoryItem> orderHistoryItems;
	
	@OneToMany(mappedBy = "order",
			fetch = FetchType.LAZY)
	Set<OrderItem> orderItems;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public OrderState getOrderState() {
		return orderState;
	}
	
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	
	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public User getCustomer() {
		return customer;
	}
	
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	public User getManager() {
		return manager;
	}
	
	public void setManager(User manager) {
		this.manager = manager;
	} 
	
	public Set<OrderHistoryItem> getOrderHistoryItems() {
		return CommonUtil.getSafeSet(orderHistoryItems);
	}
	
	public void setOrderHistoryItems(Set<OrderHistoryItem> orderHistoryItems) {
		this.orderHistoryItems = orderHistoryItems;
	}
	
	public Set<OrderItem> getOrderItems() {
		return CommonUtil.getSafeSet(orderItems);
	}
	
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void addOrderItem(OrderItem orderItem) {
		Objects.requireNonNull(orderItem, "orderItem parameter is not initialized");
		if(orderItems == null) {
			orderItems= new HashSet<>();
		}
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
	
	public void removeOrderItem(OrderItem orderItem) {
		Objects.requireNonNull(orderItem, "orderItem parameter is not initialized");
		if(orderItems == null) {
			return;
		}
		orderItems.remove(orderItem);
	}
	
	public void addOrdeHistoryItem(OrderHistoryItem orderHistoryItem) {
		Objects.requireNonNull(orderHistoryItem, "orderHistoryItem parameter is not initialized");
		if(orderHistoryItems == null) {
			orderHistoryItems = new HashSet<>();
		}
		orderHistoryItems.add(orderHistoryItem);
		orderHistoryItem.setOrder(this);
	}
	
	public void removeOrdeHistoryItem(OrderHistoryItem orderHistoryItem) {
		Objects.requireNonNull(orderHistoryItem, "orderHistoryItem parameter is not initialized");
		if(orderHistoryItems == null) {
			return;
		}
		orderHistoryItems.remove(orderHistoryItem);
		
	}
	
}
