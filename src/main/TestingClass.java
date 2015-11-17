package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.business.service.interfaces.LineService;
import com.river.business.service.interfaces.RafterService;
import com.river.business.service.interfaces.RouteFatherService;
import com.river.business.service.interfaces.RouteStepService;
import com.river.business.service.interfaces.StopService;
import com.river.entity.Line;
import com.river.entity.Rafter;
import com.river.entity.Rate;
import com.river.entity.RouteFather;
import com.river.entity.RouteStep;
import com.river.entity.Stop;

public class TestingClass {

	void query() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("from master");
			c = DriverManager.getConnection("jdbc:sqlite:riverDatabaseF");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "select * from TRANSPORT";
			stmt.execute(sql);
			ResultSet rset = stmt.getResultSet();

			while (rset.next()) {
				System.out.println(rset.getString("name"));
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public void getRoutes() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
		RafterService service = (RafterService) context.getBean("rafterServiceImpl");
		Rafter rafter = service.readWithInitializedRateslist(new Rafter(1));
		service.read(rafter);
		List<Rate> list = rafter.getRates();

		if (list.isEmpty()) {
			System.out.println("sssta vacioooo");
		} else {
			for (Rate r : list) {
				System.out.println(r);
			}
		}

	}
	
	public void addStepsToRoute(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
		RouteFatherService fatherS = (RouteFatherService) context.getBean("routeFatherServiceImpl");
		RouteStepService routeS = (RouteStepService) context.getBean("routeStepServiceImpl");
		RouteFather routeFather = fatherS.read(new RouteFather(1));
		RouteStep r1= routeS.read(new RouteStep(1));
		RouteStep r2= routeS.read(new RouteStep(2));
		
		
		routeFather.getRouteSteps().add(r1);
		routeFather.getRouteSteps().add(r2);
		
		fatherS.update(routeFather);

				
	}
	
	public void addStopToLine(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
		StopService stopS = (StopService) context.getBean("stopServiceImpl");
		LineService lineS = (LineService) context.getBean("lineServiceImpl");
		
		Line line = lineS.read(new Line(1));
		System.out.println(line);
		Stop stop = stopS.read(new Stop(1));
		Stop stop2 = stopS.read(new Stop(2));
		Stop stop3 = stopS.read(new Stop(3));
		
		line.getStops().add(stop);
		line.getStops().add(stop2);
		line.getStops().add(stop3);
		lineS.update(line);
	}

	public static void main(String args[]) throws ParseException {
		TestingClass e = new TestingClass();
		e.addStopToLine();

	}

}