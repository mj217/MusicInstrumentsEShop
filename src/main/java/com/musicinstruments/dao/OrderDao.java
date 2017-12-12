package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.Order;

@Transactional
public class OrderDao implements Dao<Order, Integer> {

	private SessionFactory sessionFactory;
	
	@Override
	public void persist(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}
	
	@Override
	public void update(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.update(order);
	}
	
	@Override
	public Order findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("id", id));
		return (Order) criteria.uniqueResult();
	}
	
	@Override
	public void delete(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(order);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Order> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Order.class);
		return criteria.list();
	}
	
	
	@Override 
	public void deleteAll() {
		List<Order> entityList = findAll();
		for(Order entity: entityList) {
			delete(entity);
		}
		
	}
	
}
