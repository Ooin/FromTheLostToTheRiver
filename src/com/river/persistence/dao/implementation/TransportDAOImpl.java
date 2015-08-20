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
import com.river.entity.Transport;
import com.river.persistence.dao.interfaces.TransportDAO;

@Service
public class TransportDAOImpl extends AbstractDAO implements TransportDAO {

	@Override
	public Transport create(Transport toCreate) {
		if (toCreate.getName() != null) {
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
	public Transport read(Transport toRead) {
		Transport readed = null;
		if (toRead.getId() != null) {
			Session session = sessionFactory.getCurrentSession();
			readed = (Transport) session.get(Transport.class, toRead.getId());
		}
		return readed;
	}

	@Override
	public List<Transport> read() {
		List<Transport> transports = new ArrayList<Transport>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Transport");
		transports = (List<Transport>) query.list();
		System.out.println(transports);
		return transports;
	}

	@Override
	public Transport update(Transport toUpdate) {
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
	public Transport delete(Transport toDelete) {
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

	@Override
	public Transport readWithInitializedLineslist(Transport transport) {
		Transport readed = null;
		Session session = sessionFactory.getCurrentSession();
		readed = (Transport) session.get(Transport.class, transport.getId());
		Hibernate.initialize(readed);
		Hibernate.initialize(readed.getLines());
		return readed;
	}

}
