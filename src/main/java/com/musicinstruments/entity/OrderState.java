package com.musicinstruments.entity;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OrderStates")
public class OrderState {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "orderState", fetch = FetchType.EAGER)
	private HashSet<Order> orders = new HashSet<>();
	
	@OneToMany(mappedBy = "orderState", fetch = FetchType.EAGER)
	private HashSet<OrderHistoryItem> orderHistoryItems = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this. id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this. name = name;
	}
	
	public HashSet<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(HashSet<Order> orders) {
		this.orders = orders;
	}
	
	public HashSet<OrderHistoryItem> getOrderHistoryItems() {
		return orderHistoryItems;
	}
	
	public void setOrderHistoryItems(HashSet<OrderHistoryItem> orderHistoryItems) {
		this.orderHistoryItems = orderHistoryItems;
	}
}
