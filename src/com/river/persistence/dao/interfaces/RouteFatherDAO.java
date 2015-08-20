package com.river.persistence.dao.interfaces;

import java.util.List;

import com.river.entity.Address;
import com.river.entity.Rafter;
import com.river.entity.RouteFather;

public interface RouteFatherDAO extends DAO<RouteFather> {

	public List<RouteFather> listMatchingRoutes(Address address);

}
