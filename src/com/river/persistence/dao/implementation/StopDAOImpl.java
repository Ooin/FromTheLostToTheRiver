package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.river.entity.Stop;
import com.river.persistence.dao.interfaces.DAO;

public class StopDAOImpl extends AbstractDAO implements DAO<Stop> {

	@Override
	public Stop create(Stop toCreate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.persist(toCreate);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			toCreate = null;
		}
		return toCreate;
	}

	@Override
	public Stop read(Stop toRead) {
		Stop readed = null;
		if (toRead.getId() != null) {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			readed = (Stop) session.get(Stop.class, toRead.getId());
			transaction.commit();
		}
		return readed;
	}

	@Override
	public List<Stop> read() {
		List<Stop> stops = new ArrayList<Stop>();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Stop");
		stops = (List<Stop>) query.list();
		transaction.commit();
		if(stops == null){
			stops = new ArrayList<Stop>();
		}
		return stops;
	}

	@Override
	public Stop update(Stop toUpdate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(toUpdate);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			toUpdate = null;
		}
		return toUpdate;
	}

	@Override
	public Stop delete(Stop toDelete) {
		if (toDelete.getId() != null) {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			try {
				session.delete(toDelete);
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				tx.rollback();
				toDelete = null;
			}
		} else {
			toDelete = null;
		}
		return toDelete;
	}
}
