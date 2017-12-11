package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.Category;
import com.musicinstruments.entity.Product;

@Repository
@Transactional
public class ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public Product findProductByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.createCriteria(Product.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> result = session.createCriteria(Product.class)
				.list();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findProductsByCategoryName(String categoryName) {
		Session session = sessionFactory.getCurrentSession();
		Category category = categoryDao.getCategoryByName(categoryName);
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("category.id", category.getId()));
		List<Product> result = (List<Product>) criteria.list();
		return result;
	}
	
	public void save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
	
	public void deleteById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.createCriteria(Product.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();

		if(product != null) {
			session.delete(product);
		}
	}
}
