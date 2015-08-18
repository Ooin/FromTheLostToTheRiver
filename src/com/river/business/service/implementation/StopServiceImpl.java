package com.river.business.service.implementation;

import java.util.List;

import com.river.business.service.interfaces.StopService;
import com.river.entity.Stop;
import com.river.persistence.dao.interfaces.StopDAO;

public class StopServiceImpl implements StopService {

	StopDAO stopDAO;

	public StopDAO getStopDAO() {
		return stopDAO;
	}

	public void setStopDAO(StopDAO stopDAO) {
		this.stopDAO = stopDAO;
	}

	@Override
	public Stop create(Stop toCreate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stop read(Stop toRead) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stop> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stop update(Stop toUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stop delete(Stop toDelete) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
