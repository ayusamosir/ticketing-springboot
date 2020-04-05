package com.lawencon.ticketing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.ticketing.dao.TicketTypeDao;
import com.lawencon.ticketing.model.TicketType;

@Service
@Transactional
public class TicketTypeServiceImpl implements TicketTypeService {
	
	@Autowired
	@Qualifier("ticktype_repo_jpa")
	TicketTypeDao tickTypeDao;
	
	@Override
	public TicketType insertTickType(TicketType ticketType) throws Exception {
		return tickTypeDao.insertTickType(ticketType);
	}

	@Override
	public TicketType updateTickType(Long id) throws Exception {
		return tickTypeDao.updateTickType(id);
	}

	@Override
	public List<TicketType> showTickType() throws Exception {
		return tickTypeDao.showTickType();
	}

	@Override
	public void deleteTickType(Long id) throws Exception {
		tickTypeDao.deleteTickType(id);
		
	}

}
