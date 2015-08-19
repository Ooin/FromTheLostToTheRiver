package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.river.entity.Rate;
import com.river.persistence.dao.interfaces.RateDAO;

public class RateDAOImpl extends AbstractDAO implements RateDAO {

	@Override
	public Rate create(Rate toCreate) {
		if (toCreate.getCreator() != null && toCreate.getComment() != null && toCreate.getRoute() != null) {
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

	@Override
	public Rate read(Rate toRead) {
		Rate readed = null;
		if (toRead.getId() != null) {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			readed = (Rate) session.get(Rate.class, toRead.getId());
			transaction.commit();
		}
		return readed;
	}

	@Override
	public List<Rate> read() {
		List<Rate> rates = new ArrayList<Rate>();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Rate");
		rates = (List<Rate>) query.list();
		System.out.println(rates);
		transaction.commit();
		return rates;
	}

	@Override
	public Rate update(Rate toUpdate) {
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
		return toUpdate;
	}

	@Override
	public Rate delete(Rate toDelete) {
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

}
