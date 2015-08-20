package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.river.entity.Line;
import com.river.persistence.dao.interfaces.LineDAO;

@Service
public class LineDAOImpl extends AbstractDAO implements LineDAO{
	

	@Override
	public Line create(Line toCreate) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			session.persist(toCreate);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			toCreate = null;
			tx.rollback();
		}
		return toCreate;
	}

	@Override
	public Line read(Line toRead) {
		Line readed = null;
		if(toRead != null && toRead.getId() != null) {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			readed = (Line) session.get(Line.class, toRead.getId());
			transaction.commit();
		}
		
		return readed;
	}

	@Override
	public List<Line> read() {
		List<Line> lines = new ArrayList<Line>();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Line");
		lines = (List<Line>) query.list();
		transaction.commit();
		return lines;
	}

	@Override
	public Line update(Line toUpdate) {
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
		return toUpdate;
	}

	@Override
	public Line delete(Line toDelete) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try{
			session.delete(toDelete);
			tx.commit();
		}catch(HibernateException e){
			//e.printStackTrace();
			System.out.println("**********************************************");
			System.out.println("//////////////////////////////////////////////");
			toDelete = null;
			tx.rollback();
		}
		return toDelete;
	}

}
