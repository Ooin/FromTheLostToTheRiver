package com.river.persistence.dao.interfaces;

import com.river.entity.Rafter;

public interface RafterDAO extends DAO<Rafter>{
	public Rafter readWithInitializedRateslist(Rafter rafter);
	public Rafter readWithInitializedRouteslist(Rafter rafter);
	
}
