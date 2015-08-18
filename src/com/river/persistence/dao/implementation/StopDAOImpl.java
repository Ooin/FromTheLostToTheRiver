package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.river.entity.Stop;
import com.river.persistence.dao.StopDAO;

public class StopDAOImpl implements StopDAO {

	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Stop create(Stop toCreate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.persist(toCreate);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			toCreate = null;
		}
		return toCreate;
	}

	public Stop read(Stop toRead) {
		Stop readed = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		readed = (Stop) session.get(Stop.class, toRead.getId());
		transaction.commit();

		return readed;
	}

	public List<Stop> read() {
		List<Stop> stops = new ArrayList<Stop>();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Rafter");
		stops = (List<Stop>) query.list();
		transaction.commit();
		return stops;
	}

	public Stop update(Stop toUpdate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(toUpdate);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			toUpdate = null;
		}
		return toUpdate;
	}

	public Stop delete(Stop toDelete) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(toDelete);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			toDelete = null;
		}
		return toDelete;
	}
}
