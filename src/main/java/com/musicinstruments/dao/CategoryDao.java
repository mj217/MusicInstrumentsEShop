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

import com.musicinstruments.entity.Category;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CategoryDao implements Dao<Category, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persist(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
	}
	
	@Override
	public void update(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.update(category);
	}
	
	@Override
	public Category findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", id));
		return (Category) criteria.uniqueResult();
	}
	
	@Override
	public void delete(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(category);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		return criteria.list();
	}
	
	@Override
	public void deleteAll() {
		List<Category> entityList = findAll();
		for(Category entity: entityList) {
			delete(entity);
		}
	}
	
}
