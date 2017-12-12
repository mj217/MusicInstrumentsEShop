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

import com.musicinstruments.entity.OrderHistoryItem;

@Repository
public class OrderHistoryItemDao implements Dao<OrderHistoryItem, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void persist(OrderHistoryItem orderHistoryItem) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderHistoryItem);
	}
	
	@Override
	@Transactional
	public void update(OrderHistoryItem orderHistoryItem) {
		Session session = sessionFactory.getCurrentSession();
		session.update(orderHistoryItem);
	}
	
	@Override 
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public OrderHistoryItem findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderHistoryItem.class);
		criteria.add(Restrictions.eq("id", id));
		return (OrderHistoryItem) criteria.uniqueResult();
	}
	
	@Override
	@Transactional
	public void delete(OrderHistoryItem orderHistoryItem) {
		/*Session session = sessionFactory.getCurrentSession();
		session.delete(orderHistoryItem);*/
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@SuppressWarnings("unchecked")
	public List<OrderHistoryItem> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderHistoryItem.class);
		return criteria.list();
	}
	
	@Override
	@Transactional
	public void deleteAll() {
		/*List<OrderHistoryItem> entityList = findAll();
		for(OrderHistoryItem entity : entityList) {
			delete(entity);
		}*/
	}
}
