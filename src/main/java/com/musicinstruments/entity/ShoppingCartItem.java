package com.musicinstruments.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "CustomerID", nullable = false)
	private User customer;
	
	@ManyToOne
	@JoinColumn(name = "ProductID", nullable = false)
	private Product product;
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	@Column(name= "ReadyToOrder")
	private Boolean readyToOrder;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getCustomer() {
		return customer;
	}
	
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Boolean getReadyToOrder() {
		return readyToOrder;
	}
	
	public void setReadyToOrder(Boolean readyToOrder) {
		this.readyToOrder = readyToOrder;
	}
}
