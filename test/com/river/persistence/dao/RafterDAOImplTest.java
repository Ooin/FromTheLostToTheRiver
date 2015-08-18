package com.river.persistence.dao;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.persistence.dao.interfaces.RafterDAO;



import com.river.entity.Rafter;
import com.river.persistence.dao.interfaces.RafterDAO;

public class RafterDAOImplTest {
	
	RafterDAO rafterDAO;
	Rafter rafter;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	
	 @Before
	 public void initTest(){
		 rafterDAO = context.getBean(RafterDAOImpl.class);
		 rafter = new Rafter("99", "testRafter","1234", "testRafter@gmail.com", "9999-99-99");
		 rafterDAO.create(rafter);
		 rafter = new Rafter("100", "testRafter2","1234", "testRafter2@gmail.com", "9999-99-99");
	 }
	 
	 
	 //#####CREATE TESTS########
	 
	 //add a new rafter
	 @Test
	 public void addANonExistingRafter(){
		 Rafter test = rafterDAO.create(this.rafter);
		 Assert.assertNotNull("it should returns not null", test);
	 }
	 
	 //add a new EXISTING rafter
	 
	 
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
