package com.lawencon.ticketing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.ticketing.dao.DiscountDao;
import com.lawencon.ticketing.model.Discount;

@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	@Qualifier("disc_repo_jpa")
	DiscountDao discDao;

	@Override
	public Discount insertDisc(Discount disc) throws Exception {
		return discDao.insertDisc(disc);
	}

	@Override
	public Discount updateDisc(Long id) throws Exception {
		return discDao.updateDisc(id);
	}

	@Override
	public List<Discount> showDisc() throws Exception {
		return discDao.showDisc();
	}

	@Override
	public void deleteDisc(Long id) throws Exception {
		discDao.deleteDisc(id);
		
	}

}
