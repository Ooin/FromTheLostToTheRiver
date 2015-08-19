package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.river.entity.Address;
import com.river.persistence.dao.interfaces.AddressDAO;

public class AddressDAOImpl extends AbstractDAO implements AddressDAO  {

	public Address create(Address toCreate) {
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

	public Address read(Address toRead) {
		Address readed = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		readed = (Address) session.get(Address.class, toRead.getId());//(Rafter) query.list().get(0);
		transaction.commit();
		
		return readed;
		
	}

	@SuppressWarnings("unchecked")
	public List<Address> read() {
		List<Address> addresses = new ArrayList<Address>();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Address");
		addresses = (List<Address>) query.list();
		transaction.commit();
		return addresses;
	}

	public Address update(Address toUpdate) {
		
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

	public Address delete(Address toDelete) {
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
