package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.river.entity.RouteStep;
import com.river.persistence.dao.interfaces.RouteStepDAO;

public class RouteStepDAOImpl extends AbstractDAO  implements RouteStepDAO{

	public RouteStep create(RouteStep toCreate) {

		if (toCreate.getRoute() != null && toCreate.getOrigin() != null && toCreate.getDestiny() != null) {
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

	public RouteStep read(RouteStep toRead) {
		RouteStep readed = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		readed = (RouteStep) session.get(RouteStep.class, toRead.getId());//(RouteStep) query.list().get(0);
		transaction.commit();
		
		return readed;
		
	}

	@SuppressWarnings("unchecked")
	public List<RouteStep> read() {
		List<RouteStep> routeSteps = new ArrayList<RouteStep>();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from RouteStep");
		routeSteps = (List<RouteStep>) query.list();
		transaction.commit();
		return routeSteps;
	}

	public RouteStep update(RouteStep toUpdate) {
		
		if(toUpdate.getId() != null){
			
			
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			try{
				session.update(toUpdate);
				tx.commit();
			}catch(HibernateException e){
				e.printStackTrace();
				toUpdate = null;
				tx.rollback();
			}
			}else{
				toUpdate = null;
			}
			
			
		
		return toUpdate;
	}

	public RouteStep delete(RouteStep toDelete) {
		if (toDelete.getId() != null) {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			try{
				session.delete(toDelete);
				tx.commit();
			}catch(HibernateException e){
				e.printStackTrace();
				toDelete = null;
				tx.rollback();
			}
		}else{
			toDelete = null;
		}
		return toDelete;
	}



}
