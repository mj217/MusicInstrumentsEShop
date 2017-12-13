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

import com.musicinstruments.entity.UserState;

@Repository
public class UserStateDao implements Dao<UserState, Integer> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void persist(UserState userState) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userState);
	}
	
	@Override
	@Transactional
	public void update(UserState userState) {
		Session session = sessionFactory.getCurrentSession();
		session.update(userState);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserState findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserState.class);
		criteria.add(Restrictions.eq("id", id));
		return (UserState) criteria.uniqueResult();
	}
	
	@Override
	@Transactional
	public void delete(UserState userState) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(userState);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@SuppressWarnings("unchecked")
	public List<UserState> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserState.class);
		return criteria.list();
	}
	
	@Override
	@Transactional
	public void deleteAll() {
		List<UserState> entityList = findAll();
		for(UserState entity : entityList) {
			delete(entity);
		}
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserState findByName(String userStateName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserState.class);
		criteria.add(Restrictions.eq("name", userStateName));
		return (UserState) criteria.uniqueResult();
	}

}
