package com.river.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.river.business.service.interfaces.StopService;
import com.river.entity.Stop;
import com.river.persistence.dao.interfaces.StopDAO;

@Service
public class StopServiceImpl implements StopService {

	@Autowired
	StopDAO stopDAO;

	public StopDAO getStopDAO() {
		return stopDAO;
	}

	public void setStopDAO(StopDAO stopDAO) {
		this.stopDAO = stopDAO;
	}

	@Override
	@Transactional
	public Stop create(Stop toCreate) {
		Stop stop = null;
		if (toCreate != null) {
			stop = stopDAO.create(toCreate);
		}
		return stop;
	}

	@Override
	@Transactional
	public Stop read(Stop toRead) {
		Stop stop = null;
		if (toRead != null && toRead.getId() != null) {
			stop = stopDAO.read(toRead);
		}
		return stop;
	}

	@Override
	@Transactional
	public List<Stop> read() {
		return stopDAO.read();
	}

	@Override
	@Transactional
	public Stop update(Stop toUpdate) {
		Stop stop = null;
		if (toUpdate != null && toUpdate.getId() != null) {
			stop = stopDAO.update(toUpdate);
		}
		return stop;
	}

	@Override
	@Transactional
	public Stop delete(Stop toDelete) {
		Stop stop = null;
		if (toDelete != null && toDelete.getId() != null) {
			stop = stopDAO.delete(toDelete);
		}
		return stop;
	}

}
