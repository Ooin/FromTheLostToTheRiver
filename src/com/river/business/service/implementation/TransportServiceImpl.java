package com.river.business.service.implementation;

import java.util.List;

import com.river.business.service.interfaces.TransportService;
import com.river.entity.Transport;
import com.river.persistence.dao.interfaces.TransportDAO;

public class TransportServiceImpl implements TransportService {

	TransportDAO transportDAO;

	public TransportDAO getTransportDAO() {
		return transportDAO;
	}

	public void setTransportDAO(TransportDAO transportDAO) {
		this.transportDAO = transportDAO;
	}

	@Override
	public Transport create(Transport toCreate) {
		return transportDAO.create(toCreate);
	}

	@Override
	public Transport read(Transport toRead) {
		return transportDAO.read(toRead);
	}

	@Override
	public List<Transport> read() {
		return transportDAO.read();
	}

	@Override
	public Transport update(Transport toUpdate) {
		return transportDAO.update(toUpdate);
	}

	@Override
	public Transport delete(Transport toDelete) {
		return transportDAO.delete(toDelete);
	}

}
