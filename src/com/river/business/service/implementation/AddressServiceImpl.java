package com.river.business.service.implementation;

import java.util.List;

import com.river.business.service.interfaces.AddressService;
import com.river.entity.Address;
import com.river.entity.Rafter;
import com.river.persistence.dao.interfaces.AddressDAO;

public class AddressServiceImpl implements AddressService{
	AddressDAO addressDAO;

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	@Override
	public Address create(Address toCreate) {
		Address address = null;
		if(toCreate != null){
			address = addressDAO.create(toCreate);
		}
		return address;
	}

	@Override
	public Address read(Address toRead) {
		Address address = null;
		if(toRead != null && toRead.getId() != null){
			address = addressDAO.read(toRead);
		}
		return address;
	}

	@Override
	public List<Address> read() {
		return addressDAO.read();
	}

	@Override
	public Address update(Address toUpdate) {
		Address address = null;
		if(toUpdate != null && toUpdate.getId() != null){
			address = addressDAO.update(toUpdate);
		}
		return address;
	}

	@Override
	public Address delete(Address toDelete) {
		Address address = null;
		if(toDelete != null && toDelete.getId() != null){
			address = addressDAO.delete(toDelete);
		}
		return address;
	}

	
	
}
