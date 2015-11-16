package com.river.persistence.dao.interfaces;

import com.river.entity.Address;

public interface AddressDAO extends DAO<Address> {

	public Address readWithInitializedStopslist(Address address);
	public Address readWithInitializedOriginslist(Address address);
	public Address readWithInitializedDestinieslist(Address address);

}
