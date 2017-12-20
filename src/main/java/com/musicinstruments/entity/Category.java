package com.musicinstruments.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Name")
	private String name;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "ParentCategoryID")
	private Category parentCategory;
	
	@OneToMany(mappedBy = "parentCategory",
				fetch = FetchType.EAGER)
	private Set<Category> subCategories = new HashSet<Category>();
	
	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<>();
	
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
	
	public Category getParentCategory() {
		return parentCategory;
	}
	
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	
	public Set<Category> getSubCategories() {
		return subCategories;
	}
	
	public void setSubCategories(HashSet<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	
	public void setProducts(HashSet<Product> products) {
		this.products = products;
	}
	
}
