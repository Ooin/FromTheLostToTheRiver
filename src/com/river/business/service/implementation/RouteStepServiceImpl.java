package com.river.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.river.business.service.interfaces.RouteStepService;
import com.river.entity.RouteStep;
import com.river.persistence.dao.interfaces.RouteStepDAO;

@Service
public class RouteStepServiceImpl implements RouteStepService{

	@Autowired
	RouteStepDAO rafterDAO;

	public RouteStepDAO getRouteStepDAO() {
		return rafterDAO;
	}

	public void setRouteStepDAO(RouteStepDAO rafterDAO) {
		this.rafterDAO = rafterDAO;
	}

	@Override
	@Transactional
	public RouteStep create(RouteStep toCreate) {
		RouteStep routeStep = null;
		if (toCreate.getRoute() != null && toCreate.getOrigin() != null && toCreate.getDestiny() != null) {

			if(toCreate != null){
				routeStep = rafterDAO.create(toCreate);
			}
		}else{
			routeStep = null;
		}
		return routeStep;
	}

	@Override
	@Transactional

	public RouteStep read(RouteStep toRead) {
		RouteStep rafter = null;
		if(toRead != null && toRead.getId() != null){
			rafter = rafterDAO.read(toRead);
		}
		return rafter;
	}

	@Override
	@Transactional
	public List<RouteStep> read() {
		return rafterDAO.read();
	}

	@Override
	@Transactional

	public RouteStep update(RouteStep toUpdate) {
		RouteStep rafter = null;
		if(toUpdate != null && toUpdate.getId() != null){
			rafter = rafterDAO.update(toUpdate);
		}
		return rafter;
	}

	@Override
	@Transactional

	public RouteStep delete(RouteStep toDelete) {
		RouteStep rafter = null;
		if(toDelete != null && toDelete.getId() != null){
			rafter = rafterDAO.delete(toDelete);
		}
		return rafter;
	}
}
