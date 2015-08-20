package com.river.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.river.business.service.interfaces.AddressService;
import com.river.entity.Address;
import com.river.entity.Transport;
import com.river.persistence.dao.interfaces.AddressDAO;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDAO addressDAO;

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	@Override
	@Transactional
	public Address create(Address toCreate) {
		Address address = null;
		if (toCreate != null) {
			address = addressDAO.create(toCreate);
		}
		return address;
	}

	@Override
	@Transactional
	public Address read(Address toRead) {
		Address address = null;
		if (toRead != null && toRead.getId() != null) {
			address = addressDAO.read(toRead);
		}
		return address;
	}

	@Override
	@Transactional
	public List<Address> read() {
		return addressDAO.read();
	}

	@Override
	@Transactional
	public Address update(Address toUpdate) {
		Address address = null;
		if (toUpdate != null && toUpdate.getId() != null) {
			address = addressDAO.update(toUpdate);
		}
		return address;
	}

	@Override
	@Transactional
	public Address delete(Address toDelete) {
		Address address = null;
		if (toDelete != null && toDelete.getId() != null) {
			address = addressDAO.delete(toDelete);
		}
		return address;
	}

	@Override
	@Transactional
	public Address readWithInitializedStopslist(Address address) {
		Address readed = null;
		if (address != null) {
			readed = addressDAO.readWithInitializedStopslist(address);
		}
		return readed;
	}

	@Override
	@Transactional
	public Address readWithInitializedOriginslist(Address address) {
		Address readed = null;
		if (address != null) {
			readed = addressDAO.readWithInitializedOriginslist(address);
		}
		return readed;
	}

	@Override
	@Transactional
	public Address readWithInitializedDestinieslist(Address address) {
		Address readed = null;
		if (address != null) {
			readed = addressDAO.readWithInitializedDestinieslist(address);
		}
		return readed;
	}

}
