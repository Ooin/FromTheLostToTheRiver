package com.river.persistence.dao.interfaces;

import java.util.List;

import com.river.entity.Address;

public interface AddressDAO {

	public Address create(Address toCreate);
	
	public Address read(Address toRead);
	
	public List<Address> read();
	
	public Address update(Address toUpdate);
	
	public Address delete(Address toDelete);
	
}
