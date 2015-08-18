package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.river.entity.Transport;
import com.river.persistence.dao.TransportDAO;

public class TransportDAOImpl implements TransportDAO{
	
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Retrieve a Transport and insert to the data base all information about Transport 
	 * @param toCreate object for persist to the data base.
	 * @return the transport object the id assigned. If the persist couldn't be created return Null.
	 */
	@Override
	public Transport create(Transport toCreate) {
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


	/**
	 * Retrieve a Transport and show the Transport object
	 * @param toRead object for read on data base.
	 * @return the transport object the id assigned. If couldn't be read return Null.
	 */
	@Override
	public Transport read(Transport toRead) {
		Transport readed = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		readed = (Transport) session.get(Transport.class, toRead.getId());
		transaction.commit();
		
		return readed;
	}

	/**
	 * Retrieve a Transport list and show the Transport object
	 * @return the transport object the id assigned. If the persist couldn't be created return Null.
	 */
	@Override
	public List<Transport> read() {
		List<Transport> transports = new ArrayList<Transport>();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from transport");
		transports = (List<Transport>) query.list();
		transaction.commit();
		return transports;
	}

	@Override
	public Transport update(Transport toUpdate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try{
			session.update(toUpdate);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			toUpdate = null;
		}
		return toUpdate;
	}

	@Override
	public Transport delete(Transport toDelete) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try{
			session.delete(toDelete);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			toDelete = null;
		}
		return toDelete;
	}

}
