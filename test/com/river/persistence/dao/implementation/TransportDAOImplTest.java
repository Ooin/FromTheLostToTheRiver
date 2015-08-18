package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Transport;
import com.river.persistence.dao.implementation.TransportDAOImpl;
import com.river.persistence.dao.interfaces.TransportDAO;

public class TransportDAOImplTest {

	Transport transport;
	List<Transport> transports;
	ApplicationContext context;
	TransportDAO dao;

	@Before
	public void initTest() {
		transport = new Transport("Linea 2 metro");
		context = new ClassPathXmlApplicationContext("config/spring-config.xml");
		dao = context.getBean(TransportDAOImpl.class);
		transports = new ArrayList<>();
	}

	@Test
	public void createTransportIfCorrect() {
		transport = dao.create(transport);

		Assert.assertNotNull("The returned value must be not null when creating an object", transport);
		Assert.assertNotNull("The returned value must have a valid id when creating an object", transport.getId());
	}

	@Test
	public void createTransportIfexist() {
		Transport creteTransport = dao.read(transport);

		Assert.assertNull("The returned value must be not null when creating an object", creteTransport);
		Assert.assertNull("The returned value must have a valid id when creating an object", creteTransport.getId());
	}

	@Test
	public void readTransportBeNull() {

	}

}
