package com.river.persistence.dao.implementation;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.river.entity.Line;
import com.river.persistence.dao.interfaces.LineDAO;

public class LineDAOImpl extends GenericDAO implements LineDAO{
	

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
		}
		return toCreate;
	}

	@Override
	public Line read(Line toRead) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Line> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Line update(Line toUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Line delete(Line toDelete) {
		// TODO Auto-generated method stub
		return null;
	}

}
