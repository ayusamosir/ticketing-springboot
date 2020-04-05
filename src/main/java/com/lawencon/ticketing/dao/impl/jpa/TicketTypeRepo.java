package com.lawencon.ticketing.dao.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.model.TicketType;

@Repository
public interface TicketTypeRepo extends JpaRepository<TicketType, Long> {
	
	List<TicketType> findAllById(Long id);

}
