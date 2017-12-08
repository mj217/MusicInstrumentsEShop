package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.UserState;

@Transactional
public class UserStateDao {
	
	private SessionFactory sessionFactory;
	
	public UserState getUserStateById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserState.class);
		criteria.add(Restrictions.eq("id", id));
		return (UserState) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserState> getAllUserStates() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserState.class);
		return criteria.list();
	}
	
	public UserState getUserStateByName(String userStateName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserState.class);
		criteria.add(Restrictions.eq("name", userStateName));
		return (UserState) criteria.uniqueResult();
	}

}
