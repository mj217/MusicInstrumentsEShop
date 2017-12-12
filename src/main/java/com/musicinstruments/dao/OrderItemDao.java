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

import com.musicinstruments.entity.OrderItem;

@Repository
public class OrderItemDao implements Dao<OrderItem, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void persist(OrderItem orderItem) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderItem);
	}
	
	@Override
	@Transactional
	public void update(OrderItem orderItem) {
		Session session = sessionFactory.getCurrentSession();
		session.update(orderItem);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public OrderItem findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderItem.class);
		criteria.add(Restrictions.eq("id", id));
		return (OrderItem) criteria.uniqueResult();
	}
	
	@Override
	@Transactional
	public void delete(OrderItem orderItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(orderItem);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@SuppressWarnings("unchecked")
	public List<OrderItem> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderItem.class);
		return criteria.list();
	}
	
	@Override
	@Transactional
	public void deleteAll() {
		List<OrderItem> entityList = findAll();
		for(OrderItem entity : entityList) {
			delete(entity);
		}
	}
}
