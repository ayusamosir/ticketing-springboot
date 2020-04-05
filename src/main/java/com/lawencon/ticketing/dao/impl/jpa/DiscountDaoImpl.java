package com.lawencon.ticketing.dao.impl.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.dao.DiscountDao;
import com.lawencon.ticketing.model.Discount;
import com.lawencon.ticketing.model.TicketType;

@Repository("disc_repo_jpa")
public class DiscountDaoImpl implements DiscountDao{
	@Autowired
	DiscountRepo discRepo;

	@Override
	public Discount insertDisc(Discount disc) throws Exception {
		TicketType tickType = new TicketType();
		tickType.getId();
		disc.setTicketType(tickType);
		return discRepo.save(disc);
	}

	@Override
	public Discount updateDisc(Long id) throws Exception {
		List<Discount> listDisc = new ArrayList<>();
		listDisc = discRepo.findAllById(id);
		if(listDisc.get(0).getCodeVouc()!=null) {
			Discount disc = new Discount();
			disc.setCodeVouc(listDisc.get(0).getCodeVouc());
			TicketType tickType = new TicketType();
			tickType.getId();
			disc.setTicketType(tickType);
			discRepo.save(disc);
			return disc;
		}
		return null;
	}

	@Override
	public List<Discount> showDisc() throws Exception {
		return discRepo.findAll();
	}

	@Override
	public void deleteDisc(Long id) throws Exception {
		discRepo.deleteById(id);
		
	}

}
