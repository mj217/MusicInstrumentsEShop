package com.musicinstruments.entity;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Name")
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private HashSet<User> users = new HashSet<>();
	
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
		this. name = name;
	}
	
	public HashSet<User> getUsers() {
		return users;
	}
	
	public void setUsers(HashSet<User> users) {
		this.users = users;
	}
}
