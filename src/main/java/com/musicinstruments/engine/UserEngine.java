package com.musicinstruments.engine;

import org.springframework.beans.factory.annotation.Autowired;

import com.musicinstruments.dao.RoleDao;
import com.musicinstruments.dao.UserDao;
import com.musicinstruments.dao.UserStateDao;
import com.musicinstruments.entity.Role;
import com.musicinstruments.entity.User;
import com.musicinstruments.entity.UserState;

public class UserEngine {

	@Autowired 
	private UserDao userDao;
	
	@Autowired 
	private RoleDao roleDao;
	
	@Autowired
	private UserStateDao userStateDao;
	
	public void register(User user) {
		userDao.persist(user);
	}
	
	public void updateProfile(User user) {
		userDao.update(user);
	}
	
	public void assingUserToRole(User user, Role role) {
		user.getRoles().add(role);
		role.getUsers().add(user);
		userDao.update(user);
		roleDao.update(role);
	}
	
	public void unassignUserFromRole(User user, Role role) {
		user.getRoles().remove(role);
		role.getUsers().remove(user);
		userDao.update(user);
		roleDao.update(role);
	}
	
	public void deactivateUser(User user) {
		UserState userState = userStateDao.findByName("Inactive");
		user.setUserState(userState);
		userDao.update(user);
	}
}
