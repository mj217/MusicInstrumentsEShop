package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.musicinstruments.entity.OrderItem;

public class OrderItemDao implements Dao<OrderItem, Integer> {

	private SessionFactory sessionFactory;
	
	@Override
	public void persist(OrderItem orderItem) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderItem);
	}
	
	@Override
	public void update(OrderItem orderItem) {
		Session session = sessionFactory.getCurrentSession();
		session.update(orderItem);
	}
	
	@Override
	public OrderItem findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderItem.class);
		criteria.add(Restrictions.eq("id", id));
		return (OrderItem) criteria.uniqueResult();
	}
	
	@Override
	public void delete(OrderItem orderItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(orderItem);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderItem> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderItem.class);
		return criteria.list();
	}
	
	@Override
	public void deleteAll() {
		List<OrderItem> entityList = findAll();
		for(OrderItem entity : entityList) {
			delete(entity);
		}
	}
}
