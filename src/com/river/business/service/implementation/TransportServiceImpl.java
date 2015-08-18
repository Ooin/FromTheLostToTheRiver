package com.river.business.service.implementation;

import java.util.List;

import com.river.business.service.interfaces.TransportService;
import com.river.entity.Transport;

public class TransportServiceImpl implements TransportService{

	Transport transportDAO;
	
	public Transport getTransportDAO() {
		return transportDAO;
	}

	public void setTransportDAO(Transport transportDAO) {
		this.transportDAO = transportDAO;
	}

	@Override
	public Transport create(Transport toCreate) {
		return null;
	}

	@Override
	public Transport read(Transport toRead) {
		return null;
	}

	@Override
	public List<Transport> read() {
		return null;
	}

	@Override
	public Transport update(Transport toUpdate) {
		return null;
	}

	@Override
	public Transport delete(Transport toDelete) {
		return null;
	}

}
