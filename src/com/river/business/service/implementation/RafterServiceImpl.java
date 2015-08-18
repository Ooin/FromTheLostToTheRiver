package com.river.business.service.implementation;

import java.util.List;

import com.river.business.service.interfaces.RafterService;
import com.river.entity.Rafter;
import com.river.persistence.dao.interfaces.RafterDAO;

public class RafterServiceImpl implements RafterService{

	
	RafterDAO rafterDAO;
	
	public RafterDAO getRafterDAO() {
		return rafterDAO;
	}

	public void setRafterDAO(RafterDAO rafterDAO) {
		this.rafterDAO = rafterDAO;
	}

	@Override
	public Rafter create(Rafter toCreate) {
		return rafterDAO.create(toCreate);
	}

	@Override
	public Rafter read(Rafter toRead) {
		return rafterDAO.read(toRead);
	}

	@Override
	public List<Rafter> read() {
		return rafterDAO.read();
	}

	@Override
	public Rafter update(Rafter toUpdate) {
		return rafterDAO.update(toUpdate);
	}

	@Override
	public Rafter delete(Rafter toDelete) {
		return rafterDAO.delete(toDelete);
	}

}
