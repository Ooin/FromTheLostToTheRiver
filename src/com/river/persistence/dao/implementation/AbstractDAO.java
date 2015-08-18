package com.river.persistence.dao.implementation;

import org.hibernate.SessionFactory;

public abstract class AbstractDAO {
	
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
