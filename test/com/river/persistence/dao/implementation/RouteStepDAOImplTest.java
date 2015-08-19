package com.river.persistence.dao.implementation;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Address;
import com.river.entity.Rafter;
import com.river.entity.RouteFather;
import com.river.entity.RouteStep;
import com.river.persistence.dao.interfaces.AddressDAO;
import com.river.persistence.dao.interfaces.RafterDAO;
import com.river.persistence.dao.interfaces.RouteFatherDAO;
import com.river.persistence.dao.interfaces.RouteStepDAO;

public class RouteStepDAOImplTest {
	
	RouteStepDAO routeStepDAO;
	RouteFatherDAO routeFatherDAO;
	AddressDAO addressDAO;
	RafterDAO rafterDAO;
	RouteStep routeStep;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	Address origin;
	Address destiny;
	RouteFather routeFather;
	Rafter rafter;
	
	 @Before
	 public void initTest(){
		this.routeStepDAO = (RouteStepDAO) context.getBean(RouteStepDAOImpl.class);
		this.routeFatherDAO = (RouteFatherDAO) context.getBean(RouteFatherDAOImpl.class);
		this.rafterDAO = (RafterDAO) context.getBean(RafterDAOImpl.class);
		this.addressDAO = (AddressDAO) context.getBean(AddressDAOImpl.class);
		
		this.rafter = rafterDAO.create(new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99"));
		this.origin = addressDAO.create( new Address(11111,"street", "alcalde barnils"));
		this.destiny = addressDAO.create( new Address(11111,"street2", "alcalde barnils2"));
		this.routeFather = routeFatherDAO.create(new RouteFather("rutatest2", "desctes2t", "asdfas2","2012-02-02", this.rafter));
		this.routeStep = routeStepDAO.create(new RouteStep(this.routeFather, this.origin, this.destiny));
	 }
	 
	 @After
	 public void deleteRows(){
		this.routeStepDAO.delete(this.routeStep);
		this.routeFatherDAO.delete(this.routeFather);
		this.addressDAO.delete(this.destiny);
		this.addressDAO.delete(this.origin);
		this.rafterDAO.delete(this.rafter);
	 }
	 
	 
	 
	 //#####CREATE TESTS########
	 
	 //add a new routeStep
	 @Test
	 public void addANonExistingRouteStep(){
		
		Rafter rafter = rafterDAO.create(new Rafter("testRafter1","12342", "tes4tRafter@gmail.com", "9999-99-99"));
		Address origin = addressDAO.create( new Address(11111,"street1", "alcalde barnils12"));
		Address destiny = addressDAO.create( new Address(11111,"street22", "alcalde barnils23"));
		RouteFather routeFather = routeFatherDAO.create(new RouteFather("rutatest3", "desctes3", "asdfas3","2012-02-02", rafter));
		 
		RouteStep test = new RouteStep(routeFather, origin, destiny);
		test = routeStepDAO.create(test);
		Assert.assertNotNull("it should returns not null", test);
		
		routeStepDAO.delete(test);
		routeFatherDAO.delete(routeFather);
		addressDAO.delete(destiny);
		addressDAO.delete(origin);
		rafterDAO.delete(rafter);
		 
	 }
	 
	 //add a new EXISTING routeStep
	@Test
	 public void addAnExistingRouteStep(){
		RouteStep toAdd = this.routeStep;
		toAdd = routeStepDAO.create(toAdd);
		Assert.assertNull(toAdd);
		
	 }
	 
	 //add an empty routeStep
	@Test
	 public void addAnEmptyRouteStep(){
		 RouteStep test = routeStepDAO.create(new RouteStep());
		 Assert.assertNull("it should returns null", test);
	 }
	 
	 //add a null routeStep
	@Test
	 public void addANullRouteStep(){
		 RouteStep test = routeStepDAO.create(new RouteStep(null, null, null, null));
		 Assert.assertNull("it should returns null", test);
	 }
	 
	//#####READ TESTS########
	 
		 //read a non existing routeStep
		@Test
		public void readANonExistingRouteStep(){
			RouteStep toRead = new RouteStep(1234123);
			toRead = routeStepDAO.read(toRead);
			Assert.assertNull("it should returns null", toRead);
		}
		 
		 //read an existing routeStep
		@Test
		public void readAnExistingRouteStep(){
			this.routeStep = routeStepDAO.read(routeStep);
			Assert.assertNotNull("it should returns not null", this.routeStep);
		}
		
		 //read a non existing routeStep list
		@Test
		public void readANonExistingRouteStepList(){
			routeStepDAO.delete(this.routeStep);
			List<RouteStep> routeSteps = routeStepDAO.read();
			Assert.assertTrue("it should returns empty list", routeSteps.isEmpty());
		}
		 
		 //read an existing routeStep list
		@Test
		public void readAnExistingRouteStepList(){
			List<RouteStep> routeSteps = routeStepDAO.read();
			Assert.assertTrue("it should returns full list", !routeSteps.isEmpty());
		}
		
		
		
		
		//#####UPDATE TESTS########
	 
	//#####UPDATE TESTS########
	 //update an existing routeStep
	 @Test
	 public void updateAnExistingRouteStep(){
		this.origin.setRoadType("callejuela");
		this.routeStep.setOrigin(this.origin);
		this.routeStepDAO.update(this.routeStep);
		Assert.assertNotNull("it should returns not null", this.routeStep);
		Assert.assertEquals("origin should be capullo", this.routeStep.getOrigin().getRoadType(), "callejuela");
		routeStepDAO.delete(routeStep);
		 
	 }
	 
	 //update an empty routeStep
	 @Test
	 public void updateAnEmptyRouteStep(){
		RouteStep routeStep = new RouteStep();
		routeStep = routeStepDAO.update(routeStep);
		Assert.assertNull(routeStep);
		 
	 }
	 
	 
	 //update a non existing routeStep
	 @Test
	 public void updateANonExistingRouteStep(){
		 RouteStep routeStep = new RouteStep(888988);
		 routeStep = routeStepDAO.update(routeStep);
		 Assert.assertNull("it should returns null", routeStep);
	 }
	//#####DELETE TESTS########
	 
		 //delete an existing routeStep
	@Test
	public void deleteAnExistingRouteStep(){
		RouteStep deleted = routeStepDAO.delete(this.routeStep);
		Assert.assertNotNull("it should returns a not null object", deleted);
	}
		 //delete a non existing routeStep
	@Test
	public void deleteANonExistingRouteStep(){
		RouteStep toDelete = new RouteStep(123123);
		RouteStep deleted = routeStepDAO.delete(toDelete);
		Assert.assertNull("it should returns a null object", deleted);
	}
	 	
	//TODO delete a routeStep with dependencies
 

}
