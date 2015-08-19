package com.river.persistence.dao.implementation;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Address;
import com.river.entity.Stop;



public class StopDAOImplTest {
	
	ApplicationContext appContext = new ClassPathXmlApplicationContext(
			"config/spring-config.xml");
	Stop stopNull;
	Stop stopGood;
	Stop stopNotExists;
	Stop toUse;
	Address addressExists;
	Address addressNotExists;
	StopDAOImpl dao = (StopDAOImpl) appContext.getBean(StopDAOImpl.class);

	public void deleteInserted(Stop toDelete) {
		dao.delete(toDelete);
	}
	
	@Before
	public void init(){
		addressExists = new Address(1,0,"patica","pata");
		addressNotExists = new Address(2,0,"bicicleta","bike");
		stopNull = new Stop(null,null);
		stopGood = new Stop(addressExists);
		stopNotExists = new Stop(addressNotExists);
	}
		
	@Test
	public void createStopWithNullValues(){
		toUse = dao.create(stopNull);
		Assert.assertNull("Stop must be null", toUse);
		if(toUse != null){
			deleteInserted(toUse);
		}
	}
	
	@Test
	public void createStopWithGoodValues() {
		toUse = dao.create(stopGood);
		Assert.assertNotNull("Stop must be not null", toUse);
		if(toUse != null){
			deleteInserted(toUse);
		}
	}
	
	@Test
	public void readStopThatExists(){
		dao.create(stopGood);
		toUse = dao.read(stopGood);
		Assert.assertNotNull("Stop must be not null", toUse);
		if(toUse != null){
			deleteInserted(toUse);
		}
	}
	
	@Test
	public void readStopNull(){
		toUse = dao.read(stopNull);
		Assert.assertNull("Stop must be null", toUse);
	}
	
	@Test
	public void readStopThatNotExists(){
		toUse = dao.read(stopNotExists);
		Assert.assertNull("Stop must be null", toUse);
	}
	
	@Test
	public void deleteStopThatExists(){
		dao.create(stopGood);
		toUse = dao.delete(stopGood);
		Assert.assertNotNull("Stop must be not null", toUse);
		if(toUse != null){
			deleteInserted(toUse);
		}
	}
	
	@Test
	public void deleteStopThatNotExists(){
		toUse = dao.delete(stopNotExists);
		Assert.assertNull("Stop must be null", toUse);
	}
	
	@Test
	public void updateStopThatExists(){
		dao.create(stopGood);
		addressExists.setRoadType("COCHE");
		stopGood.setAdress(addressExists);
		toUse = dao.update(stopGood);
		Assert.assertNotNull("Stop must be not null", toUse);
		if(toUse != null){
			deleteInserted(toUse);
		}
	}
	
	@Test
	public void updateStopThatNotExists(){
		toUse = dao.update(stopNotExists);
		Assert.assertNull("Stop must be null", toUse);
	}
	
	@Test
	public void updateStopNull(){
		toUse = dao.update(stopNull);
		Assert.assertNull("Stop must be null", toUse);
	}
	
	@Test
	public void readListCorrectly(){
		dao.create(stopGood);
		List<Stop> stops = dao.read();
		Assert.assertTrue("list must be full",!stops.isEmpty());
		for(Stop p: stops){
				deleteInserted(p);
		}
	}
	
	@Test
	public void readListNotCorrectly(){
		List<Stop> stops = dao.read();
		Assert.assertTrue("list must be empty",stops.isEmpty());
	}

}
