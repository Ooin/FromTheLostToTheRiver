package com.river.persistence.dao;

import java.util.List;

import com.river.entity.Rafter;

public interface RafterDAO {

	public Rafter Create(Rafter toCreate);
	
	public Rafter Read(Rafter toRead);
	
	public List<Rafter> read();
	
	public Rafter Update(Rafter toUpdate);
	
	public Rafter Delete(Rafter toDelete);

}
