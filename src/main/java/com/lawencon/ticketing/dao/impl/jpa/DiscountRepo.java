package com.lawencon.ticketing.dao.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.model.Discount;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long>{
	List<Discount> findAllById(Long id);
}
