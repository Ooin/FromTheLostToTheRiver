package com.river.persistence.dao.implementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Rafter;
import com.river.persistence.dao.implementation.RafterDAOImpl;
import com.river.persistence.dao.interfaces.RafterDAO;

public class RafterDAOImplTest {
	
	RafterDAO rafterDAO;
	Rafter rafter;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	
	 @Before
	 public void initTest(){
		 rafterDAO = (RafterDAO) context.getBean(RafterDAOImpl.class);
		 //rafterDAO.create(rafter);
	 }
	 
	 
	 
	 //#####CREATE TESTS########
	 
	 //add a new rafter
	 @Test
	 public void addANonExistingRafter(){
		 Rafter test = rafterDAO.create(new Rafter("capullo","12354", "testRaft3er@gmail.com", "9999-99-99"));
		 Assert.assertNotNull("it should returns not null", test);
		 rafterDAO.delete(test);
		 
	 }
	 
	 //add a new EXISTING rafter
	@Test
	 public void addAnExistingRafter(){
		Rafter rafter = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		rafterDAO.create(rafter);
		Rafter toAdd = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		toAdd = rafterDAO.create(toAdd);
		Assert.assertNull(toAdd);
		rafterDAO.delete(rafter);
		
	 }
	 
	 //add an empty rafter
	@Test
	 public void addAnEmptyRafter(){
		 Rafter test = rafterDAO.create(new Rafter());
		 Assert.assertNull("it should returns null", test);
	 }
	 
	 //add a null rafter
	@Test
	 public void addANullRafter(){
		 Rafter test = rafterDAO.create(new Rafter(null, null, null, null));
		 Assert.assertNull("it should returns null", test);
	 }
	 
	//#####READ TESTS########
	 
		 //read a non existing rafter
		@Test
		public void readANonExistingRafter(){
			Rafter rafter = new Rafter(1234123);
			rafter = rafterDAO.read(rafter);
			Assert.assertNull("it should returns null", rafter);
		}
		 
		 //read an existing rafter
		@Test
		public void readAnExistingRafter(){
			Rafter rafter = new Rafter("testRafter5","12345", "testRafter5@gmail.com", "9999-99-99");
			rafterDAO.create(rafter);
			rafter = rafterDAO.read(rafter);
			Assert.assertNotNull("it should returns not null", rafter);
			rafterDAO.delete(rafter);
		}
		//#####UPDATE TESTS########
	 
	//#####UPDATE TESTS########
	 //update an existing rafter
	 @Test
	 public void updateAnExistingRafter(){
		 Rafter rafter = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		 rafterDAO.create(rafter);
		 rafter.setEmail("capullo");
		 rafterDAO.update(rafter);
		 Assert.assertNotNull("it should returns not null", rafter);
		 Assert.assertEquals("email should be capullo", rafter.getEmail(), "capullo");
		 rafterDAO.delete(rafter);
		 
	 }
	 
	 //update an empty rafter
	 @Test
	 public void updateAnEmptyRafter(){
		Rafter rafter = new Rafter();
		rafter = rafterDAO.update(rafter);
		Assert.assertNull(rafter);
		 
	 }
	 
	 
	 //update a non existing rafter
	 @Test
	 public void updateANonExistingRafter(){
		 Rafter rafter = new Rafter(888988);
		 rafter = rafterDAO.update(rafter);
		 Assert.assertNull("it should returns null", rafter);
	 }
	//#####DELETE TESTS########
	 
		 //delete an existing rafter
	@Test
	public void deleteAnExistingRafter(){
		Rafter rafter = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		rafterDAO.create(rafter);
		rafter = rafterDAO.delete(rafter);
		Assert.assertNotNull("it should returns a not null object", rafter);
	}
		 //delete a non existing rafter
	@Test
	public void deleteANonExistingRafter(){
		Rafter rafter = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		rafterDAO.create(rafter);
		rafter.setId(234234);
		rafter = rafterDAO.delete(rafter);
		Assert.assertNull("it should returns a null object", rafter);
	}
	 	
	//TODO delete a rafter with dependencies
 
}
