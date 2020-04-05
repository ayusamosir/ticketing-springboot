package com.lawencon.ticketing.dao.impl.jpa;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{
	
	List<Customer> findAllById(Long id);
	
}
