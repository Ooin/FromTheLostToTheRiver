package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.river.entity.Rafter;
import com.river.persistence.dao.interfaces.RafterDAO;

@Service
public class RafterDAOImpl extends AbstractDAO implements RafterDAO {

	public Rafter create(Rafter toCreate) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.persist(toCreate);

		} catch (HibernateException e) {
			e.printStackTrace();
			toCreate = null;
		}
		return toCreate;
	}

	public Rafter read(Rafter toRead) {
		Rafter readed = null;
		Session session = sessionFactory.getCurrentSession();

		readed = (Rafter) session.get(Rafter.class, toRead.getId());// (Rafter)
																	// query.list().get(0);

		return readed;

	}

	@SuppressWarnings("unchecked")
	public List<Rafter> read() {
		List<Rafter> rafters = new ArrayList<Rafter>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Rafter");
		rafters = (List<Rafter>) query.list();
		return rafters;
	}

	public Rafter update(Rafter toUpdate) {

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

	public Rafter delete(Rafter toDelete) {
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
	public Rafter readWithInitializedlist(Rafter rafter) {
		Rafter readed = null;
		Session session = sessionFactory.getCurrentSession();
		readed = (Rafter) session.get(Rafter.class, rafter.getId());// (Rafter)
																	// query.list().get(0);
		Hibernate.initialize(readed);
		Hibernate.initialize(readed.getRoutes());
		return readed;
	}

}
