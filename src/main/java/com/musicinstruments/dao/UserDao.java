package com.musicinstruments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.Role;
import com.musicinstruments.entity.User;

@Transactional
public class UserDao {

	private SessionFactory sessionFactory;
	
	private RoleDao roleDao;
	
	public User getUserByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		return (User) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsersByRoleName(String roleName) {
		Session session = sessionFactory.getCurrentSession();
		Role role = roleDao.getRoleByName(roleName);
		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.eq("role.id", role.getId()));
		List<User> users = (List<User>) criteria.list();
		return users;
	}
}
