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

import com.musicinstruments.entity.Order;

@Repository
public class OrderDao implements Dao<Order, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void persist(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}
	
	@Override
	@Transactional
	public void update(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.update(order);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Order findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("id", id));
		return (Order) criteria.uniqueResult();
	}
	
	@Override
	@Transactional
	public void delete(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(order);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@SuppressWarnings("unchecked")
	public List<Order> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Order.class);
		return criteria.list();
	}
	
	
	@Override 
	@Transactional
	public void deleteAll() {
		List<Order> entityList = findAll();
		for(Order entity: entityList) {
			delete(entity);
		}
		
	}
	
}
