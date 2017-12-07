package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.Category;

@Transactional
public class CategoryDao {

	private SessionFactory sessionFactory;
	
	public Category getCategoryByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", id));
		return (Category) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		return criteria.list();
	}
	
	public Category getParentCategoryByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", id));
		return ((Category) criteria.uniqueResult()).getParentCategory();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getSubCategoriesByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("parentCategoryId", id));
		return criteria.list();
	}
}
