package com.river.persistence.dao.implementation;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Rafter;
import com.river.persistence.dao.interfaces.RafterDAO;

public class RafterDAOImplTest {
	
	RafterDAO rafterDAO;
	Rafter rafter;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	
	 @Before
	 public void initTest(){
		rafterDAO = (RafterDAO) context.getBean(RafterDAOImpl.class);
		this.rafter = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		rafterDAO.create(rafter);
	 }
	 
	 @After
	 public void deleteRows(){
		 rafterDAO.delete(this.rafter);
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
		Rafter toAdd = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		toAdd = rafterDAO.create(toAdd);
		Assert.assertNull(toAdd);
		
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
			Rafter toRead = new Rafter(1234123);
			toRead = rafterDAO.read(toRead);
			Assert.assertNull("it should returns null", toRead);
		}
		 
		 //read an existing rafter
		@Test
		public void readAnExistingRafter(){
			this.rafter = rafterDAO.read(rafter);
			int id = this.rafter.getId();
			Rafter rafter = new Rafter(id);
			Assert.assertNotNull("it should returns not null", rafter);
		}
		
		
		 //read a non existing rafter list
		@Test
		public void readANonExistingRafterList(){
			rafterDAO.delete(this.rafter);
			List<Rafter> rafters = rafterDAO.read();
			Assert.assertTrue("it should returns empty list", rafters.isEmpty());
		}
		 
		 //read an existing rafter list
		@Test
		public void readAnExistingRafterList(){
			List<Rafter> rafters = rafterDAO.read();
			Assert.assertTrue("it should returns full list", !rafters.isEmpty());
		}
		
		
		
		
		//#####UPDATE TESTS########
	 
	//#####UPDATE TESTS########
	 //update an existing rafter
	 @Test
	 public void updateAnExistingRafter(){
		 this.rafter.setEmail("capullo");
		 rafterDAO.update(this.rafter);
		 Assert.assertNotNull("it should returns not null", this.rafter);
		 Assert.assertEquals("email should be capullo", this.rafter.getEmail(), "capullo");
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
		Rafter deleted = rafterDAO.delete(this.rafter);
		Assert.assertNotNull("it should returns a not null object", deleted);
	}
		 //delete a non existing rafter
	@Test
	public void deleteANonExistingRafter(){
		Rafter toDelete = new Rafter(123123);
		Rafter deleted = rafterDAO.delete(toDelete);
		Assert.assertNull("it should returns a null object", deleted);
	}
	 	
	//TODO delete a rafter with dependencies
 
}
