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

import com.musicinstruments.entity.OrderState;

@Repository
public class OrderStateDao implements Dao<OrderState, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void persist(OrderState orderState) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderState);
	}
	
	@Override
	@Transactional
	public void update(OrderState orderState) {
		Session session = sessionFactory.getCurrentSession();
		session.update(orderState);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public OrderState findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderState.class);
		criteria.add(Restrictions.eq("id", id));
		return (OrderState) criteria.uniqueResult();
	}
	
	@Override
	@Transactional
	public void delete(OrderState orderState) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(orderState);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@SuppressWarnings("unchecked")
	public List<OrderState> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderState.class);
		return criteria.list();
	}
	
	@Override
	@Transactional
	public void deleteAll() {
		List<OrderState> entityList = findAll();
		for(OrderState entity : entityList) {
			delete(entity);
		}
	}
	
	@Transactional
	public OrderState findByName(String orderStateName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderState.class);
		criteria.add(Restrictions.eq("name", orderStateName));
		return (OrderState) criteria.uniqueResult();
	}
}
