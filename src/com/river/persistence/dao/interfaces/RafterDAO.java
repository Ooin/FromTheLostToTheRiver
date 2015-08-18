package com.river.persistence.dao.interfaces;

import java.util.List;

import com.river.entity.Rafter;

public interface RafterDAO {

	public Rafter create(Rafter toCreate);
	
	public Rafter read(Rafter toRead);
	
	public List<Rafter> read();
	
	public Rafter update(Rafter toUpdate);
	
	public Rafter delete(Rafter toDelete);

}
