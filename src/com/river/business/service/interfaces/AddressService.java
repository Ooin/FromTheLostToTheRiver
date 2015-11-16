package com.river.business.service.interfaces;

import com.river.entity.Address;

public interface AddressService extends Service<Address>{

	public Address readWithInitializedStopslist(Address address);
	public Address readWithInitializedOriginslist(Address address);
	public Address readWithInitializedDestinieslist(Address address);

}
