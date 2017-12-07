package com.musicinstruments.engine;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.entity.User;

@Transactional
public abstract class UserEngineImpl implements UserEngine {
	
	private SessionFactory sessionFactory;
	
	@Override
	public User findUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", "value"));
		return (User) criteria.uniqueResult();
	}
	
	@Override
	public User register(String name, String hashedPassword, String address, 
			String phone, String email) {
		Session session = sessionFactory.getCurrentSession();	
		User user = new User();
		user.setName(name);
		user.setHashedPassword(hashedPassword);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		session.save(user);
		return user;
	}
	
	@Override
	public void updateProfile() {
		//...
	}
	
	@Override
	public void logIn(String email, String hashedPassword) {
		//...
	}
	
	@Override 
	public void logOut() {
		//...
	}
	
	@Override
	public abstract void createOrder();
}
