package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.river.entity.Stop;
import com.river.persistence.dao.interfaces.StopDAO;

@Service
public class StopDAOImpl extends AbstractDAO implements StopDAO {

	@Override
	public Stop create(Stop toCreate) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.persist(toCreate);
		} catch (HibernateException e) {
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
			readed = (Stop) session.get(Stop.class, toRead.getId());
		}
		return readed;
	}

	@Override
	public List<Stop> read() {
		List<Stop> stops = new ArrayList<Stop>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Stop");
		stops = (List<Stop>) query.list();
		if(stops == null){
			stops = new ArrayList<Stop>();
		}
		return stops;
	}

	@Override
	public Stop update(Stop toUpdate) {
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
	public Stop delete(Stop toDelete) {
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
