package com.river.persistence.dao;

import java.util.List;

import com.river.entity.Rate;

public interface RateDAO {
	
	//CRUD
	public Rate create(Rate toCreate);
	
	public Rate read(Rate toRead);
	public List<Rate> read();
	
	public Rate update(Rate toUpdate);
	
	public Rate delete(Rate toDelete);

}
