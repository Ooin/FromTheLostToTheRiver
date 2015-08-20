package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.river.business.service.implementation.RafterServiceImpl;
import com.river.business.service.interfaces.RafterService;
import com.river.entity.Rafter;
import com.river.entity.RouteFather;
import com.river.persistence.dao.implementation.RafterDAOImpl;
import com.river.persistence.dao.interfaces.RafterDAO;



public class TestingClass {

	
	void query(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
		
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:riverDatabaseF");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "select * from TRANSPORT";
	      stmt.execute(sql);
	      ResultSet rset = stmt.getResultSet();
	      
	      while(rset.next()){
	    	  System.out.println(rset.getString("name"));
	      }
	     
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	  }
	
	public void getRoutes(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
		RafterService service = (RafterService) context.getBean("rafterServiceImpl");
		Rafter rafter = service.readWithInitializedlist(new Rafter(1));
		service.read(rafter);
		List<RouteFather> list = rafter.getRoutes();
		for(RouteFather r: list){
			if(r.getTitle().equals("paco")){
				System.out.println(r);
			}
		}
		
		
	}
	
	public static void main( String args[] ) throws ParseException
	  {
	   TestingClass e = new TestingClass();
	   e.getRoutes();
			
	  }

}