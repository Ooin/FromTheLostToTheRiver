package com.river.persistence.dao.interfaces;

import java.util.List;

import com.river.entity.Rate;


public interface RateDAO{
	
	public Rate create(Rate toCreate);
	
	public Rate read(Rate toRead);
	
	public List<Rate> read();
	
	public Rate update(Rate toUpdate);
	
	public Rate delete(Rate toDelete);
	
}