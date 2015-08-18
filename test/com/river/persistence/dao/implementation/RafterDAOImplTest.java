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
		 rafter = new Rafter("testRafter2","1234", "testRafter2@gmail.com", "9999-99-99");
	 }
	 
	 
	 
	 //#####CREATE TESTS########
	 
	 //add a new rafter
	 @Test
	 public void addANonExistingRafter(){
		 Rafter test = rafterDAO.create(this.rafter);
		 Assert.assertNotNull("it should returns not null", test);
		 System.out.println(test);
		 rafterDAO.delete(test);
		 
	 }
	 
	 //add a new EXISTING rafter
	
	 public void addAnExistingRafter(){
		rafterDAO.create(rafter);
		Rafter toAdd = new Rafter("testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		toAdd = rafterDAO.create(toAdd);
		Assert.assertNull(toAdd);
		rafterDAO.delete(this.rafter);
		 
	 }
	 
	 
	 
	 //add an empty rafter
	 
	 //add a null rafter
	 
	 
	//#####READ TESTS########
	 
		 //read a non existing rafter
		 
		 //read an existing rafter
		 
		//#####UPDATE TESTS########
	 
	//#####UPDATE TESTS########
	 //update an existing rafter
	 
	 //update an empty rafter
	 
	 //update a null rafter
	 
	 //update a non existing rafter
	 
	//#####DELETE TESTS########
	 
		 //delete an existing rafter
		 
		 //delete a non existing rafter
	 	
	 	//delete a rafter with dependencies
 
}
