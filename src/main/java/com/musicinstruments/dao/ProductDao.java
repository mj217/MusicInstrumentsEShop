package com.musicinstruments.dao;

import java.util.List;

//import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.musicinstruments.entity.Category;
import com.musicinstruments.entity.Product;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ProductDao implements Dao<Product, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persist(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}
	
	@Override
	public void update(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}
	
	@Override
	public Product findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.createCriteria(Product.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		return product;
	}
	
	@Override
	public void delete(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> result = session.createCriteria(Product.class)
				.list();
		return result;
	}
	
	@Override
	public void deleteAll() {
		List<Product> entityList = findAll();
		for(Product entity : entityList) {
			delete(entity);
		}
	}

	@Override
	public Product findByName(String name) {
		return null;
		
	}
	
	/*
	@SuppressWarnings("unchecked")
	public List<Product> findProductsByCategoryName(String categoryName) {
		Session session = sessionFactory.getCurrentSession();
		Category category = categoryDao.getCategoryByName(categoryName);
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("category.id", category.getId()));
		List<Product> result = (List<Product>) criteria.list();
		return result;
	}*/
}
