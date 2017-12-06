package com.musicinstruments.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.musicinstruments.enums.OrderState;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "OrderState")
	private OrderState orderState;
	
	@Column(name = "DeliveryDate")
	private Timestamp deliveryDate;
	
	@ManyToOne
	@JoinColumn(name = "CustomerID", nullable = false)
	private User customer;
	
	@ManyToOne
	@JoinColumn(name = "ManagerID", nullable = false)
	private User manager;
	
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
}
