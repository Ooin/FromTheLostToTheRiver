package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.river.entity.Rate;
import com.river.persistence.dao.interfaces.RateDAO;

@Service
public class RateDAOImpl extends AbstractDAO implements RateDAO {

	@Override
	public Rate create(Rate toCreate) {
		if (toCreate.getCreator() != null && toCreate.getComment() != null && toCreate.getRoute() != null) {
			Session session = sessionFactory.getCurrentSession();

			try {
				session.persist(toCreate);
			} catch (HibernateException e) {
				e.printStackTrace();
				toCreate = null;
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
			readed = (Rate) session.get(Rate.class, toRead.getId());
		}
		return readed;
	}

	@Override
	public List<Rate> read() {
		List<Rate> rates = new ArrayList<Rate>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Rate");
		rates = (List<Rate>) query.list();
		System.out.println(rates);
		return rates;
	}

	@Override
	public Rate update(Rate toUpdate) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(toUpdate);
		} catch (HibernateException e) {
			e.printStackTrace();
			toUpdate = null;
		}
		return toUpdate;
	}

	@Override
	public Rate delete(Rate toDelete) {
		if (toDelete.getId() != null) {
			Session session = sessionFactory.getCurrentSession();
			try {
				session.delete(toDelete);
			} catch (HibernateException e) {
				e.printStackTrace();
				toDelete = null;
			}
		} else {
			toDelete = null;
		}
		return toDelete;
	}

}
