package com.river.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
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
		Transaction transaction = session.beginTransaction();
		readed = (Rafter) session.get(Rafter.class, toRead.getId());//(Rafter) query.list().get(0);
		transaction.commit();
		
		return readed;
		
	}

	public List<Rafter> read() {
		List<Rafter> rafters = new ArrayList<Rafter>();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Rafter");
		rafters = query.list();
		transaction.commit();
		return rafters;
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
