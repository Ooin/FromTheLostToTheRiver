package com.river.business.service.implementation;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.river.business.service.interfaces.AddressService;
import com.river.business.service.interfaces.RafterService;
import com.river.business.service.interfaces.RouteFatherService;
import com.river.business.service.interfaces.RouteStepService;
import com.river.entity.Address;
import com.river.entity.Rafter;
import com.river.entity.RouteFather;
import com.river.entity.RouteStep;



@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:config/spring-config.xml" })
@Transactional  
@RunWith(SpringJUnit4ClassRunner.class) 
public class RouteStepServiceImplTest {
	RouteStepService routeStepService;
	RouteFatherService routeFatherService;
	AddressService addressService;
	RafterService rafterService;
	RouteStep routeStep;
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/spring-config.xml");
	Address origin;
	Address destiny;
	RouteFather routeFather;
	Rafter rafter;
	
	 @Before
	 public void initTest(){
		this.routeStepService = (RouteStepService) context.getBean("routeStepServiceImpl");
		this.routeFatherService = (RouteFatherService) context.getBean("routeFatherServiceImpl");
		this.rafterService = (RafterService) context.getBean("rafterServiceImpl");
		this.addressService = (AddressService) context.getBean("addressServiceImpl");
		
		this.rafter = rafterService.create(new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99"));
		this.origin = addressService.create( new Address(11111,"street", "alcalde barnils"));
		this.destiny = addressService.create( new Address(11111,"street2", "alcalde barnils2"));
		this.routeFather = routeFatherService.create(new RouteFather("rutatest2", "desctes2t", "asdfas2","2012-02-02", this.rafter));
		this.routeStep = routeStepService.create(new RouteStep(this.routeFather, this.origin, this.destiny));
	 }
	 
	 @After
	 public void deleteRows(){
		this.routeStepService.delete(this.routeStep);
		this.routeFatherService.delete(this.routeFather);
		this.addressService.delete(this.destiny);
		this.addressService.delete(this.origin);
		this.rafterService.delete(this.rafter);
	 }
	 
	 
	 
	 //#####CREATE TESTS########
	 
	 //add a new routeStep
	 @Test
	 public void addANonExistingRouteStep(){
		
		Rafter rafter = rafterService.create(new Rafter("testRafter1","12342", "tes4tRafter@gmail.com", "9999-99-99"));
		Address origin = addressService.create( new Address(11111,"street1", "alcalde barnils12"));
		Address destiny = addressService.create( new Address(11111,"street22", "alcalde barnils23"));
		RouteFather routeFather = routeFatherService.create(new RouteFather("rutatest3", "desctes3", "asdfas3","2012-02-02", rafter));
		 
		RouteStep test = new RouteStep(routeFather, origin, destiny);
		test = routeStepService.create(test);
		Assert.assertNotNull("it should returns not null", test);
		
		routeStepService.delete(test);
		routeFatherService.delete(routeFather);
		addressService.delete(destiny);
		addressService.delete(origin);
		rafterService.delete(rafter);
		 
	 }
	 
	 //add a new EXISTING routeStep
	@Test
	 public void addAnExistingRouteStep(){
		RouteStep toAdd = this.routeStep;
		toAdd = routeStepService.create(toAdd);
		Assert.assertNull(toAdd);
		
	 }
	 
	 //add an empty routeStep
	@Test
	 public void addAnEmptyRouteStep(){
		 RouteStep test = routeStepService.create(new RouteStep());
		 Assert.assertNull("it should returns null", test);
	 }
	 
	 //add a null routeStep
	@Test
	 public void addANullRouteStep(){
		 RouteStep test = routeStepService.create(new RouteStep(null, null, null, null));
		 Assert.assertNull("it should returns null", test);
	 }
	 
	//#####READ TESTS########
	 
		 //read a non existing routeStep
		@Test
		public void readANonExistingRouteStep(){
			RouteStep toRead = new RouteStep(1234123);
			toRead = routeStepService.read(toRead);
			Assert.assertNull("it should returns null", toRead);
		}
		 
		 //read an existing routeStep
		@Test
		public void readAnExistingRouteStep(){
			this.routeStep = routeStepService.read(routeStep);
			Assert.assertNotNull("it should returns not null", this.routeStep);
		}
		
		 //read a non existing routeStep list
		@Test
		public void readANonExistingRouteStepList(){
			routeStepService.delete(this.routeStep);
			List<RouteStep> routeSteps = routeStepService.read();
			Assert.assertTrue("it should returns empty list", routeSteps.isEmpty());
		}
		 
		 //read an existing routeStep list
		@Test
		public void readAnExistingRouteStepList(){
			List<RouteStep> routeSteps = routeStepService.read();
			Assert.assertTrue("it should returns full list", !routeSteps.isEmpty());
		}
		
		
		
		
		//#####UPDATE TESTS########
	 
	//#####UPDATE TESTS########
	 //update an existing routeStep
	 @Test
	 public void updateAnExistingRouteStep(){
		this.origin.setRoadType("callejuela");
		this.routeStep.setOrigin(this.origin);
		this.routeStepService.update(this.routeStep);
		Assert.assertNotNull("it should returns not null", this.routeStep);
		Assert.assertEquals("origin should be capullo", this.routeStep.getOrigin().getRoadType(), "callejuela");
		routeStepService.delete(routeStep);
		 
	 }
	 
	 //update an empty routeStep
	 @Test
	 public void updateAnEmptyRouteStep(){
		RouteStep routeStep = new RouteStep();
		routeStep = routeStepService.update(routeStep);
		Assert.assertNull(routeStep);
		 
	 }
	 
	 
	 //update a non existing routeStep
	 @Test
	 public void updateANonExistingRouteStep(){
		 RouteStep routeStep = new RouteStep(888988);
		 routeStep = routeStepService.update(routeStep);
		 Assert.assertNull("it should returns null", routeStep);
	 }
	//#####DELETE TESTS########
	 
		 //delete an existing routeStep
	@Test
	public void deleteAnExistingRouteStep(){
		RouteStep deleted = routeStepService.delete(this.routeStep);
		Assert.assertNotNull("it should returns a not null object", deleted);
	}
		 //delete a non existing routeStep
	@Test
	public void deleteANonExistingRouteStep(){
		RouteStep toDelete = new RouteStep(123123);
		RouteStep deleted = routeStepService.delete(toDelete);
		Assert.assertNull("it should returns a null object", deleted);
	}
	 	
	//TODO delete a routeStep with dependencies
 

}
