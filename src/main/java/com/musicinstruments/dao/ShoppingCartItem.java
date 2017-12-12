package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class ShoppingCartItem implements Dao<ShoppingCartItem, Integer> {

	private SessionFactory sessionFactory;
	
	@Override
	public void persist(ShoppingCartItem shoppingCartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.save(shoppingCartItem);
	}
	
	@Override
	public void update(ShoppingCartItem shoppingCartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.update(shoppingCartItem);
	}
	
	@Override
	public ShoppingCartItem findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ShoppingCartItem.class);
		criteria.add(Restrictions.eq("id", id));
		return (ShoppingCartItem) criteria.uniqueResult();
	}
	
	@Override
	public void delete(ShoppingCartItem shoppingCartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(shoppingCartItem);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ShoppingCartItem> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ShoppingCartItem.class);
		return criteria.list();
	}
	
	@Override
	public void deleteAll() {
		List<ShoppingCartItem> entityList = findAll();
		for(ShoppingCartItem entity : entityList) {
			delete(entity);
		}
	}
}
