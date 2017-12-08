package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.Category;
import com.musicinstruments.entity.Product;

@Transactional
public class ProductDao {

	private SessionFactory sessionFactory;
	
	private CategoryDao categoryDao;
	
	public Product getProductByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("id", id));
		return (Product) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Product.class);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductsByCategoryName(String categoryName) {
		Session session = sessionFactory.getCurrentSession();
		Category category = categoryDao.getCategoryByName(categoryName);
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("category.id", category.getId()));
		List<Product> list = (List<Product>) criteria.list();
		return list;
	}
}
