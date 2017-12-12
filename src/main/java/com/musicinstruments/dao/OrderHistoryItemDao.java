package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.musicinstruments.entity.OrderHistoryItem;

public class OrderHistoryItemDao implements Dao<OrderHistoryItem, Integer> {

	private SessionFactory sessionFactory;
	
	@Override
	public void persist(OrderHistoryItem orderHistoryItem) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderHistoryItem);
	}
	
	@Override
	public void update(OrderHistoryItem orderHistoryItem) {
		Session session = sessionFactory.getCurrentSession();
		session.update(orderHistoryItem);
	}
	
	@Override 
	public OrderHistoryItem findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderHistoryItem.class);
		criteria.add(Restrictions.eq("id", id));
		return (OrderHistoryItem) criteria.uniqueResult();
	}
	
	@Override
	public void delete(OrderHistoryItem orderHistoryItem) {
		/*Session session = sessionFactory.getCurrentSession();
		session.delete(orderHistoryItem);*/
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderHistoryItem> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderHistoryItem.class);
		return criteria.list();
	}
	
	@Override
	public void deleteAll() {
		/*List<OrderHistoryItem> entityList = findAll();
		for(OrderHistoryItem entity : entityList) {
			delete(entity);
		}*/
	}
}
