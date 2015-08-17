package com.river.persistence.dao;

import com.river.entity.Rafter;

public interface RafterDAO {

	public Rafter toCreate(Rafter rafter);
	
	public Rafter toRead(Rafter rafter);
	
	public Rafter toUpdate(Rafter rafter);
	
	public Rafter toDelete(Rafter rafter);

}
