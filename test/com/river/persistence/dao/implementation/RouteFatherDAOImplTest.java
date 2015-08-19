package com.river.persistence.dao.implementation;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Rafter;
import com.river.entity.RouteFather;
import com.river.persistence.dao.interfaces.RafterDAO;
import com.river.persistence.dao.interfaces.RouteFatherDAO;

public class RouteFatherDAOImplTest {
	RouteFatherDAO routeFatherDAO;
	RafterDAO rafterDAO;
	RouteFather routeFather;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	Rafter rafter;
	
	 @Before
	 public void initTest(){
		routeFatherDAO = (RouteFatherDAO) context.getBean(RouteFatherDAOImpl.class);
		rafterDAO = (RafterDAO) context.getBean(RafterDAOImpl.class);
		this.rafter = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		this.rafter = rafterDAO.create(rafter);
		this.routeFather = new RouteFather("rutatest2", "desctes2t", "asdfas2","2012-02-02", this.rafter);
		routeFatherDAO.create(routeFather);

	 }
	 
	 @After
	 public void deleteRows(){
		 routeFatherDAO.delete(this.routeFather);
		 rafterDAO.delete(this.rafter);
	 }
	 
	 
	 
	 //#####CREATE TESTS########
	 
	 //add a new routeFather
	 @Test
	 public void addANonExistingRouteFather(){
		 RouteFather test = routeFatherDAO.create(new RouteFather("rutatest", "desctest", "asdfas","2012-02-02", this.rafter));
		 Assert.assertNotNull("it should returns not null", test);
		 routeFatherDAO.delete(test);
		 
	 }
	 
	 @Test
	 public void addANonExistingRouteFatherWithNullRafter(){
		 RouteFather test = routeFatherDAO.create(new RouteFather("rutatest", "desctest", "asdfas","2012-02-02", new Rafter()));
		 Assert.assertNull("it should returns not null", test);
		 
		 
	 }
	 
	 //add a new EXISTING routeFather
	@Test
	 public void addAnExistingRouteFather(){
		RouteFather toAdd = new RouteFather();
		toAdd = routeFatherDAO.create(toAdd);
		Assert.assertNull(toAdd);
		
	 }
	 
	 //add an empty routeFather
	@Test
	 public void addAnEmptyRouteFather(){
		 RouteFather test = routeFatherDAO.create(new RouteFather());
		 Assert.assertNull("it should returns null", test);
	 }
	 
	 //add a null routeFather
	@Test
	 public void addANullRouteFather(){
		 RouteFather test = routeFatherDAO.create(new RouteFather(null, null, null, null, null));
		 Assert.assertNull("it should returns null", test);
	 }
	 
	//#####READ TESTS########
	 
		 //read a non existing routeFather
		@Test
		public void readANonExistingRouteFather(){
			RouteFather toRead = new RouteFather(1234123);
			toRead = routeFatherDAO.read(toRead);
			Assert.assertNull("it should returns null", toRead);
		}
		 
		 //read an existing routeFather
		@Test
		public void readAnExistingRouteFather(){
			this.routeFather = routeFatherDAO.read(routeFather);
			Assert.assertNotNull("it should returns not null", this.routeFather);
		}
		
		 //read a non existing routeFather list
		@Test
		public void readANonExistingRouteFatherList(){
			routeFatherDAO.delete(this.routeFather);
			List<RouteFather> routeFathers = routeFatherDAO.read();
			Assert.assertTrue("it should returns empty list", routeFathers.isEmpty());
		}
		 
		 //read an existing routeFather list
		@Test
		public void readAnExistingRouteFatherList(){
			List<RouteFather> routeFathers = routeFatherDAO.read();
			Assert.assertTrue("it should returns full list", !routeFathers.isEmpty());
		}
		
		
		
		
		//#####UPDATE TESTS########
	 
	//#####UPDATE TESTS########
	 //update an existing routeFather
	 @Test
	 public void updateAnExistingRouteFather(){
		 this.routeFather.setDescription("yolo");
		 routeFatherDAO.update(this.routeFather);
		 Assert.assertNotNull("it should returns not null", this.routeFather);
		 Assert.assertEquals("email should be yolo", this.routeFather.getDescription(), "yolo");
		 routeFatherDAO.delete(routeFather);
		 
	 }
	 
	 //update an empty routeFather
	 @Test
	 public void updateAnEmptyRouteFather(){
		RouteFather routeFather = new RouteFather();
		routeFather = routeFatherDAO.update(routeFather);
		Assert.assertNull(routeFather);
		 
	 }
	 
	 
	 //update a non existing routeFather
	 @Test
	 public void updateANonExistingRouteFather(){
		 RouteFather routeFather = new RouteFather(888988);
		 routeFather = routeFatherDAO.update(routeFather);
		 Assert.assertNull("it should returns null", routeFather);
	 }
	//#####DELETE TESTS########
	 
		 //delete an existing routeFather
	@Test
	public void deleteAnExistingRouteFather(){
		RouteFather deleted = routeFatherDAO.delete(this.routeFather);
		Assert.assertNotNull("it should returns a not null object", deleted);
	}
		 //delete a non existing routeFather
	@Test
	public void deleteANonExistingRouteFather(){
		RouteFather toDelete = new RouteFather(123123);
		RouteFather deleted = routeFatherDAO.delete(toDelete);
		Assert.assertNull("it should returns a null object", deleted);
	}
	 	
	//TODO delete a routeFather with dependencies
}
