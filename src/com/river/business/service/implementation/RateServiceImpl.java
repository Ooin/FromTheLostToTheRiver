package com.river.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.river.business.service.interfaces.RateService;
import com.river.entity.Rate;
import com.river.persistence.dao.interfaces.RateDAO;

@Service
public class RateServiceImpl implements RateService {

	@Autowired
	RateDAO rateDAO;

	public RateDAO getRateDAO() {
		return rateDAO;
	}

	public void setRateDAO(RateDAO rateDAO) {
		this.rateDAO = rateDAO;
	}

	@Override
	@Transactional
	public Rate create(Rate toCreate) {
		return rateDAO.create(toCreate);
	}

	@Override
	@Transactional
	public Rate read(Rate toRead) {
		return rateDAO.read(toRead);
	}

	@Override
	@Transactional
	public List<Rate> read() {
		return rateDAO.read();
	}

	@Override
	@Transactional
	public Rate update(Rate toUpdate) {
		return rateDAO.update(toUpdate);
	}

	@Override
	@Transactional
	public Rate delete(Rate toDelete) {
		return rateDAO.delete(toDelete);
	}

}
