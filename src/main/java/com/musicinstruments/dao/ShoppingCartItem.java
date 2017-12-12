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

@Repository
public class ShoppingCartItem implements Dao<ShoppingCartItem, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void persist(ShoppingCartItem shoppingCartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.save(shoppingCartItem);
	}
	
	@Override
	@Transactional
	public void update(ShoppingCartItem shoppingCartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.update(shoppingCartItem);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public ShoppingCartItem findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ShoppingCartItem.class);
		criteria.add(Restrictions.eq("id", id));
		return (ShoppingCartItem) criteria.uniqueResult();
	}
	
	@Override
	@Transactional
	public void delete(ShoppingCartItem shoppingCartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(shoppingCartItem);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@SuppressWarnings("unchecked")
	public List<ShoppingCartItem> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ShoppingCartItem.class);
		return criteria.list();
	}
	
	@Override
	@Transactional
	public void deleteAll() {
		List<ShoppingCartItem> entityList = findAll();
		for(ShoppingCartItem entity : entityList) {
			delete(entity);
		}
	}
}
