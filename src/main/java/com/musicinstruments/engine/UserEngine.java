package com.musicinstruments.engine;

import com.musicinstruments.entity.User;

public interface UserEngine {

	public User findUserByEmail(String email);	
	public User register(String name, String hashedPassword, String address, String phone, String mail);
	public void updateProfile();
	public void logIn(String mail, String password);
	public void logOut();
	public void createOrder();
	
}
