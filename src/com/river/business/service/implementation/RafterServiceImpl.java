package com.river.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.river.business.service.interfaces.RafterService;
import com.river.entity.Rafter;
import com.river.persistence.dao.interfaces.RafterDAO;

@Service
public class RafterServiceImpl implements RafterService{

	@Autowired
	RafterDAO rafterDAO;
	
	public RafterDAO getRafterDAO() {
		return rafterDAO;
	}

	public void setRafterDAO(RafterDAO rafterDAO) {
		this.rafterDAO = rafterDAO;
	}

	@Override
	@Transactional 
	public Rafter create(Rafter toCreate) {
		Rafter rafter = null;
		if(toCreate != null){
			rafter = rafterDAO.create(toCreate);
		}
		return rafter;
	}

	@Override
	@Transactional
	public Rafter read(Rafter toRead) {
		Rafter rafter = null;
		if(toRead != null && toRead.getId() != null){
			rafter = rafterDAO.read(toRead);
		}
		return rafter;
	}

	@Override
	@Transactional 
	public List<Rafter> read() {
		return rafterDAO.read();
	}

	@Override
	@Transactional 
	public Rafter update(Rafter toUpdate) {
		Rafter rafter = null;
		if(toUpdate != null && toUpdate.getId() != null){
			rafter = rafterDAO.update(toUpdate);
		}
		return rafter;
	}

	@Override
	@Transactional 
	public Rafter delete(Rafter toDelete) {
		Rafter rafter = null;
		if(toDelete != null && toDelete.getId() != null){
			rafter = rafterDAO.delete(toDelete);
		}
		return rafter;
	}

	@Override
	@Transactional
	public Rafter readWithInitializedlist(Rafter rafter){
		return rafterDAO.readWithInitializedlist(rafter);
	}
}
