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

import com.musicinstruments.entity.Role;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class RoleDao implements Dao<Role, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persist(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.save(role);
	}
	
	@Override
	public void update(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.update(role);
	}
	
	@Override
	public Role findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.eq("id", id));
		return (Role) criteria.uniqueResult();
	}
	
	@Override
	public void delete(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(role);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Role> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		return criteria.list();
	}
	
	@Override
	public void deleteAll() {
		List<Role> entityList = findAll();
		for(Role entity : entityList) {
			delete(entity);
		}
	}
	
	/*@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Role findByName(String roleName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.eq("name", roleName));
		return (Role) criteria.uniqueResult();
	}*/
}
