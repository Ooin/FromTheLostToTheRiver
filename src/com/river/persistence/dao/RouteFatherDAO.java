package com.river.persistence.dao;

import java.util.List;

import com.river.entity.RouteFather;

public interface RouteFatherDAO {

	RouteFather create(RouteFather toCreate);
	RouteFather read(RouteFather toRead);
	List<RouteFather> read();
	RouteFather update(RouteFather toUpdate);
	RouteFather delete(RouteFather toDelete);
}
