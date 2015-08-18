package com.river.persistence.dao;

import java.util.Date;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Rafter;

public class RafterDAOTest {
	
	@Test
	public void writesOk(){
		Rafter rafter = new Rafter("Emilio"+ new Random().nextInt(Integer.MAX_VALUE), "contraDeEmilio", "emilio@emiliomola.god" + new Random().nextInt(Integer.MAX_VALUE), new Date().toString());
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
		
		RafterDAO dao = context.getBean(RafterDAOImpl.class);
		
		rafter = dao.create(rafter);
		
		Assert.assertNotNull("The returned value must be not null when creating an object", rafter);
		Assert.assertNotNull("The returned value must have a valid id when creating an object", rafter.getId());
	}

}
