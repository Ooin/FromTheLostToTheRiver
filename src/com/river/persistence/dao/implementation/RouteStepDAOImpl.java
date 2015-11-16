package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.river.entity.RouteStep;
import com.river.persistence.dao.interfaces.RouteStepDAO;

@Service
public class RouteStepDAOImpl extends AbstractDAO  implements RouteStepDAO{

	public RouteStep create(RouteStep toCreate) {

		if (toCreate.getOrigin() != null && toCreate.getDestiny() != null) {
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

	public RouteStep read(RouteStep toRead) {
		RouteStep readed = null;
		Session session = sessionFactory.getCurrentSession();
		
		readed = (RouteStep) session.get(RouteStep.class, toRead.getId());//(RouteStep) query.list().get(0);
		
		
		return readed;
		
	}

	@SuppressWarnings("unchecked")
	public List<RouteStep> read() {
		List<RouteStep> routeSteps = new ArrayList<RouteStep>();
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from RouteStep");
		routeSteps = (List<RouteStep>) query.list();
		
		return routeSteps;
	}

	public RouteStep update(RouteStep toUpdate) {
		
		if(toUpdate.getId() != null){
			
			
			Session session = sessionFactory.getCurrentSession();
			
			try{
				session.update(toUpdate);
				
			}catch(HibernateException e){
				e.printStackTrace();
				toUpdate = null;
				
			}
			}else{
				toUpdate = null;
			}
			
			
		
		return toUpdate;
	}

	public RouteStep delete(RouteStep toDelete) {
		if (toDelete.getId() != null) {
			Session session = sessionFactory.getCurrentSession();
		
			try{
				session.delete(toDelete);
				
			}catch(HibernateException e){
				e.printStackTrace();
				toDelete = null;
				
			}
		}else{
			toDelete = null;
		}
		return toDelete;
	}



}
