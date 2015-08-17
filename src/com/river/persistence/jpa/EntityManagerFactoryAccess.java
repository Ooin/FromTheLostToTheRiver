package com.river.persistence.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryAccess {

	private volatile static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			synchronized(EntityManagerFactory.class) {
				if (factory == null) {
					factory = Persistence.createEntityManagerFactory("RiverCorePU");
				}
			}
		}
		return factory;
	}
	
}