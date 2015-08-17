package com.river.persistence.dao;

import java.util.List;

import com.river.entity.Rafter;

public interface RafterDAO {

	public Rafter toCreate(Rafter rafter);
	
	public Rafter toRead(Rafter rafter);
	
	public List<Rafter> read();
	
	public Rafter toUpdate(Rafter rafter);
	
	public Rafter toDelete(Rafter rafter);

}
