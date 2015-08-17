package com.river.persistence.dao;

import java.util.List;

import com.river.entity.RouteFather;

public interface RouteFatherDAO {

	public RouteFather create(RouteFather toCreate);
	
	public RouteFather read(RouteFather toRead);

	public List<RouteFather> read();

	public RouteFather update(RouteFather toUpdate);

	public RouteFather delete(RouteFather toDelete);
}
