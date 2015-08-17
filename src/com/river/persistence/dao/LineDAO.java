package com.river.persistence.dao;

import java.util.List;

import com.river.entity.Address;
import com.river.entity.Line;

public interface LineDAO{
	
	public Line create(Line toCreate);
	
	public Line read(Line toRead);
	
	public List<Line> read();
	
	public Line update(Line toUpdate);
	
	public Line delete(Line toDelete);
	
}