package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.Order;

@Transactional
public class OrderDao {

	private SessionFactory sessionFactory;
	
	public Order getOrderByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("id", id));
		return (Order) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Order.class);
		return criteria.list();
	}
	
}
