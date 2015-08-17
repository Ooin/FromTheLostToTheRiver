package com.river.persistence.dao;

import java.util.List;

import com.river.entity.Rafter;

public interface RafterDAO {

	public Rafter Create(Rafter rafter);
	
	public Rafter Read(Rafter rafter);
	
	public List<Rafter> read();
	
	public Rafter Update(Rafter rafter);
	
	public Rafter Delete(Rafter rafter);

}
