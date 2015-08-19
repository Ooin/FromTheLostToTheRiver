package com.river.persistence.dao.implementation;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Address;
import com.river.persistence.dao.interfaces.AddressDAO;

public class AddresDAOImplTest {
	AddressDAO addressDAO;
	Address address;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	
	 @Before
	 public void initTest(){
		addressDAO = (AddressDAO) context.getBean(AddressDAOImpl.class);
		this.address = new Address(11111,"street", "alcalde barnils");
		addressDAO.create(this.address);
	 }
	 
	 @After
	 public void deleteRows(){
		 addressDAO.delete(this.address);
	 }
	 
	 
	 
	 //#####CREATE TESTS########
	 
	 //add a new rafter
	 @Test
	 public void addANonExistingAddress(){
		 Address test = addressDAO.create(new Address(11111,"street", "alcalde barnils 2"));
		 Assert.assertNotNull("it should returns not null", test);
		 addressDAO.delete(test);
		 
	 }
	 
	 //add a new EXISTING rafter
	@Test
	 public void addAnExistingAddress(){
		Address toAdd = new Address(11111,"street", "alcalde barnils");
		toAdd = addressDAO.create(toAdd);
		Assert.assertNull(toAdd);
		
	 }
	 
	 //add an empty rafter
	@Test
	 public void addAnEmptyAddress(){
		 Address test = addressDAO.create(new Address());
		 Assert.assertNull("it should returns null", test);
	 }
	 
	 //add a null rafter
	@Test
	 public void addANullAddress(){
		 Address test = addressDAO.create(new Address(null,null, null));
		 Assert.assertNull("it should returns null", test);
	 }
	 
	//#####READ TESTS########
	 
		 //read a non existing rafter
		@Test
		public void readANonExistingAddress(){
			Address toRead = new Address(1234123);
			toRead = addressDAO.read(toRead);
			Assert.assertNull("it should returns null", toRead);
		}
		 
		 //read an existing rafter
		@Test
		public void readAnExistingAddress(){
			this.address = addressDAO.read(address);
			Assert.assertNotNull("it should returns not null", this.address);
		}
		
		 //read a non existing rafter list
		@Test
		public void readANonExistingAddressList(){
			addressDAO.delete(this.address);
			List<Address> addresses = addressDAO.read();
			Assert.assertTrue("it should returns empty list", addresses.isEmpty());
		}
		 
		 //read an existing rafter list
		@Test
		public void readAnExistingAddressList(){
			List<Address> addresses = addressDAO.read();
			Assert.assertTrue("it should returns full list", !addresses.isEmpty());
		}
		
		
		
		
		//#####UPDATE TESTS########
	 
	//#####UPDATE TESTS########
	 //update an existing rafter
	 @Test
	 public void updateAnExistingAddress(){
		 this.address.setRoadName("capullo");
		 addressDAO.update(this.address);
		 Assert.assertNotNull("it should returns not null", this.address);
		 Assert.assertEquals("email should be capullo", this.address.getRoadName(), "capullo");
		 addressDAO.delete(address);
		 
	 }
	 
	 //update an empty rafter
	 @Test
	 public void updateAnEmptyAddress(){
		Address address = new Address();
		address = addressDAO.update(address);
		Assert.assertNull(address);
		 
	 }
	 
	 
	 //update a non existing rafter
	 @Test
	 public void updateANonExistingAddress(){
		 Address address = new Address(888988);
		 address = addressDAO.update(address);
		 Assert.assertNull("it should returns null", address);
	 }
	//#####DELETE TESTS########
	 
		 //delete an existing rafter
	@Test
	public void deleteAnExistingAddress(){
		Address deleted = addressDAO.delete(this.address);
		Assert.assertNotNull("it should returns a not null object", deleted);
	}
		 //delete a non existing rafter
	@Test
	public void deleteANonExistingAddress(){
		Address toDelete = new Address(123123);
		Address deleted = addressDAO.delete(toDelete);
		Assert.assertNull("it should returns a null object", deleted);
	}
	 	
	//TODO delete a rafter with dependencies
 
}

