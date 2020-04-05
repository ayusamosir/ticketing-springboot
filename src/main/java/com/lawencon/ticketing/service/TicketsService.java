package com.lawencon.ticketing.service;

import java.util.List;

import com.lawencon.ticketing.model.Tickets;

public interface TicketsService {
	abstract Tickets insertTicket(Tickets ticket) throws Exception;

	abstract Tickets updateTicket(Long id) throws Exception;

	abstract List<Tickets> showTicket() throws Exception;

	abstract void deleteTicket(Long id) throws Exception;

}
