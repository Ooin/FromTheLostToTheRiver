package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Transport;
import com.river.persistence.dao.interfaces.TransportDAO;

public class TransportDAOImplTest {

	List<Transport> transports;
	ApplicationContext context;
	TransportDAO transportDAO;
	Transport transportDB;

	@Before
	public void initTest() {
		context = new ClassPathXmlApplicationContext("config/spring-config.xml");
		transportDAO = context.getBean(TransportDAOImpl.class);
		transports = new ArrayList<>();
		transportDB = transportDAO.create(new Transport("Linea 5 metro"));
	}

	@Test
	public void createTransportIfCorrectTest() {
		transportDB = transportDAO.create(new Transport("Linea 2 metro"));

		Assert.assertNotNull("The returned value must be not null when creating an object", transportDB);
		Assert.assertNotNull("The returned value must have a valid id when creating an object", transportDB.getId());
	}

	@Test
	public void createTransportIfexistTest() {
		transportDB = new Transport("Linea 2 metro");
		transportDAO.create(transportDB);
		Transport toAdd = new Transport("Linea 2 metro");

		toAdd = transportDAO.create(toAdd);
		Assert.assertNull("The returned value must be null when no creating an object", toAdd);
	}

	@Test
	public void readTransportIfExistNotNullTest() {
		Transport toAdd = transportDAO.read(transportDB);
		Assert.assertNotNull("The Transport exist on the data base.", toAdd);
	}

	@Test
	public void readTransportNonBeNullTest() {
		// During
		Transport toAdd = transportDAO.read(new Transport(1, "pepe"));
		
		// After
		Assert.assertNull("The Transport don't exist on the data base.", toAdd);
	}

	/**
	@Test
	public void transportListIsEmptyTest() {
		// During
		this.transports = transportDAO.read();

		// After
		Assert.assertFalse("Groups must have some groups - Must be false", transports.isEmpty());
	}*/

	@After
	public void afterTest() {
		transportDAO.delete(transportDB);
	}

}
