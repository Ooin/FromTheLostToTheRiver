package com.river.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.river.business.service.interfaces.RouteFatherService;
import com.river.entity.Address;
import com.river.entity.RouteFather;
import com.river.persistence.dao.interfaces.RouteFatherDAO;

@Service
public class RouteFatherServiceImpl implements RouteFatherService {

	@Autowired
	RouteFatherDAO routeFatherDAO;
	
	public RouteFatherDAO getRouteFatherDAO() {
		return routeFatherDAO;
	}

	public void setRouteFatherDAO(RouteFatherDAO routeFatherDAO) {
		this.routeFatherDAO = routeFatherDAO;
	}

	@Override
	@Transactional
	public RouteFather create(RouteFather toCreate) {
		RouteFather routeFather = null;
		if(toCreate != null){
			routeFather = routeFatherDAO.create(toCreate);
		}
		return routeFather;
	}

	@Override
	@Transactional

	public RouteFather read(RouteFather toRead) {
		RouteFather routeFather = null;
		if(toRead != null && toRead.getId() != null){
			routeFather = routeFatherDAO.read(toRead);
		}
		return routeFather;
	}

	@Override
	@Transactional

	public List<RouteFather> read() {
		return routeFatherDAO.read();
	}

	@Override
	@Transactional

	public RouteFather update(RouteFather toUpdate) {
		RouteFather routeFather = null;
		if(toUpdate != null && toUpdate.getId() != null){
			routeFather = routeFatherDAO.update(toUpdate);
		}
		return routeFather;
	}

	@Override
	@Transactional

	public RouteFather delete(RouteFather toDelete) {
		RouteFather routeFather = null;
		if(toDelete != null && toDelete.getId() != null){
			routeFather = routeFatherDAO.delete(toDelete);
		}
		return routeFather;
	}

	@Override
	@Transactional

	public List<RouteFather> listMatchingRoutes(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RouteFather readRouteFatherWithRatesList(RouteFather routeFather) {
		
		return routeFatherDAO.readRouteFatherWithRatesList(routeFather);
	}

	@Override
	public RouteFather readRouteFatherWithStepsList(RouteFather routeFather) {
		
		return routeFatherDAO.readRouteFatherWithStepsList(routeFather);
	}

}
