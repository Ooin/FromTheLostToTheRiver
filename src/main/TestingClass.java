package main;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Rafter;
import com.river.persistence.dao.RafterDAO;
import com.river.persistence.dao.RafterDAOImpl;



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
	
	
	void insertTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
		RafterDAO dao = context.getBean(RafterDAOImpl.class);
		//dao.Create(new Rafter( "holoaasdf", "asdfaasdfasdfsf33d", "hosasdfdflo@gmail.com", new Date()));
		System.out.println(dao.Read(new Rafter(1)));
	}
	
	public static void main( String args[] )
	  {
	     TestingClass c = new TestingClass();
//	     c.query();
		c.insertTest();
	  }

}
