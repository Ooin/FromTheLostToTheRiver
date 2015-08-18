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

	public Stop create(Stop toCreate) {
		return stopDAO.create(toCreate);
	}

	public Stop read(Stop toRead) {
		return stopDAO.read(toRead);
	}

	public List<Stop> read() {
		return stopDAO.read();
	}

	public Stop update(Stop toUpdate) {
		return stopDAO.update(toUpdate);
	}

	public Stop delete(Stop toDelete) {
		return stopDAO.delete(toDelete);
	}

}
