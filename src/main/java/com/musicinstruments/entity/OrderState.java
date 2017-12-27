package com.musicinstruments.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.musicinstruments.utils.CommonUtil;

@Entity
@Table(name = "OrderStates")
public class OrderState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "orderState", fetch = FetchType.EAGER)
	private Set<Order> orders;
	
	@OneToMany(mappedBy = "orderState", fetch = FetchType.EAGER)
	private Set<OrderHistoryItem> orderHistoryItems;
	
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
	
	public Set<Order> getOrders() {
		return CommonUtil.getSafeSet(orders);
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public Set<OrderHistoryItem> getOrderHistoryItems() {
		return CommonUtil.getSafeSet(orderHistoryItems);
	}
	
	public void setOrderHistoryItems(Set<OrderHistoryItem> orderHistoryItems) {
		this.orderHistoryItems = orderHistoryItems;
	}
}
