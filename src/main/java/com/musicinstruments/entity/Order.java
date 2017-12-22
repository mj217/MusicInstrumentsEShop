package com.musicinstruments.entity;

import java.sql.Timestamp;
import java.util.HashSet;
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
	private Timestamp deliveryDate;
	
	@ManyToOne
	@JoinColumn(name = "CustomerID", nullable = false)
	private User customer;
	
	@ManyToOne
	@JoinColumn(name = "ManagerID", nullable = false)
	private User manager;
	
	@OneToMany(mappedBy = "order",
			fetch = FetchType.LAZY)
	Set<OrderHistoryItem> orderHistoryItems = new HashSet<>();
	
	@OneToMany(mappedBy = "order",
			fetch = FetchType.LAZY)
	Set<OrderItem> orderItems = new HashSet<>();
	
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
	
	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(Timestamp deliveryDate) {
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
		return orderHistoryItems;
	}
	
	public void setOrderHistoryItems(HashSet<OrderHistoryItem> orderHistoryItems) {
		this.orderHistoryItems = orderHistoryItems;
	}
	
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void setOrderItems(HashSet<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
