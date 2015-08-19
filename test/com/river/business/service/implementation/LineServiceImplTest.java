package com.river.business.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.business.service.interfaces.LineService;
import com.river.entity.Line;
import com.river.entity.Transport;

public class LineServiceImplTest {
	
	LineService lineService;
	Line line;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	private Integer EXISTING_ID;
	
	@Before
	public void init(){
		lineService = context.getBean(LineServiceImpl.class);
		line = new Line("L"+ new Random().nextInt(), new Transport(1));
	}
	
	@Test
	public void createWrongObject(){
		line.setName(null);
		line = lineService.create(line);
		Assert.assertNull("If the object is empty the returned object must be null", line);
	}
	
	@Test
	public void createRightObject(){
		line = new Line("R"+new Random().nextInt(), new Transport(1));
		line = lineService.create(line);
		
		Assert.assertNotNull("When the values inserted are acceptable the return value must be not null", line);
		Assert.assertNotNull("When the values inserted are acceptable the return line mus be populated with a new id", line.getId());
	}
	
	@Test
	public void readGetsAnIncorrectObject(){
		line = new Line(Integer.MAX_VALUE);
		line = lineService.read(line);
		
		Assert.assertNull("When the id doesn't exist it must return null", line);
		
		line = new Line();
		line = lineService.read(line);
		Assert.assertNull("When the id is null it must return null", line);
		
	}
	
	@Test
	public void readGetsACorrectObject(){
		//Preparing the test
		Line aux = lineService.create(new Line("R"+ new Random().nextInt(), new Transport(1)));
		EXISTING_ID = aux.getId();
		
		line = new Line(EXISTING_ID);
		line = lineService.read(line);
		
		Assert.assertNotNull("When the id does exist it must return a full Line", line);
		Assert.assertNotNull("When the id does exist it must return a Line populated", line.getName());
	}
	
	@Test
	public void readGetsNoParameter(){
		List<Line> lines = new ArrayList<Line>();
		lines = lineService.read();
		
		Assert.assertFalse("If there are any lines in the database, the return must be a populated list", lines.isEmpty());
	}
	
	@Test
	public void updateGetsAnExistingLine(){
		//Preparing the test
		Line aux = lineService.create(new Line("R"+ new Random().nextInt(), new Transport(1)));
		EXISTING_ID = aux.getId();
		
		line = new Line(EXISTING_ID);
		line = lineService.update(line);
		
		Assert.assertNull("If the parameters are no ok object can't be updated", line);

		line = new Line(EXISTING_ID, "R"+new Random().nextInt(), new Transport(1));
		line = lineService.update(line);
		
		Assert.assertNotNull("If the parameters are ok object is updated", line);
	}
	
	@Test
	public void updateGetsANonExistingLine(){
		line = new Line(Integer.MAX_VALUE);
		line = lineService.update(line);
		
		Assert.assertNull("If the line doesn't exist the object can't be updated", line);
	}
	
	@Test
	public void deleteGetsAnExistingLine(){
		//Preparing the test
		Line aux = lineService.create(new Line("R"+ new Random().nextInt(), new Transport(1)));
		EXISTING_ID = aux.getId();
		
		line = new Line(EXISTING_ID);
		line = lineService.delete(line);
		
		Assert.assertNotNull("If the line exists, the return must be the deleted line", line);
	}
	
	@Test
	public void deleteGetsANonExistingLine(){
		line = new Line(Integer.MAX_VALUE);
		line = lineService.delete(line);
		
		Assert.assertNull("If the line deoesn't exists, the return must be null", line);
	}
	
}
