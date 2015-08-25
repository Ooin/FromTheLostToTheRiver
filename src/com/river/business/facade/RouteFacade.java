package com.river.business.facade;

import java.util.ArrayList;
import java.util.List;

import com.river.business.service.interfaces.RafterService;
import com.river.business.service.interfaces.RouteFatherService;
import com.river.entity.Address;
import com.river.entity.Rafter;
import com.river.entity.RouteFather;


public class RouteFacade extends Facade{
	
	RafterService service = (RafterService) this.context.getBean("rafterServiceImpl");
	RouteFatherService routeService = (RouteFatherService) this.context.getBean("routeFatherServiceImpl");
	/**
	 * 
	 * @param rafter with not null id
	 * @return a rafter with their routes, if the method fails returns null.
	 */
	public Rafter getRafterRoutes(Rafter rafter){
		Rafter result = null;
		if(rafter!= null && rafter.getId() != null){
			result = service.readWithInitializedRouteslist(rafter);
		}
		
		return result;
	}

	/**
	 * As a rafter i want to look for a route(Address 1, Addres2): List<Routes>
	 */
	public RouteFather getARoute(Address origin, Address destiny){
		//TODO we need a query for get this route. We use core logic for get it temporally
		List<RouteFather> routes = routeService.read();
		List<RouteFather> matchRoutes = new ArrayList<>();
		
		for(RouteFather r: routes){
			if (r.get)
		}
		return new RouteFather();
	}
	
	/**
	 * As a rafter i want to create a Route
	 */
	
	/**
	 * As a rafter i want to edit a Route
	 */
	
	/**
	 * As a rafter i want to add steps to a route (another edit?)
	 */
	
	/**
	 * As a rafter i want to rate a route
	 */
	
	
	
	
}
