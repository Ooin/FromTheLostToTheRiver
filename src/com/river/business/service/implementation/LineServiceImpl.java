package com.river.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.river.business.service.interfaces.LineService;
import com.river.entity.Line;
import com.river.persistence.dao.interfaces.LineDAO;

@Service
public class LineServiceImpl implements LineService {
	
	@Autowired
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
