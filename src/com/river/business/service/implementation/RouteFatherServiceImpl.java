package com.river.business.service.implementation;

import java.util.List;

import com.river.business.service.interfaces.RouteFatherService;
import com.river.entity.Address;
import com.river.entity.RouteFather;
import com.river.persistence.dao.interfaces.RouteFatherDAO;

public class RouteFatherServiceImpl implements RouteFatherService {

	RouteFatherDAO routeFatherDAO;
	
	public RouteFatherDAO getRouteFatherDAO() {
		return routeFatherDAO;
	}

	public void setRouteFatherDAO(RouteFatherDAO routeFatherDAO) {
		this.routeFatherDAO = routeFatherDAO;
	}

	@Override
	public RouteFather create(RouteFather toCreate) {
		RouteFather routeFather = null;
		if(toCreate != null){
			routeFather = routeFatherDAO.create(toCreate);
		}
		return routeFather;
	}

	@Override
	public RouteFather read(RouteFather toRead) {
		RouteFather routeFather = null;
		if(toRead != null && toRead.getId() != null){
			routeFather = routeFatherDAO.read(toRead);
		}
		return routeFather;
	}

	@Override
	public List<RouteFather> read() {
		return routeFatherDAO.read();
	}

	@Override
	public RouteFather update(RouteFather toUpdate) {
		RouteFather routeFather = null;
		if(toUpdate != null && toUpdate.getId() != null){
			routeFather = routeFatherDAO.update(toUpdate);
		}
		return routeFather;
	}

	@Override
	public RouteFather delete(RouteFather toDelete) {
		RouteFather routeFather = null;
		if(toDelete != null && toDelete.getId() != null){
			routeFather = routeFatherDAO.delete(toDelete);
		}
		return routeFather;
	}

	@Override
	public List<RouteFather> listMatchingRoutes(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

}
