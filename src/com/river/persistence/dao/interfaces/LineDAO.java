package com.river.persistence.dao.interfaces;

import java.util.List;

import com.river.entity.Address;
import com.river.entity.Line;

public interface LineDAO{
	
	/**
	 * Persists the Line toCreate in the database only if it is full. Returns null if it was not presisted
	 * @param toCreate a Line to persist in the database
	 * @return the given Line if everything ok. null otherwise
	 */
	public Line create(Line toCreate);
	
	/**
	 * Retrieves a Line from the database via an object with, only, an ID.
	 * Returns null if the ID does not exist or a problem has happened.
	 * @param toRead The empty object only with the ID to fin
	 * @return the matching Line or null otherwise.
	 */
	public Line read(Line toRead);
	
	/**
	 * 
	 * @return
	 */
	public List<Line> read();
	
	public Line update(Line toUpdate);
	
	public Line delete(Line toDelete);
	
}