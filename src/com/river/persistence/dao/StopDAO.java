package com.river.persistence.dao;

import java.util.List;

import com.river.entity.Stop;

public interface StopDAO {

	public Stop create(Stop toCreate);

	public Stop read(Stop toRead);

	public List<Stop> read();

	public Stop update(Stop toUpdate);

	public Stop delete(Stop toDelete);

}