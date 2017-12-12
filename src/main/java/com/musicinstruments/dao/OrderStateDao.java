package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.OrderState;

@Transactional
public class OrderStateDao implements Dao<OrderState, Integer> {

	private SessionFactory sessionFactory;
	
	@Override
	public void persist(OrderState orderState) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderState);
	}
	
	@Override
	public void update(OrderState orderState) {
		Session session = sessionFactory.getCurrentSession();
		session.update(orderState);
	}
	
	@Override
	public OrderState findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderState.class);
		criteria.add(Restrictions.eq("id", id));
		return (OrderState) criteria.uniqueResult();
	}
	
	@Override
	public void delete(OrderState orderState) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(orderState);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderState> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderState.class);
		return criteria.list();
	}
	
	@Override
	public void deleteAll() {
		List<OrderState> entityList = findAll();
		for(OrderState entity : entityList) {
			delete(entity);
		}
	}
	
	/*
	public OrderState getOrderStateByName(String orderStateName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderState.class);
		criteria.add(Restrictions.eq("name", orderStateName));
		return (OrderState) criteria.uniqueResult();
	}*/
}
