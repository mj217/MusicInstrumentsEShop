package com.musicinstruments.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderHistoryItems")
public class OrderHistoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "OrderID", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "OrderStateID", nullable = false)
	private OrderState orderState;
	
	@ManyToOne
	@JoinColumn(name = "ModifiedByID", nullable = false)
	private User modifiedBy;
	
	@Column(name = "ModifiedOn")
	private LocalDateTime modifiedOn;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public OrderState getOrderState() {
		return orderState;
	}
	
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	
	public User getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public LocalDateTime getModofoedOn() {
		return modifiedOn;
	}
	
	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
}
