package com.musicinstruments.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.dao.Dao;
import com.musicinstruments.dao.RoleDao;
import com.musicinstruments.dao.UserDao;
import com.musicinstruments.dao.UserStateDao;
import com.musicinstruments.entity.Role;
import com.musicinstruments.entity.User;
import com.musicinstruments.entity.UserState;

@Service
public class UserEngine {

	private static UserEngine instance;
	
	@Autowired 
	private UserDao userDao;
	
	@Autowired 
	private RoleDao roleDao;
	
	@Autowired
	private UserStateDao userStateDao;
	
	public UserEngine() {
		
	}
	
	public static UserEngine getInstance() {
		if (instance == null) {
			return new UserEngine();
		}
		return instance;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setUserStateDao(UserStateDao userStateDao) {
		this.userStateDao = userStateDao;
	}
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	@Transactional
	public void register(User user) {
		userDao.persist(user);
	}
	
	@Transactional
	public void updateProfile(User user) {
		userDao.update(user);
	}
	
	@Transactional
	public void assingUserToRole(User user, Role role) {
		user.getRoles().add(role);
		role.getUsers().add(user);
		userDao.update(user);
		roleDao.update(role);
	}
	
	@Transactional
	public void unassignUserFromRole(User user, Role role) {
		user.getRoles().remove(role);
		role.getUsers().remove(user);
		userDao.update(user);
		roleDao.update(role);
	}
	
	@Transactional
	public void deactivateUser(User user) {
		UserState userState = userStateDao.findByName("Inactive");
		user.setUserState(userState);
		userDao.update(user);
	}
}
