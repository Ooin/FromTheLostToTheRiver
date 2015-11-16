package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.river.entity.Address;
import com.river.entity.Rafter;
import com.river.persistence.dao.interfaces.AddressDAO;

@Service
public class AddressDAOImpl extends AbstractDAO implements AddressDAO {

	public Address create(Address toCreate) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(toCreate);
		} catch (HibernateException e) {
			e.printStackTrace();
			toCreate = null;
		}
		return toCreate;
	}

	public Address read(Address toRead) {
		Address readed = null;
		Session session = sessionFactory.getCurrentSession();
		readed = (Address) session.get(Address.class, toRead.getId());
		return readed;

	}

	@SuppressWarnings("unchecked")
	public List<Address> read() {
		List<Address> addresses = new ArrayList<Address>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Address");
		addresses = (List<Address>) query.list();
		return addresses;
	}

	public Address update(Address toUpdate) {

		if (toUpdate.getId() != null) {

			Session session = sessionFactory.getCurrentSession();
			try {
				session.update(toUpdate);
			} catch (HibernateException e) {
				e.printStackTrace();
				toUpdate = null;
			}
		} else {
			toUpdate = null;
		}

		return toUpdate;
	}

	public Address delete(Address toDelete) {
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
	public Address readWithInitializedStopslist(Address address) {
		Address readed = null;
		Session session = sessionFactory.getCurrentSession();
		readed = (Address) session.get(Address.class, address.getId());
		Hibernate.initialize(readed);
		Hibernate.initialize(readed.getStops());
		return readed;
	}

	@Override
	public Address readWithInitializedOriginslist(Address address) {
		Address readed = null;
		Session session = sessionFactory.getCurrentSession();
		readed = (Address) session.get(Address.class, address.getId());
		Hibernate.initialize(readed);
		Hibernate.initialize(readed.getOrigins());
		return readed;
	}

	@Override
	public Address readWithInitializedDestinieslist(Address address) {
		Address readed = null;
		Session session = sessionFactory.getCurrentSession();
		readed = (Address) session.get(Address.class, address.getId());
		Hibernate.initialize(readed);
		Hibernate.initialize(readed.getDestinies());
		return readed;
	}

}
