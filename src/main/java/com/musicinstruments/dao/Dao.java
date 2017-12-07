package com.musicinstruments.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class Dao {

	private SessionFactory sessionFactory;
	
	
	
}
