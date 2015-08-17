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

	public Rafter create(Rafter toCreate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(toCreate);
		tx.commit();
		return toCreate;
	}

	public Rafter read(Rafter toRead) {
		Rafter readed = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		readed = (Rafter) session.load(Rafter.class, toRead.getId());
		tx.commit();
		
		return readed;
	}

	public List<Rafter> read() {
		// TODO Auto-generated method stub
		return null;
	}

	public Rafter update(Rafter toUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	public Rafter delete(Rafter toDelete) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
