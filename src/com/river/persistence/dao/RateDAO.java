package com.river.persistence.dao;

import java.util.List;

import com.river.entity.Rate;

public interface RateDAO {
	
	//CRUD
	public Rate create(Rate rate);
	
	public Rate read(Rate rate);
	public List<Rate> read();
	
	public Rate update(Rate rate);
	
	public Rate delete(Rate rate);

}
