package com.river.business.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.business.service.interfaces.TransportService;
import com.river.entity.Transport;

public class TransportServiceImplTest {

	TransportService transportService;
	Transport transport;
	Transport transportNull;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");

	@Before
	public void initTest() {
		this.transport = new Transport("Linea 2 metro");
		this.transportNull = new Transport(null, null);
		transportService = (TransportService) context.getBean(TransportServiceImpl.class);
	}

	// ############## CREATE ##############
	@Test
	public void createTransportIfCorrectTest() {
		Transport test = transportService.create(transport);
		if (test != null) {
			transportService.delete(test);
		}
		Assert.assertNotNull("It should returns not null", test);

	}

	@Test
	public void createTransportNullValues() {
		Transport test = transportService.create(transportNull);
		if (test != null) {
			transportService.delete(test);
		}
		Assert.assertNull("It should returns null", test);

	}

	// ############## READ ##############
	@Test
	public void readTransportIfExistNotNullTest() {
		transportService.create(transport);
		Transport test = transportService.read(transport);
		if (test != null) {
			transportService.delete(test);
		}
		Assert.assertNotNull("The Transport exist on the data base.", test);

	}

	@Test
	public void readTransportIfNoExistTest() {
		Transport test = transportService.read(transport);
		Assert.assertNull("it should returns null", test);
	}

	// ############## LIST ##############
	@Test
	public void transportListIsEmptyTest() {
		List<Transport> transList = new ArrayList<Transport>();
		transList = transportService.read();
		Assert.assertTrue("It should returns empty list", transList.isEmpty());
	}

	@Test
	public void transportListIsFullTest() {
		Transport test = transportService.create(transport);
		List<Transport> transList = new ArrayList<Transport>();
		transList = transportService.read();
		if (test != null) {
			transportService.delete(test);
		}
		Assert.assertFalse("It should returns empty list", transList.isEmpty());
	}

	// ############## UPDATE ##############
	@Test
	public void updateAnExistingTransportTest() {
		transportService.create(transport);
		transport.setName("Merengue");
		Transport test = transportService.update(transport);
		if (test.getId() != null) {
			transportService.delete(test);
		}
		Assert.assertNotNull("It should returns not null.", test);
	}

	@Test
	public void updateAnNotExistingTransportTest() {
		Transport test = transportService.update(transport);

		Assert.assertNull("It should returns null.", test);
	}

	// ############## DELETE ##############
	@Test
	public void deleteAnExistingTransportTest() {
		transportService.create(transport);
		Transport test = transportService.delete(transport);
		Assert.assertNotNull("It should returns not null.", test);
	}

	@Test
	public void deleteAnNotExistingTransportTest() {
		Transport test = transportService.delete(transport);
		Assert.assertNull("It should returns null.", test);
	}

}
