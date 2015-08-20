package com.river.persistence.dao.interfaces;

import java.util.List;

import com.river.entity.Address;
import com.river.entity.RouteFather;

public interface RouteFatherDAO extends DAO<RouteFather> {

	public List<RouteFather> listMatchingRoutes(Address address);
	public RouteFather readRouteFatherWithRatesList(RouteFather routeFather);
	public RouteFather readRouteFatherWithStepsList(RouteFather routeFather);


}
