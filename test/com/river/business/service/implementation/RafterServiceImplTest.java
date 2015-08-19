package com.river.business.service.implementation;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.business.service.interfaces.RafterService;
import com.river.entity.Rafter;
import com.river.persistence.dao.implementation.RafterDAOImpl;
import com.river.persistence.dao.interfaces.RafterDAO;


public class RafterServiceImplTest {
	RafterService rafterService;
	Rafter rafter;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	
	 @Before
	 public void initTest(){
		 rafterService = (RafterService) context.getBean(RafterServiceImpl.class);
		this.rafter = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		rafterService.create(rafter);
	 }
	 
	 @After
	 public void deleteRows(){
		 rafterService.delete(this.rafter);
	 }
	 
	 
	 
	 //#####CREATE TESTS########
	 
	 //add a new rafter
	 @Test
	 public void addANonExistingRafter(){
		 Rafter test = rafterService.create(new Rafter("capullo","12354", "testRaft3er@gmail.com", "9999-99-99"));
		 Assert.assertNotNull("it should returns not null", test);
		 rafterService.delete(test);
		 
	 }
	 
	 //add a new EXISTING rafter
	@Test
	 public void addAnExistingRafter(){
		Rafter toAdd = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		toAdd = rafterService.create(toAdd);
		Assert.assertNull(toAdd);
		
	 }
	 
	 //add an empty rafter
	@Test
	 public void addAnEmptyRafter(){
		 Rafter test = rafterService.create(new Rafter());
		 Assert.assertNull("it should returns null", test);
	 }
	 
	 //add a null rafter
	@Test
	 public void addANullRafter(){
		 Rafter test = rafterService.create(new Rafter(null, null, null, null));
		 Assert.assertNull("it should returns null", test);
	 }
	 
	//#####READ TESTS########
	 
		 //read a non existing rafter
		@Test
		public void readANonExistingRafter(){
			Rafter toRead = new Rafter(1234123);
			toRead = rafterService.read(toRead);
			Assert.assertNull("it should returns null", toRead);
		}
		 
		 //read an existing rafter
		@Test
		public void readAnExistingRafter(){
			this.rafter = rafterService.read(rafter);
			Assert.assertNotNull("it should returns not null", this.rafter);
		}
		
		 //read a non existing rafter list
		@Test
		public void readANonExistingRafterList(){
			rafterService.delete(this.rafter);
			List<Rafter> rafters = rafterService.read();
			Assert.assertTrue("it should returns empty list", rafters.isEmpty());
		}
		 
		 //read an existing rafter list
		@Test
		public void readAnExistingRafterList(){
			List<Rafter> rafters = rafterService.read();
			Assert.assertTrue("it should returns full list", !rafters.isEmpty());
		}
		
		//#####UPDATE TESTS########
	 
	//#####UPDATE TESTS########
	 //update an existing rafter
	 @Test
	 public void updateAnExistingRafter(){
		 this.rafter.setEmail("capullo");
		 rafterService.update(this.rafter);
		 Assert.assertNotNull("it should returns not null", this.rafter);
		 Assert.assertEquals("email should be capullo", this.rafter.getEmail(), "capullo");
		 rafterService.delete(rafter);
		 
	 }
	 
	 //update an empty rafter
	 @Test
	 public void updateAnEmptyRafter(){
		Rafter rafter = new Rafter();
		rafter = rafterService.update(rafter);
		Assert.assertNull(rafter);
		 
	 }
	 
	 
	 //update a non existing rafter
	 @Test
	 public void updateANonExistingRafter(){
		 Rafter rafter = new Rafter(888988);
		 rafter = rafterService.update(rafter);
		 Assert.assertNull("it should returns null", rafter);
	 }
	//#####DELETE TESTS########
	 
		 //delete an existing rafter
	@Test
	public void deleteAnExistingRafter(){
		Rafter deleted = rafterService.delete(this.rafter);
		Assert.assertNotNull("it should returns a not null object", deleted);
	}
		 //delete a non existing rafter
	@Test
	public void deleteANonExistingRafter(){
		Rafter toDelete = new Rafter(123123);
		Rafter deleted = rafterService.delete(toDelete);
		Assert.assertNull("it should returns a null object", deleted);
	}
	 	
	//TODO delete a rafter with dependencies
 
}
