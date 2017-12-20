package com.musicinstruments.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Name")
	private String name;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "ProductCategories",
			joinColumns = { @JoinColumn(name = "ProductID") },
			inverseJoinColumns = { @JoinColumn(name = "CategoryID") }
	)
	private Set<Category> categories = new HashSet<>();
	
	@Column(name = "Price")
	private BigDecimal price;
	
	@Column(name = "Supplier")
	private String supplier;
	
	@Column(name = "QuantityInStock")
	private Integer quantityInStock;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<ShoppingCartItem> shoppingCartItems = new HashSet<>();
	
	@OneToMany(mappedBy = "product",
				fetch = FetchType.LAZY)
	private Set<OrderItem> orderItems = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(HashSet<Category> categories) {
		this.categories = categories;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getSupplier() {
		return supplier;
	}
	
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	public Integer getQuantityInStock() {
		return quantityInStock;
	}
	
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	} 
	
	public Set<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}
	
	public void setShoppingCartItems(HashSet<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}
	
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void setOrderItems(HashSet<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
