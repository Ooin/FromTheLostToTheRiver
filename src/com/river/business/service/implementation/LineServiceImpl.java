package com.river.business.service.implementation;

import java.util.List;

import com.river.business.service.interfaces.LineService;
import com.river.entity.Line;
import com.river.persistence.dao.interfaces.LineDAO;

public class LineServiceImpl implements LineService {
	
	LineDAO lineDAO;
	
	public LineDAO getLineDAO() {
		return lineDAO;
	}

	public void setLineDAO(LineDAO lineDAO) {
		this.lineDAO = lineDAO;
	}

	@Override
	public Line create(Line toCreate) {
		return lineDAO.create(toCreate);
	}

	@Override
	public Line read(Line toRead) {
		return lineDAO.read(toRead);
	}

	@Override
	public List<Line> read() {
		return lineDAO.read();
	}

	@Override
	public Line update(Line toUpdate) {
		return lineDAO.update(toUpdate);
	}

	@Override
	public Line delete(Line toDelete) {
		return lineDAO.delete(toDelete);
	}

}
