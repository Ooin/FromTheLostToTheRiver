package com.river.persistence.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.river.entity.Line;

public class LineDAOImpl implements LineDAO{
	
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Line create(Line toCreate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			session.persist(toCreate);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			toCreate = null;
		}
		return toCreate;
	}

	@Override
	public Line read(Line toRead) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Line> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Line update(Line toUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Line delete(Line toDelete) {
		// TODO Auto-generated method stub
		return null;
	}

}
