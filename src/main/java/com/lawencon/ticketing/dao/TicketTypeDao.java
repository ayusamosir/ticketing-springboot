package com.lawencon.ticketing.dao;

import java.util.List;

import com.lawencon.ticketing.model.TicketType;

public interface TicketTypeDao {
	abstract TicketType insertTickType(TicketType ticketType) throws Exception;

	abstract TicketType updateTickType(Long id) throws Exception;

	abstract List<TicketType> showTickType() throws Exception;

	abstract void deleteTickType(Long id) throws Exception;
}
