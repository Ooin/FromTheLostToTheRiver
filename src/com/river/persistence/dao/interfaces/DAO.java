package com.river.persistence.dao.interfaces;

import java.util.List;

public interface DAO<T> {
	public T create(T toCreate);

	public T read(T toRead);

	public List<T> read();

	public T update(T toUpdate);

	public T delete(T toDelete);
}
