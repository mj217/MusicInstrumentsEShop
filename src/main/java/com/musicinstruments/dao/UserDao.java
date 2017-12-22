package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.musicinstruments.entity.Role;
//import com.musicinstruments.entity.UserState;

import com.musicinstruments.entity.User;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UserDao /*implements Dao<User, Integer>*/ {

	@Autowired
	private SessionFactory sessionFactory;
	//private RoleDao roleDao;
	//private UserStateDao userStateDao;
	
	//@Override
	public void persist(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	//@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}
	
	//@Override
	public User findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		return (User) criteria.uniqueResult();
	}
	
	//@Override
	public void delete(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}
	
	//@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		return criteria.list();
	}
	
	//@Override
	public void deleteAll() {
		List<User> entityList = findAll();
		for(User entity : entityList) {
			delete(entity);
		}
	}

	//@Override
	public User findByName(String name) {
		return null;
		
	}
	
	/*
	@SuppressWarnings("unchecked")
	public List<User> getUsersByRoleName(String roleName) {
		Session session = sessionFactory.getCurrentSession();
		Role role = roleDao.getRoleByName(roleName);
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("role.id", role.getId()));
		List<User> users = (List<User>) criteria.list();
		return users;
	}*/
	
	/*
	@SuppressWarnings("unchecked")
	public List<User> getUsersByUserStateName(String userStateName) {
		Session session = sessionFactory.getCurrentSession();
		UserState userState = userStateDao.getUserStateByName(userStateName);
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userState.id", userState.getId()));
		List<User> users = (List<User>) criteria.list( );
		return users;
	}*/
}
