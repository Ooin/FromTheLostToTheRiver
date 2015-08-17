package com.river.persistence.dao;

import java.util.List;

import com.river.entity.Line;

public interface LineDAO {
	
	//CRUD
	
	public Line create(Line toCreate);
	
	public Line read(Line line);
	public List<Line> read();
	
	public Line update(Line line);
	
	public Line delete(Line line);

}
