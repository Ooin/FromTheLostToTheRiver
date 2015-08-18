package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.river.entity.Rafter;
import com.river.persistence.dao.interfaces.DAO;
import com.river.persistence.dao.interfaces.RafterDAO;

public class RafterDAOImpl extends AbstractDAO implements RafterDAO{
	
	
	
	public Rafter create(Rafter toCreate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			session.persist(toCreate);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			toCreate = null;
		}
		return toCreate;
	}

	public Rafter read(Rafter toRead) {
		Rafter readed = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		readed = (Rafter) session.get(Rafter.class, toRead.getId());//(Rafter) query.list().get(0);
		transaction.commit();
		
		return readed;
		
	}

	public List<Rafter> read() {
		List<Rafter> rafters = new ArrayList<Rafter>();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Rafter");
		rafters = (List<Rafter>) query.list();
		transaction.commit();
		return rafters;
	}

	public Rafter update(Rafter toUpdate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try{
			session.update(toUpdate);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			toUpdate = null;
		}
		return toUpdate;
	}

	public Rafter delete(Rafter toDelete) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try{
			session.delete(toDelete);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			toDelete = null;
		}
		return toDelete;
	}


	
	
	
}
