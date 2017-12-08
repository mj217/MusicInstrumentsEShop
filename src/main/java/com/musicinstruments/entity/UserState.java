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

@Entity
@Table(name = "UserStates")
public class UserState {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "userState", fetch = FetchType.EAGER)
	private HashSet<User> users = new HashSet<>();
	
	public Integer getId(Integer id) {
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
	
	public HashSet<User> getUsers() {
		return users;
	}
	
	public void setUsers(HashSet<User> users) {
		this.users = users;
	}
}
