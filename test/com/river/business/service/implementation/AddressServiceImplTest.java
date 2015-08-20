package com.river.business.service.implementation;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.business.service.interfaces.AddressService;
import com.river.entity.Address;

public class AddressServiceImplTest {
	AddressService addressService;
	Address address;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	
	 @Before
	 public void initTest(){
		addressService = (AddressService) context.getBean("addressServiceImpl");
		this.address = new Address(11111,"street", "alcalde barnils");
		addressService.create(this.address);
	 }
	 
	 @After
	 public void deleteRows(){
		 addressService.delete(this.address);
	 }
	 
	 
	 
	 //#####CREATE TESTS########
	 
	 //add a new rafter
	 @Test
	 public void addANonExistingAddress(){
		 Address test = addressService.create(new Address(11111,"street", "alcalde barnils 2"));
		 Assert.assertNotNull("it should returns not null", test);
		 addressService.delete(test);
		 
	 }
	 
	 //add a new EXISTING rafter
	@Test
	 public void addAnExistingAddress(){
		Address toAdd = new Address(11111,"street", "alcalde barnils");
		toAdd = addressService.create(toAdd);
		Assert.assertNull(toAdd);
		
	 }
	 
	 //add an empty rafter
	@Test
	 public void addAnEmptyAddress(){
		 Address test = addressService.create(new Address());
		 Assert.assertNull("it should returns null", test);
	 }
	 
	 //add a null rafter
	@Test
	 public void addANullAddress(){
		 Address test = addressService.create(new Address(null,null, null));
		 Assert.assertNull("it should returns null", test);
	 }
	 
	//#####READ TESTS########
	 
		 //read a non existing rafter
		@Test
		public void readANonExistingAddress(){
			Address toRead = new Address(1234123);
			toRead = addressService.read(toRead);
			Assert.assertNull("it should returns null", toRead);
		}
		 
		 //read an existing rafter
		@Test
		public void readAnExistingAddress(){
			this.address = addressService.read(address);
			Assert.assertNotNull("it should returns not null", this.address);
		}
		
		 //read a non existing rafter list
		@Test
		public void readANonExistingAddressList(){
			addressService.delete(this.address);
			List<Address> addresses = addressService.read();
			Assert.assertTrue("it should returns empty list", addresses.isEmpty());
		}
		 
		 //read an existing rafter list
		@Test
		public void readAnExistingAddressList(){
			List<Address> addresses = addressService.read();
			Assert.assertTrue("it should returns full list", !addresses.isEmpty());
		}
		
		
		
		
		//#####UPDATE TESTS########
	 
	//#####UPDATE TESTS########
	 //update an existing rafter
	 @Test
	 public void updateAnExistingAddress(){
		 this.address.setRoadName("capullo");
		 addressService.update(this.address);
		 Assert.assertNotNull("it should returns not null", this.address);
		 Assert.assertEquals("email should be capullo", this.address.getRoadName(), "capullo");
		 addressService.delete(address);
		 
	 }
	 
	 //update an empty rafter
	 @Test
	 public void updateAnEmptyAddress(){
		Address address = new Address();
		address = addressService.update(address);
		Assert.assertNull(address);
		 
	 }
	 
	 
	 //update a non existing rafter
	 @Test
	 public void updateANonExistingAddress(){
		 Address address = new Address(888988);
		 address = addressService.update(address);
		 Assert.assertNull("it should returns null", address);
	 }
	//#####DELETE TESTS########
	 
		 //delete an existing rafter
	@Test
	public void deleteAnExistingAddress(){
		Address deleted = addressService.delete(this.address);
		Assert.assertNotNull("it should returns a not null object", deleted);
	}
		 //delete a non existing rafter
	@Test
	public void deleteANonExistingAddress(){
		Address toDelete = new Address(123123);
		Address deleted = addressService.delete(toDelete);
		Assert.assertNull("it should returns a null object", deleted);
	}
	 	
	//TODO delete a rafter with dependencies
 
}

