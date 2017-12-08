package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.OrderState;

@Transactional
public class OrderStateDao {

	private SessionFactory sessionFactory;
	
	public OrderState getOrderStateById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderState.class);
		criteria.add(Restrictions.eq("id", id));
		return (OrderState) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderState> getAllOrderStates() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderState.class);
		return criteria.list();
	}
	
	public OrderState getOrderStateByName(String orderStateName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrderState.class);
		criteria.add(Restrictions.eq("name", orderStateName));
		return (OrderState) criteria.uniqueResult();
	}
}
