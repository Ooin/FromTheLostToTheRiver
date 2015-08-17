package com.river.persistence.dao;

import java.util.List;

import com.river.entity.Address;

public interface AddressDAO {

	public Address create(Address address);
	
	public Address read(Address address);
	
	public List<Address> read();
	
	public Address update(Address address);
	
	public Address delete(Address address);
	
}
