package com.musicinstruments.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
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

import com.musicinstruments.utils.CommonUtil;

@Entity
@Table(name = "Products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private Set<Category> categories;
	
	@Column(name = "Price")
	private BigDecimal price;
	
	@Column(name = "Supplier")
	private String supplier;
	
	@Column(name = "QuantityInStock")
	private Integer quantityInStock;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<ShoppingCartItem> shoppingCartItems;
	
	@OneToMany(mappedBy = "product",
				fetch = FetchType.LAZY)
	private Set<OrderItem> orderItems;
	
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
		return CommonUtil.getSafeSet(categories);
	}
	
	public void setCategories(Set<Category> categories) {
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
		return CommonUtil.getSafeSet(shoppingCartItems);
	}
	
	public void setShoppingCartItems(Set<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}
	
	public Set<OrderItem> getOrderItems() {
		return CommonUtil.getSafeSet(orderItems);
	}
	
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addCategory(Category category) {
		Objects.requireNonNull(category, "category parameter is not initialized");
		if(categories == null) {
			categories = new HashSet<>();
		}
		categories.add(category);
		Set<Product> products = category.getProducts();
		products.add(this);
		category.setProducts(products);
	}
	
	public void removeCategory(Category category) {
		Objects.requireNonNull(category, "category parameter is not initialized");
		if(categories == null) {
			return;
		}
		categories.remove(category);
		Set<Product> products = category.getProducts();
		products.remove(this);
		category.setProducts(products);
	}
	
	public void addOrderItem(OrderItem orderItem) {
		Objects.requireNonNull(orderItem, "orderItem parameter is not initialized");
		if(orderItems == null) {
			orderItems = new HashSet<>();
		}
		orderItems.add(orderItem);
		orderItem.setProduct(this);
	}
	
	public void removeOrderItem(OrderItem orderItem) {
		Objects.requireNonNull(orderItem, "orderItem parameter is not initialized");
		if(orderItems == null) {
			return;
		}
		orderItems.remove(orderItem);
	}
	
	public void addShoppingCartItem(ShoppingCartItem shoppingCartItem) {
		Objects.requireNonNull(shoppingCartItem, "shoppingCartItem parameter is not initialized");
		if(shoppingCartItems == null) {
			shoppingCartItems = new HashSet<>();
		}
		shoppingCartItems.add(shoppingCartItem);
		shoppingCartItem.setProduct(this);
	}
	
	public void removeShoppingCartItem(ShoppingCartItem shoppingCartItem) {
		Objects.requireNonNull(shoppingCartItem, "shoppingCartItem parameter is not initialized");
		if(shoppingCartItems == null) {
			return;
		}
		shoppingCartItems.remove(shoppingCartItem);
	}
}
