package com.river.persistence.dao;

import java.util.List;

import com.river.entity.Transport;

public interface TransportDAO {
	
	public Transport create(Transport toCreate);
	
	public Transport read(Transport toRead);
	
	public List<Transport> read();
	
	public Transport update(Transport toUpdate);
	
	public Transport delete(Transport toDelete);
	
}
