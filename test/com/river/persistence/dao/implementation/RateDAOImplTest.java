package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Rafter;
import com.river.entity.Rate;
import com.river.entity.RouteFather;
import com.river.entity.Transport;
import com.river.persistence.dao.interfaces.RateDAO;

public class RateDAOImplTest {

	RateDAO rateDAO;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");

	Rate rate;
	Rate rateNull;
	Rafter creator;
	RouteFather route;

	@Before
	public void initTest() {
		creator = new Rafter(1, "pepe", "pepe", "pepe@pepe.com", "2012-09-12");
		route = new RouteFather(1, "Buena ruta", "description", "hashTag", "timeStamp", creator);
		rate = new Rate(creator, route, "Me gusta");
		rateNull = new Rate(null, null, null);
		rateDAO = context.getBean(RateDAOImpl.class);
	}

	// ############## CREATE ##############
	@Test
	public void createRateIfCorrectTest() {
		Rate test = rateDAO.create(rate);
		if (test != null) {
			rateDAO.delete(test);
		}
		Assert.assertNotNull("It should returns not null", test);

	}

	@Test
	public void createRateNullValues() {
		Rate test = rateDAO.create(rateNull);
		if (test != null) {
			rateDAO.delete(test);
		}
		Assert.assertNull("It should returns null", test);

	}

	// ############## READ ##############
	@Test
	public void readTransportIfExistNotNullTest() {
		rateDAO.create(rate);
		Rate test = rateDAO.read(rate);
		if (test != null) {
			rateDAO.delete(test);
		}
		Assert.assertNotNull("The Transport exist on the data base.", test);
	}

	@Test
	public void readTransportIfNoExistTest() {
		Rate test = rateDAO.read(rate);
		Assert.assertNull("it should returns null", test);
	}

	// ############## LIST ##############
	@Test
	public void transportListIsEmptyTest() {
		List<Rate> transList = new ArrayList<Rate>();
		transList = rateDAO.read();
		Assert.assertTrue("It should returns empty list", transList.isEmpty());
	}

	/**
	@Test
	public void transportListIsFullTest() {
		Rate test = rateDAO.create(rate);
		List<Rate> transList = new ArrayList<Rate>();
		transList = rateDAO.read();
		if (test != null) {
			rateDAO.delete(test);
		}
		Assert.assertFalse("It should returns empty list", transList.isEmpty());
	}*/

}
