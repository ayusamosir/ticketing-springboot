package com.lawencon.ticketing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.ticketing.dao.TicketsDao;
import com.lawencon.ticketing.model.Tickets;

@Service
@Transactional
public class TicketsServiceImpl implements TicketsService {
	
	@Autowired
	@Qualifier("tick_repo_jpa")
	TicketsDao tickDao;
	
	@Override
	public Tickets insertTicket(Tickets ticket) throws Exception {
		return tickDao.insertTicket(ticket);
	}

	@Override
	public Tickets updateTicket(Long id) throws Exception {
		return tickDao.updateTicket(id);
	}

	@Override
	public List<Tickets> showTicket() throws Exception {
		return tickDao.showTicket();
	}

	@Override
	public void deleteTicket(Long id) throws Exception {
		tickDao.deleteTicket(id);
		
	}

}
