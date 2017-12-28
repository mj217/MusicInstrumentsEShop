package com.musicinstruments.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.musicinstruments.utils.CommonUtil;

@Entity
@Table(name = "Categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Name")
	private String name;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "ParentCategoryID")
	private Category parentCategory;
	
	@OneToMany(mappedBy = "parentCategory",
				fetch = FetchType.EAGER)
	private Set<Category> subCategories;
	
	@ManyToMany(mappedBy = "categories")
	private Set<Product> products;
	
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
		return CommonUtil.getSafeSet(subCategories);
	}
	
	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
	public Set<Product> getProducts() {
		return CommonUtil.getSafeSet(products);
	}
	
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public void addSubcategory(final Category category) {
		Objects.requireNonNull(category, "category parameter is not initialized");
		if(subCategories == null) {
			subCategories = new HashSet<>();
		}
		subCategories.add(category);
		category.setParentCategory(this);
	}
	
	public void removeSubCategory(final Category category) {
		Objects.requireNonNull(category, "category parameter is not initialized");
		if(subCategories == null) {
			return;
		}
		subCategories.remove(category);
	}

}
