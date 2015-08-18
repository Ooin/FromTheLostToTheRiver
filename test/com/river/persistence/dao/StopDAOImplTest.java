package com.river.persistence.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Address;
import com.river.entity.Stop;
import com.river.persistence.dao.implementation.StopDAOImpl;



public class StopDAOImplTest {
	
	ApplicationContext appContext = new ClassPathXmlApplicationContext(
			"config/spring-config.xml");
	Stop stopNull;
	Stop stopGood;
	StopDAOImpl dao = (StopDAOImpl) appContext.getBean(StopDAOImpl.class);

	public void deleteInserted(Stop toDelete) {
		dao.delete(toDelete);
	}
	
	@Before
	public void init(){
		stopNull = new Stop(null,null);
		stopGood = new Stop(1,new Address(0,"paticagüena","pata"));
	}
	
	
	@Test
	public void createStopWithNullValues(){
		stopNull = dao.create(stopNull);
		
		Assert.assertNull("Stop must be null", stopNull);
	}
	
	@Test
	public void createStopWithGoodValues() {
		stopGood = dao.create(stopGood);
		Assert.assertNotNull("Stop must be not null", !stopGood.equals(null));
	}

}
