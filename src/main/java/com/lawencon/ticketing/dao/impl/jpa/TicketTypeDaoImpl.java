package com.lawencon.ticketing.dao.impl.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.dao.TicketTypeDao;
import com.lawencon.ticketing.model.TicketType;

@Repository("ticktype_repo_jpa")
public class TicketTypeDaoImpl implements TicketTypeDao{
	@Autowired
	TicketTypeRepo tickTypeRepo;
	
	@Override
	public TicketType insertTickType(TicketType ticketType) throws Exception {
		return tickTypeRepo.save(ticketType);
	}

	@Override
	public TicketType updateTickType(Long id) throws Exception {
		List<TicketType> listTickType = new ArrayList<TicketType>();
		listTickType = tickTypeRepo.findAllById(id);
		if(listTickType.get(0).getType()!=null) {
			TicketType tickType = new TicketType();
			tickType.setType(listTickType.get(0).getType());
			tickType.setPrice(listTickType.get(0).getPrice());
			tickTypeRepo.save(tickType);
			return tickType;
		}
		return null;
	}

	@Override
	public List<TicketType> showTickType() throws Exception {
		return tickTypeRepo.findAll();
	}

	@Override
	public void deleteTickType(Long id) throws Exception {
		tickTypeRepo.deleteById(id);
	}

}
