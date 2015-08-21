package com.river.business.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.business.service.interfaces.RateService;
import com.river.entity.Rafter;
import com.river.entity.Rate;
import com.river.entity.RouteFather;

public class RateServiceImplTest {

	RateService rateService;
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
		rateService = context.getBean(RateServiceImpl.class);
	}

	// ############## CREATE ##############
	@Test
	public void createRateIfCorrectTest() {
		Rate test = rateService.create(rate);
		if (test != null) {
			rateService.delete(test);
		}
		Assert.assertNotNull("It should returns not null", test);

	}

	@Test
	public void createRateNullValues() {
		Rate test = rateService.create(rateNull);
		if (test != null) {
			rateService.delete(test);
		}
		Assert.assertNull("It should returns null", test);

	}

	// ############## READ ##############
	@Test
	public void readRateIfExistNotNullTest() {
		rateService.create(rate);
		Rate test = rateService.read(rate);
		if (test != null) {
			rateService.delete(test);
		}
		Assert.assertNotNull("The Transport exist on the data base.", test);
	}

	@Test
	public void readRateIfNoExistTest() {
		Rate test = rateService.read(rate);
		Assert.assertNull("it should returns null", test);
	}

	// ############## LIST ##############
	@Test
	public void rateListIsEmptyTest() {
		List<Rate> transList = new ArrayList<Rate>();
		transList = rateService.read();
		Assert.assertTrue("It should returns empty list", transList.isEmpty());
	}

	@Test
	public void rateListIsFullTest() {
		Rate test = rateService.create(rate);
		List<Rate> transList = new ArrayList<Rate>();
		transList = rateService.read();
		if (test.getId() != null) {
			rateService.delete(test);
		}
		Assert.assertFalse("It should returns empty list", transList.isEmpty());
	}

	// ############## UPDATE ##############
	@Test
	public void updateAnExistingRateTest() {
		rateService.create(rate);
		rate.setComment("Merengue");
		Rate test = rateService.update(rate);
		if (test.getId() != null) {
			rateService.delete(test);
		}
		Assert.assertNotNull("It should returns not null.", test);
	}

	@Test
	public void updateAnNotExistingRateTest() {
		Rate test = rateService.update(rate);
		Assert.assertNull("It should returns null.", test);
	}

	// ############## DELETE ##############
	@Test
	public void deleteAnExistingRateTest() {
		rateService.create(rate);
		Rate test = rateService.delete(rate);
		Assert.assertNotNull("It should returns not null.", test);
	}

	@Test
	public void deleteAnNotExistingRateTest() {
		Rate test = rateService.delete(rate);
		Assert.assertNull("It should returns null.", test);
	}
}
