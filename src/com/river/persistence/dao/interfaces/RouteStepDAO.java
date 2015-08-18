package com.river.persistence.dao.interfaces;

import java.util.List;

import com.river.entity.RouteStep;

public interface RouteStepDAO {

	public RouteStep create(RouteStep toCreate);
	
	public RouteStep read(RouteStep toRead);

	public List<RouteStep> read();

	public RouteStep update(RouteStep toUpdate);

	public RouteStep delete(RouteStep toDelete);
}
