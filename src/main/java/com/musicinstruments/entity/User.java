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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.musicinstruments.utils.CommonUtil;


@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@ManyToOne
	@JoinColumn(name = "UserStateID", nullable = false)
	private UserState userState;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "UserRoles",
			joinColumns = { @JoinColumn(name = "UserID") },
			inverseJoinColumns = { @JoinColumn(name = "RoleID") }
	)
	private Set<Role> roles;
	
	@OneToMany(mappedBy = "customer",
				fetch = FetchType.LAZY)
	private Set<Order> customerOrders;
	
	@OneToMany(mappedBy = "manager",
				fetch = FetchType.LAZY)
	private Set<Order> managerOrders;
	
	@OneToMany(mappedBy = "modifiedBy",
				fetch = FetchType.LAZY)
	private Set<OrderHistoryItem> orderHistoryItems;
	
	@OneToMany(mappedBy = "customer",
				fetch = FetchType.LAZY)
	private Set<ShoppingCartItem> shoppingCartItems;
	
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
		this. userState = userState;
	}
	
	public Set<Role> getRoles() {
		return CommonUtil.getSafeSet(roles);
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Set<Order> getCustomerOrders() {
		return CommonUtil.getSafeSet(customerOrders);
	}
	
	public void setCustomerOrders(Set<Order> customerOrders) {
		this.customerOrders = customerOrders;
	}
	
	public Set<Order> getManagerOrders() {
		return CommonUtil.getSafeSet(managerOrders);
	}
	
	public void setManagerOrders(Set<Order> managerOrders) {
		this.managerOrders = managerOrders;
	}
	
	public Set<OrderHistoryItem> getOrderHistoryItems() {
		return CommonUtil.getSafeSet(orderHistoryItems);
	}
	
	public void setOrderHistoryItems(Set<OrderHistoryItem> orderHistoryItems) {
		this.orderHistoryItems = orderHistoryItems;
	}
	
	public Set<ShoppingCartItem> getShoppingCartItems() {
		return CommonUtil.getSafeSet(shoppingCartItems);
	}
	
	public void setShoppingCartItems(Set<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}
}
