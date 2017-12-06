package com.musicinstruments.entity;

import java.math.BigDecimal;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
			name = "ProductCategory",
			joinColumns = { @JoinColumn(name = "ProductID") },
			inverseJoinColumns = { @JoinColumn(name = "CategoryID") }
	)
	private HashSet<Category> categories = new HashSet<>();
	
	@Column(name = "Price")
	private BigDecimal price;
	
	@Column(name = "Supplier")
	private String supplier;
	
	@Column(name = "QuantityInStock")
	private Integer quantityInStock;
	
	public Product() {}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public HashSet<Category> getCategories() {
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
}