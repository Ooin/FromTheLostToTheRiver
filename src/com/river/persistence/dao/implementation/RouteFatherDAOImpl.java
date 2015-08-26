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
import com.river.entity.RouteFather;
import com.river.persistence.dao.interfaces.RouteFatherDAO;


@Service
public class RouteFatherDAOImpl extends AbstractDAO implements RouteFatherDAO {

	@Override
	public RouteFather create(RouteFather toCreate) {

		if (toCreate.getCreator() != null) {
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
	public RouteFather read(RouteFather toRead) {
		RouteFather readed = null;
		Session session = sessionFactory.getCurrentSession();
		
		readed = (RouteFather) session.get(RouteFather.class, toRead.getId());// (RouteFather)
																				// query.list().get(0);

		return readed;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RouteFather> read() {
		List<RouteFather> routeFathers = new ArrayList<RouteFather>();
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from RouteFather");
		routeFathers = (List<RouteFather>) query.list();
		
		return routeFathers;
	}

	@Override
	public RouteFather update(RouteFather toUpdate) {

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

	@Override
	public RouteFather delete(RouteFather toDelete) {
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
	public List<RouteFather> listMatchingRoutes(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RouteFather readRouteFatherWithRatesList(RouteFather routeFather) {
		RouteFather readed = null;
		Session session = sessionFactory.getCurrentSession();
		
		readed = (RouteFather) session.get(RouteFather.class, routeFather.getId());// (RouteFather)
																				// query.list().get(0);
		Hibernate.initialize(readed);
		Hibernate.initialize(readed.getRates());

		return readed;
	}

	@Override
	public RouteFather readRouteFatherWithStepsList(RouteFather routeFather) {
		RouteFather readed = null;
		Session session = sessionFactory.getCurrentSession();
		readed = (RouteFather) session.get(RouteFather.class, routeFather.getId());
		Hibernate.initialize(readed);
		Hibernate.initialize(readed.getRouteSteps());
		return readed;
	}
	
}
