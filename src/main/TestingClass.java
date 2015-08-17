package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestingClass {

	
	void query(){
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
	
	public static void main( String args[] )
	  {
	     TestingClass c = new TestingClass();
	     c.query();
	  }

}
