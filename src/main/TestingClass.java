package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.entity.Rafter;
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
	
	
	void deleteTest() throws ParseException{
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
		RafterDAO dao = context.getBean(RafterDAOImpl.class);
		
		if (dao.delete(new Rafter( 1,"juan12asdfasdf3", "ddfdddddd", "hosaeadeo@gmail.com", "2012-02-09"))!=null){
	
			System.out.println("Borrao!");
		};
		//System.out.println(dao.read(new Rafter(1)));
		//List<Rafter> list = dao.read();
		//for(Rafter r: list){
		//	System.out.println(r);
		//}
	}
	
	public static void main( String args[] ) throws ParseException
	  {
	    Integer i = null;
	    System.out.println(i);
	    Rafter r = null;
			
	  }

}