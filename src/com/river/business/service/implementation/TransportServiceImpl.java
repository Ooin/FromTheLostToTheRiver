package com.river.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.river.business.service.interfaces.TransportService;
import com.river.entity.Transport;
import com.river.persistence.dao.interfaces.TransportDAO;

@Service
public class TransportServiceImpl implements TransportService {

	@Autowired
	TransportDAO transportDAO;

	public TransportDAO getTransportDAO() {
		return transportDAO;
	}

	public void setTransportDAO(TransportDAO transportDAO) {
		this.transportDAO = transportDAO;
	}

	@Override
	@Transactional
	public Transport create(Transport toCreate) {
		Transport transport = null;
		if (toCreate != null) {
			transport = transportDAO.create(toCreate);
		}
		return transport;
	}

	@Override
	@Transactional
	public Transport read(Transport toRead) {
		Transport transport = null;
		if (toRead != null) {
			transport = transportDAO.read(toRead);
		}
		return transport;
	}

	@Override
	@Transactional
	public List<Transport> read() {
		return transportDAO.read();
	}

	@Override
	@Transactional
	public Transport update(Transport toUpdate) {
		Transport transport = null;
		if (toUpdate != null) {
			transport = transportDAO.update(toUpdate);
		}
		return transport;
	}

	@Override
	@Transactional
	public Transport delete(Transport toDelete) {
		Transport transport = null;
		if (toDelete != null) {
			transport = transportDAO.delete(toDelete);
		}
		return transport;
	}

	@Override
	@Transactional
	public Transport readWithInitializedLineslist(Transport transport) {
		Transport read = null;
		if (transport != null) {
			read = transportDAO.readWithInitializedLineslist(transport);
		}
		return read;
	}

}
