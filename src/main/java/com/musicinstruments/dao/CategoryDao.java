package com.musicinstruments.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.Category;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CategoryDao /*implements Dao<Category, Integer>*/ {

	@Autowired
	private SessionFactory sessionFactory;
	
	//@Override
	public void persist(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
	}
	
	//@Override
	public void update(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.update(category);
	}
	
	//@Override
	public Category findById(Integer id) {
		return sessionFactory.
				getCurrentSession().
				get(Category.class, id);
	}
	
	//@Override
	public void delete(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(category);
	}
	
	//@Override
	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Category> criteriaQuery = builder.createQuery(Category.class);
        Root<Category> root = criteriaQuery.from(Category.class);
        criteriaQuery.select(root);
        criteriaQuery.orderBy(builder.asc(root.get("name")));
        Query<Category> query = session.createQuery(criteriaQuery);
        List<Category> list = query.getResultList();
		
		return list;
	}
	
	//@Override
	public void deleteAll() {
		List<Category> entityList = findAll();
		for(Category entity: entityList) {
			delete(entity);
		}
	}

	//@Override
	public Category findByName(String name) {
		return null;		
	}
	
}
