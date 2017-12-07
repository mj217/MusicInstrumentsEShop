package com.musicinstruments.entity;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.musicinstruments.utils.UserState;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "HashedPassword")
	private String hashedPassword;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "UserState")
	private UserState userState;
	
	@OneToMany(mappedBy = "user",
				fetch = FetchType.EAGER)
	private HashSet<UserRole> userRoles = new HashSet<>();
	
	@OneToMany(mappedBy = "customer",
				fetch = FetchType.LAZY)
	private HashSet<Order> customerOrders = new HashSet<>();;
	
	@OneToMany(mappedBy = "manager",
				fetch = FetchType.LAZY)
	private HashSet<Order> managerOrders = new HashSet<>();;
	
	@OneToMany(mappedBy = "modifiedBy",
				fetch = FetchType.LAZY)
	private HashSet<OrderHistoryItem> orderHistoryItems = new HashSet<>();;
	
	@OneToMany(mappedBy = "customer",
				fetch = FetchType.LAZY)
	private HashSet<ShoppingCartItem> shoppingCartItems = new HashSet<>();;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getHashedPassword() {
		return hashedPassword;
	}
	
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserState getUserState() {
		return userState;
	}
	
	public void setUserState(UserState userState) {
		this.userState = userState;
	}
	
	public HashSet<UserRole> getRoles() {
		return userRoles;
	}
	
	public void setRoles(HashSet<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	public HashSet<Order> getCustomerOrders() {
		return customerOrders;
	}
	
	public void setCustomerOrders(HashSet<Order> customerOrders) {
		this.customerOrders = customerOrders;
	}
	
	public HashSet<Order> getManagerOrders() {
		return managerOrders;
	}
	
	public void setManagerOrders(HashSet<Order> managerOrders) {
		this.managerOrders = managerOrders;
	}
	
	public HashSet<OrderHistoryItem> getOrderHistoryItems() {
		return orderHistoryItems;
	}
	
	public void setOrderHistoryItems(HashSet<OrderHistoryItem> orderHistoryItems) {
		this.orderHistoryItems = orderHistoryItems;
	}
	
	public HashSet<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}
	
	public void setShoppingCartItems(HashSet<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}
}
