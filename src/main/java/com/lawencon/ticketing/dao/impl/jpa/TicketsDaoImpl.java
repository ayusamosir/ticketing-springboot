package com.lawencon.ticketing.dao.impl.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.dao.TicketsDao;
import com.lawencon.ticketing.model.Discount;
import com.lawencon.ticketing.model.TicketType;
import com.lawencon.ticketing.model.Tickets;

@Repository("tick_repo_jpa")
public class TicketsDaoImpl implements TicketsDao {
	@Autowired
	TicketsRepo ticketRepo;

	@Override
	public Tickets insertTicket(Tickets ticket) throws Exception {
		TicketType tickType = new TicketType();
		if (tickType.getType() != null) {
			Discount disc = new Discount();
			disc.getId();
			ticket.setDepartDate(LocalDate.now());
			ticket.setTickType(tickType);
			ticket.setDisc(disc);
			if (disc.getCodeVouc() != null) {
				ticket.setPrice(tickType.getPrice() - disc.getDiscount());
			} else {
				ticket.setPrice(tickType.getPrice());
			}
			ticketRepo.save(ticket);
		}
		return ticket;
	}

	@Override
	public Tickets updateTicket(Long id) throws Exception {
		List<Tickets> listTicket = new ArrayList<>();
		listTicket = ticketRepo.findAllById(id);
		if(listTicket.get(0).getId()!= null) {
			Tickets tick = new Tickets();
			TicketType tickType = new TicketType();
			Discount disc = new Discount();
			disc.getId();
			tick.setDepartDate(LocalDate.now());
			tick.setNoChair(listTicket.get(0).getNoChair());
			tick.setTickType(tickType);
			tick.setDisc(disc);
			ticketRepo.save(tick);
			return tick;
		}
		return null;
	}

	@Override
	public List<Tickets> showTicket() throws Exception {
		return ticketRepo.findAll();
	}

	@Override
	public void deleteTicket(Long id) throws Exception {
		ticketRepo.deleteById(id);
	}
	

}
