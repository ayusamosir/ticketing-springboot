package com.lawencon.ticketing.dao.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.model.Tickets;

@Repository
public interface TicketsRepo extends JpaRepository<Tickets, Long>{
	
	List<Tickets> findAllById(Long id);

}
