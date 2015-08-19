package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Transport;
import com.river.persistence.dao.interfaces.TransportDAO;

public class TransportDAOImplTest {

	TransportDAO transportDAO;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");

	Transport transport;
	Transport transportNull;

	@Before
	public void initTest() {
		transport = new Transport("Linea 2 metro");
		transportNull = new Transport(null, null);
		transportDAO = context.getBean(TransportDAOImpl.class);
	}

	// ############## CREATE ##############
	@Test
	public void createTransportIfCorrectTest() {
		Transport test = transportDAO.create(transport);
		if (test != null) {
			transportDAO.delete(test);
		}
		Assert.assertNotNull("It should returns not null", test);

	}

	@Test
	public void createTransportNullValues() {
		Transport test = transportDAO.create(transportNull);
		if (test != null) {
			transportDAO.delete(test);
		}
		Assert.assertNull("It should returns null", test);

	}

	// ############## READ ##############
	@Test
	public void readTransportIfExistNotNullTest() {
		transportDAO.create(transport);
		Transport test = transportDAO.read(transport);
		if (test != null) {
			transportDAO.delete(test);
		}
		Assert.assertNotNull("The Transport exist on the data base.", test);

	}

	@Test
	public void readTransportIfNoExistTest() {
		Transport test = transportDAO.read(transport);
		Assert.assertNull("it should returns null", test);
	}

	// ############## LIST ##############
	@Test
	public void transportListIsEmptyTest() {
		List<Transport> transList = new ArrayList<Transport>();
		transList = transportDAO.read();
		Assert.assertTrue("It should returns empty list", transList.isEmpty());
	}

	@Test
	public void transportListIsFullTest() {
		Transport test = transportDAO.create(transport);
		List<Transport> transList = new ArrayList<Transport>();
		transList = transportDAO.read();
		if (test != null) {
			transportDAO.delete(test);
		}
		Assert.assertFalse("It should returns empty list", transList.isEmpty());
	}

	// ############## UPDATE ##############
	@Test
	public void updateAnExistingTransportTest() {
		transportDAO.create(transport);
		transport.setName("Merengue");
		Transport test = transportDAO.update(transport);
		if (test.getId() != null) {
			transportDAO.delete(test);
		}
		Assert.assertNotNull("It should returns not null.", test);
	}

	@Test
	public void updateAnNotExistingTransportTest() {
		Transport test = transportDAO.update(transport);

		Assert.assertNull("It should returns null.", test);
	}

	// ############## DELETE ##############
	@Test
	public void deleteAnExistingTransportTest() {
		transportDAO.create(transport);
		Transport test = transportDAO.delete(transport);
		Assert.assertNotNull("It should returns not null.", test);
	}

	@Test
	public void deleteAnNotExistingTransportTest() {
		Transport test = transportDAO.delete(transport);
		Assert.assertNull("It should returns null.", test);
	}

}
