package com.river.persistence.dao.interfaces;

import java.util.List;

public interface DAO<T> {
	
	
	 /**
	  * 
	  * @param toCreate = object to persist, can not be null.
	  * @return the object created or null if the method fails.
	  */
	public T create(T toCreate);

	/**
	 * 
	 * @param toRead = object to read, can not be null or have an empty id.
	 * @return the object reader or null if the method fails.
	 */
	public T read(T toRead);

	/**
	 * 
	 * @return a list of objects. Empty if the method fails or there are not objects in database or full list.
	 */
	public List<T> read();

	/**
	 * 
	 * @param toUpdate = object to modify
	 * @return the object updated or null if the method fails
	 */
	public T update(T toUpdate);

	/**
	 * 
	 * @param toDelete = object to delete
	 * @return the object deleted or null if the method fails
	 */
	public T delete(T toDelete);
}
