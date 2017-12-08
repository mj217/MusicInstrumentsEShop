package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.Role;

@Transactional
public class RoleDao {

	private SessionFactory sessionFactory;
	
	public Role getRoleById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.eq("id", id));
		return (Role) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getAllRoles() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		return criteria.list();
	}
	
	public Role getRoleByName(String roleName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.eq("name", roleName));
		return (Role) criteria.uniqueResult();
	}
}
