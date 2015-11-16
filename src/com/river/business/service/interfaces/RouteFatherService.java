package com.river.business.service.interfaces;

import java.util.List;

import com.river.entity.Address;
import com.river.entity.RouteFather;

public interface RouteFatherService extends Service<RouteFather> {
	
	public List<RouteFather> listMatchingRoutes(Address address);
	public RouteFather readRouteFatherWithRatesList(RouteFather routeFather);
	public RouteFather readRouteFatherWithStepsList(RouteFather routeFather);


}
