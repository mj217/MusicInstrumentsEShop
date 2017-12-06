package com.musicinstruments.entity;

import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@OneToMany(mappedBy = "parentCategory")
	private HashSet<Category> subCategories = new HashSet<Category>();
	
	@ManyToMany(mappedBy = "categories")
	private HashSet<Product> products;
	
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
	
	public HashSet<Category> getSubCategories() {
		return subCategories;
	}
	
	public void setSubCategories(HashSet<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
	public HashSet<Product> getProducts() {
		return products;
	}
	
	public void setProducts() {
		this.products = products;
	}
	
}
