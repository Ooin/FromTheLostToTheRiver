package com.river.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.river.entity.Rafter;

public class RafterDAOImpl implements RafterDAO{
	
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Rafter Create(Rafter toCreate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(toCreate);
		tx.commit();
		return toCreate;
	}

	public Rafter Read(Rafter toRead) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Rafter> read() {
		// TODO Auto-generated method stub
		return null;
	}

	public Rafter Update(Rafter toUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	public Rafter Delete(Rafter toDelete) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
