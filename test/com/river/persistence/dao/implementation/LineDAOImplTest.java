package com.river.persistence.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Line;
import com.river.entity.Transport;
import com.river.persistence.dao.interfaces.LineDAO;

public class LineDAOImplTest {
	
	LineDAO lineDAO;
	Line line;
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	
	private Integer EXISTING_ID = 1;
	private static final Integer EXISTING_TRANSPORT = 1;
	
	@Before
	public void init(){
		lineDAO = context.getBean(LineDAOImpl.class);
	}
	
	
//	 * Create
//	 * 	-empty object
	
	@Test
	public void createGetAnEmptyObject(){
		line = new Line();
		line = lineDAO.create(line);
		
		Assert.assertNull("If the object is empty the returned object must be null", line);
		
		line = new Line(null, null);
		line = lineDAO.create(line);
		
		Assert.assertNull("If any of the values in the obect is not acceptable the returned object must be null", line);
	}
	
//	 * 	-ok object
	
	@Test
	public void createGetAnAcceptableObject(){
		line = new Line("R"+new Random().nextInt(), new Transport(1));
		line = lineDAO.create(line);
		
		Assert.assertNotNull("When the values inserted are acceptable the return value must be not null", line);
		Assert.assertNotNull("When the values inserted are acceptable the return line mus be populated with a new id", line.getId());
	}
	
//	 * Read
//	 * 	-non existing id
	
	@Test
	public void readGetsAnIncorrectObject(){
		line = new Line(Integer.MAX_VALUE);
		line = lineDAO.read(line);
		
		Assert.assertNull("When the id doesn't exist it must return null", line);
		
		line = new Line();
		line = lineDAO.read(line);
		Assert.assertNull("When the id is null it must return null", line);
		
	}
	
//	 * 	-existing id
	
	@Test
	public void readGetsACorrectObject(){
		//Preparing the test
		Line aux = lineDAO.create(new Line("R"+ new Random().nextInt(), new Transport(EXISTING_TRANSPORT)));
		EXISTING_ID = aux.getId();
		
		line = new Line(EXISTING_ID);
		line = lineDAO.read(line);
		
		Assert.assertNotNull("When the id does exist it must return a full Line", line);
		Assert.assertNotNull("When the id does exist it must return a Line populated", line.getName());
	}
	
	@Test
	public void readGetsNoParameter(){
		List<Line> lines = new ArrayList<Line>();
		lines = lineDAO.read();
		
		Assert.assertFalse("If there are any lines in the database, the return must be a populated list", lines.isEmpty());
	}
	
//	 * Update
//	 * 	-update correct
//	 * 		-with wrong parameters
//	 * 		-with ok parameters
	
	@Test
	public void updateGetsAnExistingLine(){
		//Preparing the test
		Line aux = lineDAO.create(new Line("R"+ new Random().nextInt(), new Transport(EXISTING_TRANSPORT)));
		EXISTING_ID = aux.getId();
		
		line = new Line(EXISTING_ID);
		line = lineDAO.update(line);
		
		Assert.assertNull("If the parameters are no ok object can't be updated", line);

		line = new Line(EXISTING_ID, "R"+new Random().nextInt(), new Transport(EXISTING_TRANSPORT));
		line = lineDAO.update(line);
		
		Assert.assertNotNull("If the parameters are ok object is updated", line);
	}
	
//	 * 	-update non existing
	
	@Test
	public void updateGetsANonExistingLine(){
		line = new Line(Integer.MAX_VALUE);
		line = lineDAO.update(line);
		
		Assert.assertNull("If the line doesn't exist the object can't be updated", line);
	}
	
//	 * Delete
//	 * 	-delete existing
	
	@Test
	public void deleteGetsAnExistingLine(){
		//Preparing the test
		Line aux = lineDAO.create(new Line("R"+ new Random().nextInt(), new Transport(EXISTING_TRANSPORT)));
		EXISTING_ID = aux.getId();
		
		line = new Line(EXISTING_ID);
		line = lineDAO.delete(line);
		
		Assert.assertNotNull("If the line exists, the return must be the deleted line", line);
	}
	
//	 * 	-delete non existing
	@Test
	public void deleteGetsANonExistingLine(){
		line = new Line(Integer.MAX_VALUE);
		line = lineDAO.delete(line);
		
		Assert.assertNull("If the line deoesn't exists, the return must be null", line);
	}

}
