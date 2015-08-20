package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.river.entity.Address;
import com.river.entity.Rafter;
import com.river.entity.RouteFather;
import com.river.persistence.dao.interfaces.RouteFatherDAO;

public class RouteFatherDAOImpl extends AbstractDAO implements RouteFatherDAO {

	public RouteFather create(RouteFather toCreate) {

		if (toCreate.getCreator() != null) {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			try {
				session.persist(toCreate);
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				toCreate = null;
				tx.rollback();
			}
		} else {
			toCreate = null;
		}
		return toCreate;
	}

	public RouteFather read(RouteFather toRead) {
		RouteFather readed = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		readed = (RouteFather) session.get(RouteFather.class, toRead.getId());// (RouteFather)
																				// query.list().get(0);
		transaction.commit();

		return readed;

	}

	@SuppressWarnings("unchecked")
	public List<RouteFather> read() {
		List<RouteFather> routeFathers = new ArrayList<RouteFather>();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from RouteFather");
		routeFathers = (List<RouteFather>) query.list();
		transaction.commit();
		return routeFathers;
	}

	public RouteFather update(RouteFather toUpdate) {

		if (toUpdate.getId() != null) {

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			try {
				session.update(toUpdate);
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				toUpdate = null;
				tx.rollback();
			}
		} else {
			toUpdate = null;
		}

		return toUpdate;
	}

	public RouteFather delete(RouteFather toDelete) {
		if (toDelete.getId() != null) {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			try {
				session.delete(toDelete);
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				toDelete = null;
				tx.rollback();
			}
		} else {
			toDelete = null;
		}
		return toDelete;
	}

	@Override
	public List<RouteFather> listMatchingRoutes(Address address) {
		// TODO Auto-generated method stub
		return null;
	}



}
